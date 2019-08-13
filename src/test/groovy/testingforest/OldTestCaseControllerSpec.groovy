package testingforest

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class OldTestCaseControllerSpec extends Specification implements DataTest, ControllerUnitTest<OldTestCaseController> {
    def setup() {
        mockDomain User
        mockDomain Project
        mockDomain TestCase
    }
    def cleanup() {
    }
    void "Deleting old test case"() {
        given:
        User user = new User( name: "user12", role: "user", login: "test", password: "strongPassword")
        user.save()
        session.user = user
        Project project = new Project(projectName: "coolProject", dateCreated: "01.01.2018",
                lastUpdated: "01.01.2018", teamList: [user])
        project.save()
        def date=new Date()
        //180 days ~ 6 months
        date =date.minus(181)
        TestCase test = new TestCase(caseName: "testcase_1", typeCase: "public",
                sizeData: new Long(0), project: project, userCreated: user,lastUpdated:date, dateCreated:date )
        test.save()
        when:
        controller.delete()
        then:
        TestCase.list().size() == 0
    }
}





package testingforest

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import org.grails.plugins.testing.GrailsMockMultipartFile
import spock.lang.Specification

class TestCaseControllerSpec extends Specification
        implements DataTest, ControllerUnitTest<TestCaseController> {
    def setupSpec() {
        mockDomain User
        mockDomain Project
        mockDomain TestCase
    }
    def setup() {
    }

    def cleanup() {
    }

    void "Test test case list"() {
        given:
        User user = new User(name: "user1", role: "user", login: "user", password: "12345")
        user.save()
        Project project_1 = new Project(projectName: "project1", teamList: [user])
        project_1.save()
        Project project_2 = new Project(projectName: "project2", teamList: [user])
        project_2.save()
        def array = [0, 0, 0, 0, 0] as byte[]
        TestCaseDocument testCaseDocument_1 = new TestCaseDocument(name:"test_1", sizeData: new Long(10), type: "txt", data: array)
        TestCaseDocument testCaseDocument_2 = new TestCaseDocument(name:"test_2", sizeData: new Long(10), type: "txt", data: array)
        testCaseDocument_1.save()
        testCaseDocument_2.save()
        TestCase test_1 = new TestCase(caseName: "test1", typeCase: "public",
                sizeData: new Long(0), project: project_1, userCreated: user, caseData: testCaseDocument_1)
        test_1.save()
        TestCase test_2 = new TestCase(caseName: "test1", typeCase: "public",
                sizeData: new Long(0), project: project_2, userCreated: user, caseData: testCaseDocument_2)
        test_2.save()

        when:
        controller.list(project_1.id)

        then:
        params.testCaseListFiltered.size() == 1
    }

    void "Test test case save"() {
        given:
        controller.request.method = 'POST'
        User user = new User(name: "user1", role: "user", login: "user", password: "12345")
        user.save()
        Project project = new Project(projectName: "test", teamList: [user])
        project.save()
        session.projectId = project.id
        session.user = user
        TestCase test = new TestCase(caseName: "test", typeCase: "public")
        TestCaseDocument testCaseDocument = new TestCaseDocument()
        params.data = new GrailsMockMultipartFile('requestParamName', 'someExcelFile.xls', 'application/vnd.ms-excel', "1234567" as byte[])


        when: "Save executed"
        controller.save(test,testCaseDocument)

        then: "User should be saved"
        TestCase.count == 1
        TestCase.find {member -> member.userCreated == user} == test
        TestCase.find {member -> member.project == project} == test
        TestCase.find {member -> member.typeCase == "public"} == test
        TestCase.find {member -> member.caseData == testCaseDocument} == test
    }
}

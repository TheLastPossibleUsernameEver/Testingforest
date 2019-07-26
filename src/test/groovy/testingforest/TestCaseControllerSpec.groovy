package testingforest

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
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
        TestCase test_1 = new TestCase(caseName: "test1", typeCase: "public",
                sizeData: new Long(0), project: project_1, userCreated: user)
        test_1.save()
        TestCase test_2 = new TestCase(caseName: "test1", typeCase: "public",
                sizeData: new Long(0), project: project_2, userCreated: user)
        test_2.save()

        when:
        controller.list(project_1.id)

        then:
        model.testCaseSet.size() == 1
    }
}

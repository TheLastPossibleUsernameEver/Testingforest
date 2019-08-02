package testingforest

import grails.testing.web.UrlMappingsUnitTest
import spock.lang.Specification

class UrlMappingsSpec extends Specification implements UrlMappingsUnitTest<UrlMappings> {

    def setup() {
        mockController(UserController)
        mockController(ProjectController)
        mockController(TestCaseController)
    }

    def cleanup() {
    }

    void "Test log_in url mapping"() {
        expect:
        verifyForwardUrlMapping("/user/log_in", controller: 'user',
                action: 'log_in', method: 'GET')

        when:
        assertForwardUrlMapping("/user/log_in", controller: 'user',
                action: 'log_in', method: 'GET')

        then:
        noExceptionThrown()
    }

    void "Test authenticate url mapping"() {
        when:
        request.method = "POST"
        assertForwardUrlMapping("/user/authenticate", controller: 'user',
                action: 'authenticate', method: 'POST')

        then:
        noExceptionThrown()
    }

    void "Test user/save url mapping"() {
        when:
        request.method = "POST"
        assertForwardUrlMapping("/user/save", controller: 'user',
                action: 'save', method: 'POST')

        then:
        noExceptionThrown()
    }

    void "Test logout url mapping"() {
        expect:
        verifyForwardUrlMapping("/user/logout", controller: 'user',
                action: 'logout', method: 'GET')

        when:
        assertForwardUrlMapping("/user/logout", controller: 'user',
                action: 'logout', method: 'GET')

        then:
        noExceptionThrown()
    }

    void "Test user/create url mapping"() {
        expect:
        verifyForwardUrlMapping("/user/create", controller: 'user',
                action: 'create', method: 'GET')

        when:
        assertForwardUrlMapping("/user/create", controller: 'user',
                action: 'create', method: 'GET')

        then:
        noExceptionThrown()
    }

    void "Test project/index url mapping"() {
        expect:
        verifyForwardUrlMapping("/project/index", controller: 'project',
                action: 'index', method: 'GET')

        when:
        assertForwardUrlMapping("/project/index", controller: 'project',
                action: 'index', method: 'GET')

        then:
        noExceptionThrown()
    }

    void "Test project/create url mapping"() {
        expect:
        verifyForwardUrlMapping("/project/create", controller: 'project',
                action: 'create', method: 'GET')

        when:
        assertForwardUrlMapping("/project/create", controller: 'project',
                action: 'create', method: 'GET')

        then:
        noExceptionThrown()
    }

    void "Test project/save url mapping"() {
        when:
        request.method = "POST"
        assertForwardUrlMapping("/project/save", controller: 'project',
                action: 'save', method: 'POST')

        then:
        noExceptionThrown()
    }

    void "Test project/addingUser url mapping"() {
        when:
        request.method = "POST"
        assertForwardUrlMapping("/project/addingUser", controller: 'project',
                action: 'addingUser', method: 'POST')

        then:
        noExceptionThrown()
    }

    void "Test project/addUserProject url mapping"() {
        expect:
        verifyForwardUrlMapping("/project/1/addUserProject", controller: 'project',
                action: 'addUserProject', method: 'GET'){
            projectId = 1
        }

        when:
        assertForwardUrlMapping("/project/1/addUserProject", controller: 'project',
                action: 'addUserProject', method: 'GET'){
            projectId = 1
        }

        then:
        noExceptionThrown()
    }

    void "Test /project/projectId/testCase/list url mapping"() {
        expect:
        verifyForwardUrlMapping("/project/1/testCase/list", controller: 'testCase',
                action: 'list', method: 'GET') {projectId = 1}

        when:
        assertForwardUrlMapping("/project/1/testCase/list", controller: 'testCase',
                action: 'list', method: 'GET') {projectId = 1}

        then:
        noExceptionThrown()
    }

    void "Test /project/delete/projectId url mapping"() {
        when:
        request.method = "DELETE"
        assertUrlMapping("/project/delete/1", controller: 'project',
                action: 'delete', method: 'DELETE') {projectId = 1}

        then:
        noExceptionThrown()
    }

    void "Test project/leaveProject url mapping"() {
        when:
        request.method = "PUT"
        assertUrlMapping("/project/leaveProject/1", controller: 'project',
                action: 'leaveProject', method: 'PUT') {projectId = 1}

        then:
        noExceptionThrown()
    }

    void "Test testCase/save url mapping"() {
        when:
        request.method = "POST"
        assertUrlMapping("/testCase/save", controller: 'testCase',
                action: 'save', method: 'POST')

        then:
        noExceptionThrown()
    }

    void "Test testCase/create url mapping"() {
        when:
        request.method = "GET"
        assertUrlMapping("/project/1/testCase/create", controller: 'testCase',
                action: 'create', method: 'GET') {projectId = 1}

        then:
        noExceptionThrown()
    }

    void "User controller log_in action"() {
        expect:
        verifyAction('user', 'log_in')

        when:
        assertAction('user', 'log_in')

        then:
        noExceptionThrown()
    }

    void "User controller authenticate action"() {
        expect:
        verifyAction('user', 'authenticate')

        when:
        assertAction('user', 'authenticate')

        then:
        noExceptionThrown()
    }

    void "User controller logout action"() {
        expect:
        verifyAction('user', 'logout')

        when:
        assertAction('user', 'logout')

        then:
        noExceptionThrown()
    }

    void "User controller create action"() {
        expect:
        verifyAction('user', 'create')

        when:
        assertAction('user', 'create')

        then:
        noExceptionThrown()
    }

    void "Project controller create action"() {
        expect:
        verifyAction('project', 'create')

        when:
        assertAction('project', 'create')

        then:
        noExceptionThrown()
    }

    void "User controller save action"() {
        expect:
        verifyAction('user', 'save')

        when:
        assertAction('user', 'save')

        then:
        noExceptionThrown()
    }

    void "Project controller save action"() {
        expect:
        verifyAction('project', 'save')

        when:
        assertAction('project', 'save')

        then:
        noExceptionThrown()
    }

    void "Project controller index action"() {
        expect:
        verifyAction('project', 'index')

        when:
        assertAction('project', 'index')

        then:
        noExceptionThrown()
    }

    void "Project controller addUserProject action"() {
        expect:
        verifyAction('project', 'addUserProject')

        when:
        assertAction('project', 'addUserProject')

        then:
        noExceptionThrown()
    }

    void "Project controller addingUser action"() {
        expect:
        verifyAction('project', 'addingUser')

        when:
        assertAction('project', 'addingUser')

        then:
        noExceptionThrown()
    }

    void "Project testCase list action"() {
        expect:
        verifyAction('testCase', 'list')

        when:
        assertAction('testCase', 'list')

        then:
        noExceptionThrown()
    }

    void "Project project delete action"() {
        expect:
        verifyAction('project', 'delete')

        when:
        assertAction('project', 'delete')

        then:
        noExceptionThrown()
    }

    void "Project project leaveProject action"() {
        expect:
        verifyAction('project', 'leaveProject')

        when:
        assertAction('project', 'leaveProject')

        then:
        noExceptionThrown()
    }

    void "Test testCase save action"() {
        expect:
        verifyAction('testCase', 'save')

        when:
        assertAction('testCase', 'save')

        then:
        noExceptionThrown()
    }

    void "Test testCase create action"() {
        expect:
        verifyAction('testCase', 'create')

        when:
        assertAction('testCase', 'create')

        then:
        noExceptionThrown()
    }
    void "User controller showInfo action"() {
        expect:
        verifyAction('user', 'showInfo')

        when:
        assertAction('user', 'showInfo')

        then:
        noExceptionThrown()
    }
    void "User controller deleteCurrentUser action"() {
        expect:
        verifyAction('user', 'deleteCurrentUser')

        when:
        assertAction('user', 'deleteCurrentUser')

        then:
        noExceptionThrown()
    }
}
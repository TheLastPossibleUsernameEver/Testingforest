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

    void "Project controller index action"() {
        expect:
        verifyAction('project', 'index')

        when:
        assertAction('project', 'index')

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
}
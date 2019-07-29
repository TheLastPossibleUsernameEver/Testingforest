package testingforest

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class LogoutInterceptorSpec extends Specification implements InterceptorUnitTest<LogoutInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test logout interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"user", action: "logout")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }

    void "Test project/index interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "index")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/addUserProject interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "addUserProject")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/addingUser interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "addingUser")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test /project/projectId/testCase/list interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"testCase", action: "list",)

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/show interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "show")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/delete interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "delete")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/leaveProject interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "leaveProject")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/create interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "create")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }
}

package testingforest

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ProjectInterceptorSpec extends Specification implements InterceptorUnitTest<ProjectInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test project/addUserProject interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "addUserProject")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test testCase/list interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"testCase", action: "list")

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

    void "Test testCase/create interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"testCase", action: "create")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test testCaseDocument/download interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"testCaseDocument", action: "download")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test project/edit interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"project", action: "edit")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }
}

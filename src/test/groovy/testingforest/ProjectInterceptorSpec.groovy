package testingforest

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ProjectInterceptorSpec extends Specification implements InterceptorUnitTest<ProjectInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test testCase/list interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"testCase", action: "list")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}

package testingforest

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class TestCaseInterceptorSpec extends Specification implements InterceptorUnitTest<TestCaseInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test testCase/show interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"testCase", action: "show")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test testCase/edit interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"testCase", action: "edit")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }
}

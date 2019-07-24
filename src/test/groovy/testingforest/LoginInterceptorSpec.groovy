package testingforest

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class LoginInterceptorSpec extends Specification implements InterceptorUnitTest<LoginInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test login interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"user", action: "log_in")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }

    void "Test authenticate interceptor matching"() {
        when:"A request matches the interceptor"
        withRequest(controller:"user", action: "authenticate")

        then:"The interceptor does match"
        interceptor.doesMatch()
    }
}

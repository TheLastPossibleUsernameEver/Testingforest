package testingforest

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class RegistrationInterceptorSpec extends Specification implements InterceptorUnitTest<RegistrationInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test registration interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"registration")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}

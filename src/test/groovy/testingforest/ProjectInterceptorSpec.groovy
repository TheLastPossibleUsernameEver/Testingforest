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
}

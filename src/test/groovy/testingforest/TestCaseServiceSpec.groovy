package testingforest

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class TestCaseServiceSpec extends Specification implements ServiceUnitTest<TestCaseService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}

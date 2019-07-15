package testingforest

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestCaseSpec extends Specification implements DomainUnitTest<TestCase> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}

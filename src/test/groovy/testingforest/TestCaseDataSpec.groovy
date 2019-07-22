package testingforest

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestCaseDataSpec extends Specification implements DomainUnitTest<TestCaseData> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}

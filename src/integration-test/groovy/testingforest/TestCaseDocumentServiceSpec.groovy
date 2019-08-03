package testingforest

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory
/*
@Integration
@Rollback
class TestCaseDataServiceSpec extends Specification {

    TestCaseDataService testCaseDataService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TestCaseData(...).save(flush: true, failOnError: true)
        //new TestCaseData(...).save(flush: true, failOnError: true)
        //TestCaseData testCaseData = new TestCaseData(...).save(flush: true, failOnError: true)
        //new TestCaseData(...).save(flush: true, failOnError: true)
        //new TestCaseData(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //testCaseData.id
    }

    void "test get"() {
        setupData()

        expect:
        testCaseDataService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TestCaseData> testCaseDataList = testCaseDataService.list(max: 2, offset: 2)

        then:
        testCaseDataList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testCaseDataService.count() == 5
    }

    void "test delete"() {
        Long testCaseDataId = setupData()

        expect:
        testCaseDataService.count() == 5

        when:
        testCaseDataService.delete(testCaseDataId)
        sessionFactory.currentSession.flush()

        then:
        testCaseDataService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TestCaseData testCaseData = new TestCaseData()
        testCaseDataService.save(testCaseData)

        then:
        testCaseData.id != null
    }
}
*/
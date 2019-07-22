package testingforest

import grails.gorm.services.Service

@Service(TestCaseData)
interface TestCaseDataService {

    TestCaseData get(Serializable id)

    List<TestCaseData> list(Map args)

    Long count()

    void delete(Serializable id)

    TestCaseData save(TestCaseData testCaseData)

}
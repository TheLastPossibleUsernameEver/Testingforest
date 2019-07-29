package testingforest

import grails.gorm.services.Service

@Service(TestCaseDocument)
interface TestCaseDocumentService {

    TestCaseDocument get(Serializable id)

    List<TestCaseDocument> list(Map args)

    Long count()

    void delete(Serializable id)

    TestCaseDocument save(TestCaseDocument testCaseDocument)

}
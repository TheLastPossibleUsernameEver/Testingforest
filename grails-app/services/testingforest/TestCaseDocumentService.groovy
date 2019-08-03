package testingforest

import grails.gorm.transactions.Transactional

@Transactional
class TestCaseDocumentService {

    def get(Long id){
        TestCaseDocument.get(id)
    }

    def list(){
        TestCaseDocument.list()
    }

    def save(TestCaseDocument testCaseDocument){
        testCaseDocument.save()
    }

    def delete(Long id){
        TestCaseDocument.get(id).delete()
    }
    def count(){
        TestCaseDocument.count()
    }
}

package testingforest

import grails.gorm.transactions.Transactional

@Transactional
class TestCaseService {

    def list() {
        TestCase.list()
    }

    def get(Long id){
        TestCase.get(id)
    }

    def delete(Long id){
        TestCase.get(id).delete()
    }
}

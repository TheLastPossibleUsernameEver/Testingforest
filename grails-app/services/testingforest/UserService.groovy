package testingforest

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def get(Long id) {
        User.get(id)
    }

    def list(){
        User.list()
    }

    def count(){
        User.count()
    }

    def delete(Long id) {
        User.get(id).delete()
    }

    def save(User user) {
        user.save()
    }
}
package testingforest

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def get(Long id){
        User.get(id)
    }

    def list(){
        User.list()
    }

    def save(User user){
        user.save()
    }

    def delete(Long id){
        User.get(id).delete()
    }

}

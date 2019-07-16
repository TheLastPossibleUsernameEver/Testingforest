package testingforest

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Service(User)
interface UserService {
    @Transactional
    User get(Serializable id)
    @Transactional
    List<User> list(Map args)
    @Transactional
    Long count()
    @Transactional
    void delete(Serializable id)
    @Transactional
    User save(User user)
}
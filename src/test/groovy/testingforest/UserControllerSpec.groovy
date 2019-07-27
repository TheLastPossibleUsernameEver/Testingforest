package testingforest

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserControllerSpec extends Specification implements
        ControllerUnitTest<UserController>, DataTest {

    def setupSpec() {
        mockDomain User
    }


    def setup() {
    }

    def cleanup() {
    }

    void "Test authenticate"() {
        given:
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        params.login = "test"
        params.password = "12345"

        when:"Authenticate executed"
        controller.authenticate()


        then:"Session user is not null"
        session.user != null
        session.user.id == 1
    }

    void "Test logout"() {
        given:
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        session.user = user

        when:"Logout executed"
        controller.logout()

        then:"Session user should be null"
        session.user == null
    }

    void "Test save"() {
        given:
        controller.request.method = 'POST'
        User user = new User(name: "test", login: "test", password: "12345")


        when: "Save executed"
        controller.save(user)

        then: "User should be saved"
        User.list().size() == 1
        def userSaved = User.list()[0]
        userSaved.name == "test"
        userSaved.role == "user"
        userSaved.login == "test"
        userSaved.password == "12345".encodeAsSHA1()
    }
}

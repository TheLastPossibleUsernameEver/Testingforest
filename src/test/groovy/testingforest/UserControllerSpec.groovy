package testingforest

import grails.testing.web.controllers.ControllerUnitTest
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserControllerSpec extends Specification implements
        ControllerUnitTest<UserController>, DomainUnitTest<User> {

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

        when:"authenticate executed"
        controller.authenticate()


        then:"Session user is not null"
        session.user != null
    }

    void "Test logout"() {
        given:
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        session.user = user

        when:"logout executed"
        controller.logout()

        then:"Session user should be null"
        session.user == null
    }
}

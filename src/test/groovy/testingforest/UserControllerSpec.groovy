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

    void "Test update"() {
        given:
        controller.request.method = 'POST'
        User user = new User(name: "test", login: "test", password: "12345", role: "user")
        user.save(flush: true)
        controller.request.method = 'PUT'
        user.name = "test1"
        user.password = 123456

        when: "Save executed"
        controller.update(user)

        then: "User should be saved"
        User.list().size() == 1
        def userSaved = User.list()[0]
        userSaved.name == "test1"
        userSaved.role == "user"
        userSaved.login == "test"
        userSaved.password == "123456".encodeAsSHA1()
    }

   void "test deleteCurrentUser with 1 user"(){
      given:
         User user = new User( name: "user12", role: "user", login: "test", password: "strongPassword")
         user.save()
         session.user = user
         Project project = new Project(projectName: "coolProject", dateCreated: "01.01.2018",
                                       lastUpdated: "01.01.2018", teamList: [user])
         project.save()
         TestCase test = new TestCase(caseName: "testcase_1", typeCase: "public",
                                      sizeData: new Long(0), project: project, userCreated: user) 
         test.save()
         
      when: "User delete his account"
        controller.deleteCurrentUser()
      then:"User, all his testcases, project when he the only one removed"
        session.user==null
        User.list().size() ==0
        Project.list().size()==0
        TestCase.list().size()==0
     }
      void "test deleteCurrentUser with many user"(){
      given:
         User user = new User( name: "user1", role: "user", login: "user1", password: "strongPassword")
         user.save()
         User user2 = new User( name: "user2", role: "user", login: "user2", password: "verystrongPassword")
         user2.save()
         session.user = user
         Project project = new Project(projectName: "coolProject", dateCreated: "01.01.2018",
                                       lastUpdated: "01.01.2018", teamList: [user,user2])
         project.save()
         TestCase test = new TestCase(caseName: "testcase_1", typeCase: "public",
                                      sizeData: new Long(0), project: project, userCreated: user)
         test.save()
         TestCase test2 = new TestCase(caseName: "testcase_2", typeCase: "public",
                                      sizeData: new Long(0), project: project, userCreated: user2)
         test2.save()

      when: "User delete his account"
        controller.deleteCurrentUser()
      then:"User and all his testcase removed,but project remains "
        session.user==null
        User.list().size() ==1
        Project.list().size()==1
        TestCase.list().size()==1
     }
}

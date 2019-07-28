package testingforest

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ProjectControllerSpec extends Specification implements DataTest, ControllerUnitTest<ProjectController>{

    def setupSpec() {
        mockDomain User
        mockDomain Project
    }

    def setup() {
    }

    def cleanup() {
    }

    def "Test index"() {
        given:
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        session.user = user
        Project project_1 = new Project(projectName: "Hello world", dateCreated: "20.09.2011"
                , lastUpdated: "20.09.2011", teamList: [user])
        project_1.save()
        Project project_2 = new Project(projectName: "Project",
                dateCreated: "20.09.2013", lastUpdated: "20.09.2015", teamList: [user])
        project_2.save()

        when: 'The index action is executed'
        controller.index()

        then: 'The model is correct'
        model.projectList.size() == 2
        model.projectList.find { it.projectName == 'Hello world'}
        model.projectList.find { it.projectName == 'Project'}

    }

    def "Test addUserProject/addingUser"() {
        given:
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        session.user = user
        Project project_1 = new Project(projectName: "Hello world", dateCreated: "20.09.2011"
                , lastUpdated: "20.09.2011", teamList: [user])
        project_1.save()
        User newUser = new User( name: "test_1", role: "user", login: "test_1", password: "12345")
        newUser.save()
        params.login = "test_1"
        controller.projectService = Stub(ProjectService) {
            get() >> project_1
        }

        when: 'The actions is executed'
        controller.addUserProject(project_1.id)
        controller.addingUser()

        then: 'The model is correct'
        project_1.getTeamList().find {member -> if (member != null) member.login.equals("test")}
        project_1.getTeamList().find {member -> if (member != null) member.login.equals("test_1")}

    }

    def "Test create&save"(){
        given:
        controller.request.method = 'POST'
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        session.user = user
        Project project = new Project(projectName: "Hello world")


        when: "Save executed"
        controller.save(project)

        then: "Project should be saved"
        Project.list().size() == 1
        def projectSaved = Project.list()[0]
        projectSaved.projectName == "Hello world"
        projectSaved.teamList.contains(user)
    }
}

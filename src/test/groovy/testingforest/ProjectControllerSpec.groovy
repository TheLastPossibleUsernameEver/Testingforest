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

    def "Test leaveProject not delete project"() {
        given:
        controller.request.method = 'PUT'
        User user_1 = new User( name: "user_1", role: "user", login: "user_1", password: "12345")
        user_1.save()
        session.user = user_1
        Project project_1 = new Project(projectName: "Hello world", dateCreated: "20.09.2011"
                , lastUpdated: "20.09.2011", teamList: [user_1])
        project_1.save()
        User user_2 = new User( name: "user_2", role: "user", login: "user_2", password: "12345")
        user_2.save()
        project_1.addToTeamList(user_2)
        def service = Mock(ProjectService)
        controller.projectService = service

        when: 'The actions is executed'
        controller.leaveProject(project_1.id)

        then: 'The model is correct'
        Project.count == 1
        project_1.teamList.size() == 1
        project_1.teamList.find {member -> member.id == user_2.id} == user_2
    }

    def "Test leaveProject with delete project"() {
        given:
        controller.request.method = 'PUT'
        User user_1 = new User( name: "user_1", role: "user", login: "user_1", password: "12345")
        user_1.save()
        session.user = user_1
        Project project_1 = new Project(projectName: "Hello world", dateCreated: "20.09.2011"
                , lastUpdated: "20.09.2011", teamList: [user_1])
        project_1.save()
        Long projectId = project_1.id
        controller.projectService = Stub(ProjectService) {
            delete() >> project_1.delete()
        }

        when: 'The actions is executed'
        controller.leaveProject(projectId)

        then: 'The model is correct'
        !Project.exists(projectId)
    }

    def "Test delete project"() {
        given:
        controller.request.method = 'PUT'
        User user_1 = new User( name: "user_1", role: "user", login: "user_1", password: "12345")
        user_1.save()
        Project project_1 = new Project(projectName: "Hello world", dateCreated: "20.09.2011"
                , lastUpdated: "20.09.2011", teamList: [user_1])
        project_1.save()
        Long projectId = project_1.id
        controller.projectService = Stub(ProjectService) {
            get() >> project_1
            delete() >> project_1.delete()
        }

        when: 'The actions is executed'
        controller.delete(projectId)

        then: 'The model is correct'
        !Project.exists(projectId)
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

    def "Test update"(){
        given:
        controller.request.method = 'PUT'
        User user = new User( name: "test", role: "user", login: "test", password: "12345")
        user.save()
        session.user = user
        Project project = new Project(projectName: "Hello world", teamList: [user])
        project.save()
        project.projectName = "Hello world new"


        when: "Save executed"
        controller.update(project)

        then: "Project should be saved"
        Project.list().size() == 1
        def projectSaved = Project.list()[0]
        projectSaved.projectName == "Hello world new"
        projectSaved.teamList.contains(user)
    }
}

package testingforest

class ProjectController {

    def projectService

    def addUserProject(Long projectId){ // добавление к проекту юзера
        session.projectId = projectId //текущий проект в show
        respond projectService.get(projectId)
    }

    def addingUser(){
        def currUser = User.findByLogin(params.login)
        if(currUser){ //если он существует и если у него нет проекта
            def currProject = Project.get(session.projectId)
            def teamList = currProject.getTeamList()
            def result = teamList.find{member -> if (member != null) member.login.equals(currUser.login)}
            if(result == null) {
                currProject.addToTeamList(currUser).save(flush: true)
                flash.message = message(code: 'project.success.addUser.message', args: [params.login])
                redirect(uri: "/project/$session.projectId/addUserProject")
            }
            else {
                flash.error = message(code: 'user.already.in.project', args: [params.login])
                redirect(uri: "/project/$session.projectId/addUserProject")
            }
        }
        else{
            flash.error = message(code: 'user.login.not.exist')
            redirect(uri: "/project/$session.projectId/addUserProject")
        }
    }

    def index() {
        List<Project> projectList = []
        for(Project project:Project.all) {
            def teamList = project.getTeamList()
            def sessionUser = session.user
            def result = teamList.find{member -> if (member != null) member.login.equals(sessionUser.login)}
            if(result)
                projectList.add(project)
        }
        params.sizeList = projectList.size()
        respond projectList
    }

    def show(Long projectId) {
        Project project = projectService.get(projectId)
        params.projectName = project.projectName
        params.sizeTestCaseList = project.testCaseList.size()
        respond projectService.get(projectId)
    }

    def create() {
        respond new Project(params)

    }

    def save(Project project) {
        project.addToTeamList(session.user).save(flush: true)
        redirect uri: "/project/index"
    }

    def leaveProject(Long projectId) {
        Project project = Project.get(projectId)
        if (project) {
            User user = project.teamList.find { member -> member.id == session.user.id}
            project.removeFromTeamList(user)
            if (project.teamList.isEmpty()) {
                projectService.delete(projectId)
                redirect uri: "/project/index"
            } else {
                projectService.save(project)
                redirect uri: "/project/index"
            }
        } else {
            redirect uri: "/project/index"
        }
    }

    def delete(Long projectId) {
        projectService.delete(projectId)
        redirect uri: "/project/index"
    }
}

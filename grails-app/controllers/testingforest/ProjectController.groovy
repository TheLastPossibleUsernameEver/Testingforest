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
                flash.message = "User $currUser has added to project!"
                redirect(uri: "/project/$session.projectId/addUserProject")
            }
            else {
                flash.message = "User $currUser has already been in project!"
                redirect(uri: "/project/$session.projectId/addUserProject")
            }
        }
        else{
            flash.message = "Sorry. Please try another login."
            redirect(uri: "/project/$session.projectId/addUserProject")
        }
    }

    def index() {
        def projectList = []
        for(Project project:Project.all) {
            def teamList = project.getTeamList()
            def sessionUser = session.user
            def result = teamList.find{member -> if (member != null) member.login.equals(sessionUser.login)}
            if(result)
                projectList.add(project)
        }
        respond projectList
    }

    def show(Long id) {
        respond projectService.get(id)
    }

    def create() {
        respond new Project(params)

    }

    def save(Project project) {
        project.addToTeamList(session.user).save(flush: true)
        redirect action:"index"
    }

}

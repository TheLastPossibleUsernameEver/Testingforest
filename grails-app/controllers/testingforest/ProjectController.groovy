package testingforest

class ProjectController {

    def projectService

    def addUserProject(){ // добавление к проекту юзера
    }

    def addingUser(){
        def currUser = User.findByLogin(params.login)
        if(currUser){ //если он существует и если у него нет проекта
            def currProject = Project.get(session.project.id)
            currProject.addToTeamList(currUser).save(flush: true)
            flash.message = "User $currUser has added to project."
            redirect(action: "addUserProject")
        }
        else{
            flash.message = "Sorry. Please try another login."
            redirect(action: "addUserProject")
        }
    }

    def backToShow(){
        redirect(action: "show", id:  session.project.id)
    }

    def index() {
        session.project = null //обнуляем текущий проект
        def projectList = []
        for(Project project:Project.all) {
            for (User user : project.getTeamList())
                if (user.getLogin().equals(session.user.login)) {
                    projectList.add(project)
                }
        }
        respond projectList
    }

    def show(Long id) {
        session.project = Project.get(id) //текущий проект в show
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

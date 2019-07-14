package testingforest

class ProjectController {

    def projectService

    def project_list(){  //вывод проекта для залогинненого пользователя
        for(Project project:Project.all) {
            for (User user : project.getTeamList())
                if (user.getLogin().equals(session.user.login)) {
                    redirect(action: "show", id:  project.id)
                    return
                }
        }
        redirect(action: "index")
    }

    def add_user_project(){ // добавление к проекту юзера
    }

    def adding_user(){
        def curr_user = User.findByLogin(params.login)
        if(curr_user){ //если он существует и если у него нет проекта
            for(Project project:Project.all) {
                for (User user : project.getTeamList())
                    if (user.getLogin().equals(curr_user.getLogin())) {
                        flash.message = "Current user has already had project."
                        redirect(action: "add_user_project")
                        return
                    }
            }
            for(Project project:Project.all) {
                for (User user : project.getTeamList())
                    if (user.getLogin().equals(session.user.login)) {
                        project.addToTeamList(curr_user).save(flush: true)
                        flash.message = "User $curr_user has added to project."
                        redirect(action: "add_user_project")
                        return
                    }
            }
        }
        else{
            flash.message = "Sorry. Please try another login."
            redirect(action: "add_user_project")
        }
    }

    def back_to_show(){
        for(Project project:Project.all) {
            for (User user : project.getTeamList())
                if (user.getLogin().equals(session.user.login)) {
                    redirect(action: "show", id:  project.id)
                    return
                }
        }
    }

    def index() {
    }

    def show(Long id) {
        respond projectService.get(id)
    }

    def create() {
        respond new Project(params)

    }

    def save(Project project) {
        project.addToTeamList(session.user).save(flush: true)
        redirect action:"project_list"
    }

}

package testingforest

class UserController {

    def userService

    def index = {
        redirect(action: "log_in")
    }

    def log_in = {}

    def authenticate = {
        def hexPassword = params.password//.encodeAsSHA1()
        def user = User.findByLoginAndPassword(params.login, hexPassword)
        if(user){
            session.user = user
            redirect(controller: "project", action: "index")
        }
        else{
            flash.message = "Sorry, ${params.login}. Please try another login/password."
            redirect(action: "log_in")
        }
    }

    def logout = {
        if(session.user != null) {
            flash.message = "Goodbye ${session.user.name}"
            session.user = null
        }
        redirect(action: "log_in")
    }

}

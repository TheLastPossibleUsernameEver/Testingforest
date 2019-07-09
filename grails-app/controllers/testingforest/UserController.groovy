package testingforest

class UserController {

    def index = {
        redirect(action: "log_in")
    }

    def log_in = {}

    def authenticate = {
        def user = User.findByLoginAndPassword(params.login, params.password)
        if(user){
            session.user = user
            flash.message = "Hello ${user.name}"
            redirect(action: "log_in")
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

package testingforest

class LoginInterceptor {

    LoginInterceptor() {
        match(controller: "user", action: "log_in")
        match(controller: "user", action: "authenticate")
    }

    boolean before() {
        if(session.user){
            redirect uri: "/project/index"
            false
        } else {
            true
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}

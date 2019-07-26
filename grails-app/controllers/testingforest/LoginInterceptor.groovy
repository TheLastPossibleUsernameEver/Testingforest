package testingforest

class LoginInterceptor {

    LoginInterceptor() {
        match(controller: "user", action: "log_in")
        match(controller: "user", action: "authenticate")
        match(controller: "user", action: "create")
        match(controller: "user", action: "save")
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

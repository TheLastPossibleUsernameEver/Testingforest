package testingforest

class LogoutInterceptor {

    LogoutInterceptor() {
        match(controller: "user", action: "logout")
    }

    boolean before() {
        if (session.user){
            true
        } else {
            redirect uri: "/user/log_in"
            false
        }
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}

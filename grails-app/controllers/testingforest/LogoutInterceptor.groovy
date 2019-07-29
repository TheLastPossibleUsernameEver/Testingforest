package testingforest

class LogoutInterceptor {

    int order = HIGHEST_PRECEDENCE

    LogoutInterceptor() {
        match(controller: "user", action: "logout")
        match(controller: "project", action: "index")
        match(controller: "project", action: "addUserProject")
        match(controller: "project", action: "addingUser")
        match(controller: "testCase", action: "list")
        match(controller: "project", action: "show")
        match(controller: "project", action: "leaveProject")
        match(controller: "project", action: "delete")
        match(controller: "project", action: "create")
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

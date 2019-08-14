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
        match(controller: "testCase", action: "save")
        match(controller: "testCase", action: "create")
        match(controller: "testCase", action: "edit")
        match(controller: "testCase", action: "update")
        match(controller: "user", action: "showInfo")
        match(controller: "user", action: "deleteCurrentUser")
        match(controller: "testCaseDocument", action: "download")
        match(controller: "user", action: "edit")
        match(controller: "user", action: "update")
        match(controller: "project", action: "edit")
        match(controller: "project", action: "update")
        match(controller: "feed", action: "list")
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

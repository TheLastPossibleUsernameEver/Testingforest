package testingforest

class UrlMappings {

    static mappings = {
        //TestCase controller uri
        get "/project/$projectId/testCase/list"(controller: "testCase", action: "list")
        get "/project/$projectId/testCase/create"(controller: "testCase", action: "create")
        post "/testCase/save"(controller: "testCase", action: "save")
        get "/testCase/show/$testCaseId"(controller: "testCase", action: "show")
        get "/testCase/edit/$testCaseId"(controller: "testCase", action: "edit")
        put "/testCase/update/$id"(controller: "testCase", action: "update")
        delete "/testCase/delete/$testCaseId"(controller: "testCase", action: "delete")

        //TestCaseDocument controller uri
        get "/project/$projectId/testCaseDocument/downloadDocument/$testCaseId"(controller: "testCaseDocument", action:"download")

        //User controller uri
        get "/user/index"(controller: "user", action: "index")
        get "/user/log_in"(controller: "user", action: "log_in")
        post "/user/authenticate"(controller:  "user", action: "authenticate")
        get "/user/logout"(controller: "user", action: "logout")
        get "/user/show/$id"(controller: "user", action: "show")
        get "/user/create"(controller: "user", action: "create")
        post "/user/save"(controller: "user", action: "save")
        get "/user/edit/$userId"(controller: "user", action: "edit")
        put "/user/update"(controller: "user", action: "update")
        delete "/user/delete/$id"(controller: "user", action: "delete")
        get "/user/showInfo"(controller: "user", action: "showInfo")
        delete "/user/deleteCurrentUser" (controller: "user", action: "deleteCurrentUser")

        //Project controller uri
        get "/project/$projectId/addUserProject"(controller: "project", action: "addUserProject")
        post "/project/addingUser"(controller: "project", action: "addingUser")
        get "/project/index"(controller: "project", action: "index")
        get "/project/show/$projectId"(controller: "project", action: "show")
        get "/project/create"(controller: "project", action: "create")
        post "/project/save"(controller: "project", action: "save")
        delete "/project/delete/$projectId"(controller: "project", action: "delete")
        put "/project/leaveProject/$projectId"(controller: "project", action: "leaveProject")

        //Diagnostic controller uri
        get "/diagnostics/index"(controller: "diagnostics", action: "index")

        /*
        //Init version
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        */

        "/"(controller: "user", action: "log_in")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

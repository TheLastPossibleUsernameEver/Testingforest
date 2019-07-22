package testingforest

class UrlMappings {

    static mappings = {
        get "/project/$projectId/testCase/create"(controller: "testCase", action: "create")
        post "/testCase/save"(controller: "testCase", action: "save")
        get "/project/$projectId/addUserProject"(controller: "project", action: "addUserProject")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }



        "/"(controller: "user", action: "log_in")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

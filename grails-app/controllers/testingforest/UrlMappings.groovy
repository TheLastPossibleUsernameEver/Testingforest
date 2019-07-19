package testingforest

class UrlMappings {

    static mappings = {
        get "/project/$projectId/testCase/create"(controller: "testCase", action: "create")
        post "/testCase/save"(controller: "testCase", action: "save")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }



        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}

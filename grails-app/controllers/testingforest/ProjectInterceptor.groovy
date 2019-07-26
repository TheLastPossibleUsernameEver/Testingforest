package testingforest


class ProjectInterceptor {

    ProjectInterceptor(){
        match(controller: "testCase", action: "list")
    }

    boolean before() {
        def project = Project.get(params.projectId)
        def teamList = project.getTeamList()
        def sessionUser = session.user
        def result = teamList.find{member -> if (member != null) member.login.equals(sessionUser.login)}
        if(result) {  //if we found user in project
            true
        }
        else {
            redirect(uri:"/project/index")
            false
        }
    }
}
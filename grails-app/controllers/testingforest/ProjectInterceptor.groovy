package testingforest


class ProjectInterceptor {

    ProjectInterceptor(){
        match(controller: "project", action: "addUserProject")
        match(controller: "project", action: "addingUser")
    }

    boolean after() {
        def project = Project.get(session.projectId)
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

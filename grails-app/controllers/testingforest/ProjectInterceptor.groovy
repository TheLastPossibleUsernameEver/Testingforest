package testingforest


class ProjectInterceptor {

    ProjectInterceptor(){
        match(controller: "project", action: "addUserProject")
    }

    boolean before(){
        def project = Project.get(params.projectId)
        if(project == null){
            redirect(uri:"/project/index")
            return false
        }
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

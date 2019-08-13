package testingforest

class FeedController {

    def list() {
        List<Feed> feedList = []
        List<Project> projectList = []

        for(Project project:Project.getAll()) {
            def teamList = project.getTeamList()
            def sessionUser = session.user
            def result = teamList.find{member -> if (member != null) member.login.equals(sessionUser.login)}
            if(result)
                projectList.add(project)
        }

        for(Project project: projectList) {
            feedList.addAll(project.feedList)
        }
        params.sizeList = feedList.size()
        if(feedList.size > 20) {
            respond feedList.sort().subList(0, 19)
            return
        }
        respond feedList
    }
}

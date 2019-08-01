package testingforest

class TestCaseController {

    def testCaseService

    def list(Long projectId) {
        Project project = Project.get(projectId)
        params.projectName = project.projectName
        params.testCaseListFiltered = project.testCaseList.findAll {
            testCase -> if (testCase.typeCase == "public" ||
                    (testCase.typeCase == "private" && testCase.userCreated.id == session.user.id)) testCase}
        params.sizeTestCaseListFiltered = params.testCaseListFiltered.size()
        respond view: "list"
    }

    def show(Long testCaseId) {
        respond testCaseService.get(testCaseId)
    }

    def create(Long projectId) {
        session.projectId = projectId
        respond new TestCase(params)
    }

    def save(TestCase testCase) {
        //File uploading is not supported yet
        testCase.sizeData = new Long(0)

        Project sessionProject = Project.get(session.projectId)
        sessionProject.addToTestCaseList(testCase)
        User sessionUser = User.get(session.user.id)
        sessionUser.addToCaseList(testCase)
        if (testCase.validate()){
            testCase.save(flush: true)
            flash.message = message(code: "testCase.create.success.message", args: [testCase.caseName])
            redirect uri: "/project/${session.projectId}/testCase/create"
        } else {
            respond testCase.errors, view: "create"
        }
    }

    def edit(Long testCaseId) {
        respond testCaseService.get(testCaseId)
    }

    def update(TestCase testCase) {
        if (testCase.validate()){
            testCaseService.save(testCase)
            redirect uri: "/testCase/show/$testCase.id"
        } else {
            respond testCase.errors, view: "edit"
        }
    }

    def delete(Long testCaseId) {
        def projectId = testCaseService.get(testCaseId).project.id
        testCaseService.delete(testCaseId)
        redirect uri: "/project/${projectId}/testCase/list"
    }
}

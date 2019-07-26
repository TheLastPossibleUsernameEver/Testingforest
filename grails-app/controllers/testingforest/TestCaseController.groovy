package testingforest

class TestCaseController {

    def testCaseService

    def list(Long projectId) {
        Project project = Project.get(projectId)
        respond project.getTestCaseList()
    }

    def show(Long id) {
        respond testCaseService.get(id)
    }

    def create(Long projectId) {
        session.projectId = projectId
        respond new TestCase(params)
    }

    def save(TestCase testCase) {
        //File uploading is not supported yet
        //Test-case types are not supported yet
        testCase.typeCase = "public"

        Project sessionProject = Project.get(session.projectId)
        sessionProject.addToTestCaseList(testCase)
        User sessionUser = User.get(session.user.id)
        sessionUser.addToCaseList(testCase)
        if (testCase.validate()){
            testCaseService.save(testCase)
            flash.message = "Test-case ${testCase.caseName} created successfully"
            redirect uri: "/project/${session.projectId}/testCase/create"
        } else {
            respond testCase.errors, view: "create"
        }
    }

    def edit(Long id) {
        respond testCaseService.get(id)
    }

    def update(TestCase testCase) {
        if (testCase.validate()){
            testCaseService.save(testCase)
            redirect uri: "/testCase/show/$testCase.id"
        } else {
            respond testCase.errors, view: "edit"
        }
    }

    def delete(Long id) {
        def projectId = testCaseService.get(id).project.id
        testCaseService.delete(id)
        redirect uri: "/project/${projectId}/testCase/list"
    }
}

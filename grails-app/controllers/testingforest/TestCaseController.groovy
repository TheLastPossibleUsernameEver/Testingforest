package testingforest

class TestCaseController {

    def testCaseService

    def list(Long projectId) {
        Project project = Project.get(projectId)
        params.projectName = project.projectName
        params.sizeTestCaseList = project.testCaseList.size()
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
        //Test-case types are not supported yet
        testCase.typeCase = "public"

        Project sessionProject = Project.get(session.projectId)
        sessionProject.addToTestCaseList(testCase)
        User sessionUser = User.get(session.user.id)
        sessionUser.addToCaseList(testCase)
        if (testCase.validate()){
            testCase.save(flush: true)
            flash.message = message(code: "testCase.create.success.message", args: [testCase.caseName])
          
            log.info("Created ${testCase.caseName} test-case in ${sessionProject.projectName} project ")

            redirect uri: "/project/${session.projectId}/testCase/create"
        } else {
            log.error("Test-case ${testCase} in ${sessionProject} is invalid: "
                    + testCase.errors)

            respond testCase.errors, view: "create"
        }
    }

    def edit(Long id) {
        respond testCaseService.get(id)
    }

    def update(TestCase testCase) {
        if (testCase.validate()){
            testCaseService.save(testCase)

            log.info("Updated ${testCase.caseName} test-case in ${testCaseService.get(testCase).project.projectName}")

            redirect uri: "/testCase/show/$testCase.id"
        } else {
            respond testCase.errors, view: "edit"
        }
    }

    def delete(Long id) {
        def projectId = testCaseService.get(id).project.id

        log.info("Deleted ${testCaseService.get(id).caseName} test-case" +
                "in ${testCaseService.get(id).project.projectName} project")

        testCaseService.delete(id)
        redirect uri: "/project/${projectId}/testCase/list"
    }
}

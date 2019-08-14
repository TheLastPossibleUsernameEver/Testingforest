package testingforest

import org.apache.commons.io.IOUtils

class TestCaseController {

    def testCaseService
    def projectService

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
        respond new TestCaseDocument(params)
        respond new TestCase(params)
    }

    def save(TestCase testCase, TestCaseDocument testCaseDocument) {
        def uploadedFile = params.data
        testCaseDocument.data = uploadedFile.getBytes()
        testCaseDocument.name = uploadedFile.originalFilename
        testCaseDocument.type = uploadedFile.contentType
        testCaseDocument.sizeData = testCaseDocument.data.length

        Project sessionProject = Project.get(session.projectId)
        sessionProject.addToTestCaseList(testCase)
        User sessionUser = User.get(session.user.id)
        sessionUser.addToCaseList(testCase)
        testCase.setCaseData(testCaseDocument)
        testCaseDocument.setTestCase(testCase)
        if (testCase.validate()) {
            if (testCaseDocument.validate()) {
                testCaseDocument.save(flush: true)
                testCase.save(flush: true)

                Feed feed = new Feed(user: sessionUser, project: sessionProject, testCase: testCase.caseName, feed: "feed.testcase.create")
                feed.save()

                flash.message = message(code: "testCase.create.success.message", args: [testCase.caseName])

                log.info("Created ${testCase.caseName} test-case in ${sessionProject.projectName} project ")

                redirect uri: "/project/${session.projectId}/testCase/create"
            } else {
                log.error("Test-case ${testCase} in ${sessionProject} is invalid: "
                        + testCaseDocument.errors)

                respond testCaseDocument.errors, view: "create"
            }
        } else {
            log.error("Test-case ${testCase} in ${sessionProject} is invalid: "
                    + testCase.errors)

            respond testCase.errors, view: "create"
        }
    }

    def edit(Long testCaseId) {
        TestCase testCase = testCaseService.get(testCaseId)
        params.projectId = testCase.project.id
        respond testCase
    }

    def update(TestCase testCase) {
        def data = request.getPart('data')
        if (data.getSize()) {
            testCase.caseData.data = IOUtils.toByteArray(data.getInputStream())
            testCase.caseData.name = data.getSubmittedFileName()
            testCase.caseData.type = data.getContentType()
            testCase.caseData.sizeData = data.getSize()
        }
        if (testCase.validate()){
            if (testCase.caseData.validate()){
                testCase.caseData.save(flush: true)
                testCase.save(flush: true)

                Feed feed = new Feed(user: User.get(session.user.id), project: testCase.project, testCase: testCase.caseName, feed: "feed.testcase.update")
                feed.save()

                log.info("Updated ${testCase.caseName} test-case in ${testCase.project.projectName}")

                redirect uri: "/testCase/show/$testCase.id"
            } else {
                log.error("Test-case ${testCase} in ${testCase.project} is invalid: "
                        + testCase.caseData.errors)

                respond testCase.caseData.errors, view: "edit"
            }
        } else {
            log.error("Test-case ${testCase} in ${testCase.project} is invalid: "
                    + testCase.errors)

            respond testCase.errors, view: "edit"
        }
    }

    def delete(Long testCaseId) {
        Feed feed = new Feed(user: User.get(session.user.id), project: TestCase.get(testCaseId).project, testCase: TestCase.get(testCaseId).caseName, feed: "feed.testcase.delete")
        feed.save()

        Long projectId = testCaseService.get(testCaseId).project.id
        Project project = projectService.get(projectId)
        project.lastUpdated = new Date()
        projectService.save(project)

        log.info("Deleted ${testCaseService.get(testCaseId).caseName} test-case" +
                "in ${testCaseService.get(testCaseId).project.projectName} project")

        testCaseService.delete(testCaseId)

        redirect uri: "/project/${projectId}/testCase/list"
    }
}

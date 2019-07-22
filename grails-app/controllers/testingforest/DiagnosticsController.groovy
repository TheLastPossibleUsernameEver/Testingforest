package testingforest

class DiagnosticsController {

    def testCaseService
    def userService
    def projectService

    def index() {
        respond testCaseService.list()
        respond testCaseService.list(), model: [testCaseCount: testCaseService.count()]
        respond userService.list()
        respond userService.list(), model:[userCount: userService.count()]
        respond projectService.list()
        respond projectService.list(), model:[projectCount: projectService.count()]

    }
}

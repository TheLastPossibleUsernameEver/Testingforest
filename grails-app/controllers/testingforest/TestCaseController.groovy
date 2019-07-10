package testingforest

class TestCaseController {

    def testCaseService

    def index() {
        respond testCaseService.list()
    }


    def show(Long id) {
        respond testCaseService.get(id)
    }

    def delete(Long id) {
        testCaseService.delete(id)
        redirect action:"index", method:"GET"
    }
}

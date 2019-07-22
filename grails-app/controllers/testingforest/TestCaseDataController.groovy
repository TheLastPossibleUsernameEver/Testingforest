package testingforest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TestCaseDataController {

    TestCaseDataService testCaseDataService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testCaseDataService.list(params), model:[testCaseDataCount: testCaseDataService.count()]
    }

    def show(Long id) {
        respond testCaseDataService.get(id)
    }

    def create() {
        respond new TestCaseData(params)
    }

    def save(TestCaseData testCaseData) {
        if (testCaseData == null) {
            notFound()
            return
        }

        try {
            testCaseDataService.save(testCaseData)
        } catch (ValidationException e) {
            respond testCaseData.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'testCaseData.label', default: 'TestCaseData'), testCaseData.id])
                redirect testCaseData
            }
            '*' { respond testCaseData, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testCaseDataService.get(id)
    }

    def update(TestCaseData testCaseData) {
        if (testCaseData == null) {
            notFound()
            return
        }

        try {
            testCaseDataService.save(testCaseData)
        } catch (ValidationException e) {
            respond testCaseData.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'testCaseData.label', default: 'TestCaseData'), testCaseData.id])
                redirect testCaseData
            }
            '*'{ respond testCaseData, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testCaseDataService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'testCaseData.label', default: 'TestCaseData'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testCaseData.label', default: 'TestCaseData'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

package testingforest

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class TestCaseDocumentController {

    TestCaseDocumentService testCaseDocumentService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testCaseDocumentService.list(params), model:[testCaseDataCount: testCaseDocumentService.count()]
    }

    def show(Long id) {
        respond testCaseDocumentService.get(id)
    }

    def create() {
        if (params != null) {
        respond new TestCaseDocument(params)
        }
        else {
            redirect(action: "index")
        }
    }

    def save(TestCaseDocument testCaseDocument) {
        if (testCaseDocument == null) {
            notFound()
            return
        }

        def uploadedFile = request.getFile('data')

        testCaseDocument.data = uploadedFile.getBytes()

        testCaseDocument.name = uploadedFile.originalFilename

        testCaseDocument.type = uploadedFile.contentType

        testCaseDocument.save (flush:true)

        log.info("${uploadedFile.originalFilename} file saved")

        redirect(action: "index")
    }

//    def showDocument(TestCaseDocument testCaseDocument){
//        this feature is not yet implemented
//    }

    def download(Long id){
        TestCaseDocument testCaseDocument = TestCaseDocument.get(id)
        if (testCaseDocument == null) {
            flash.message = "File not found"

            log.error("Error downloading file ${testCaseDocument.name}: file not found")

            redirect (action:'index')
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition",
                    "Attachment;Filename=\"${testCaseDocument.name}\"")

            def outputStream = response.getOutputStream()
            outputStream << testCaseDocument.data
            outputStream.flush()
            outputStream.close()
            log.info("Downloading ${testCaseDocument.name}")
        }
    }

    def edit(TestCaseDocument testCaseDocument) {
        respond testCaseDocument

        def uploadedDocument = request.getFile('data')
        if (uploadedDocument.empty) {
            log.error("Error uploading ${uploadedDocument.originalFilename} file: file not found")
            notFound()
        } else {
            log.info("${testCaseDocument.name} updated. New filename is ${uploadedDocument.originalFilename}")

            testCaseDocument.name = uploadedDocument.originalFilename
            testCaseDocument.type = uploadedDocument.contentType
            testCaseDocument.data = uploadedDocument.getBytes()
            testCaseDocument.save(flush:true)
            redirect(action: "index")
        }
    }

    def update(TestCaseDocument testCaseDocument) {
        if (testCaseDocument == null) {
            notFound()
            return
        }

        try {
            testCaseDocumentService.save(testCaseDocument)
        } catch (ValidationException e) {
            respond testCaseDocument.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                        args: [message(code: 'testCaseDocument.label',
                                default: 'TestCaseDocument'), testCaseDocument.id])
                redirect testCaseDocument
            }
            '*'{ respond testCaseDocument, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testCaseDocumentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                        args: [message(code: 'testCaseDocument.label', default: 'TestCaseDocument'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message',
                        args: [message(code: 'testCaseDocument.label', default: 'TestCaseDocument'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

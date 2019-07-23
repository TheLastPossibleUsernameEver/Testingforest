package testingforest

import grails.validation.ValidationException
import groovy.json.JsonOutput

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

        redirect(action: "index")

//        try {
//            testCaseDataService.save(testCaseData)
//        } catch (ValidationException e) {
//            respond testCaseData.errors, view:'create'
//            return
//        }
//
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.created.message', args: [message(code: 'testCaseData.label', default: 'TestCaseData'), testCaseData.id])
//                redirect testCaseData
//            }
//            '*' { respond testCaseData, [status: CREATED] }
//        }
    }

    def showDocument(TestCaseDocument testCaseDocument){
        response.outputStream << testCaseDocument.data
        response.outputStream.flush()
    }

    def downloadDocument(Long id){
        TestCaseDocument testCaseDocument = TestCaseDocument.get(id)
        if (testCaseDocument == null) {
            flash.message = "Document not found"
            redirect (action:'list')
        } else {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition",
                    "Attachment;Filename=\"${testCaseDocument.name}\"")
            //def file = new File(testCaseDocument.name).write(JsonOutput.toJson(testCaseDocument))

            //def fileInputStream = new FileInputStream(file)
            def outputStream = response.getOutputStream()
            //byte[] buffer = new byte[4096]
            //int len
            //while ((len = fileInputStream.read(buffer)) > 0) {
            //    outputStream.write(buffer, 0, len)
            //}
            outputStream << testCaseDocument.data
            outputStream.flush()
            outputStream.close()
        }
    }

    def edit(TestCaseDocument testCaseDocument) {
        respond testCaseDocument

        def uploadedDocument = request.getFile('data')
        if (uploadedDocument.empty) {
            notFound()
        } else {
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
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'testCaseDocument.label', default: 'TestCaseDocument'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testCaseDocument.label', default: 'TestCaseDocument'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

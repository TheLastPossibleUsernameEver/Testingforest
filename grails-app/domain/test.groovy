package testingforest
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Test {
    Integer test_id
    String name
    String path

    static constraints = {
    }

    static mapping = {
        id name: 'test_id'
    }
}
package testingforest
import java.text.SimpleDateFormat;
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Project {
    String name
    String teamlist
    SimpleDateFormat create_stamp
    static constraints = {
        name nullable: true
        teamlist nullable: true
        create_stamp nullable: true
    }
}

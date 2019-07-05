package testingforest
import grails.compiler.GrailsCompileStatic

import java.text.SimpleDateFormat;

@GrailsCompileStatic
class Case {
    String name
    Integer user_created_id
    String type
    Integer size
    Integer project_id
    SimpleDateFormat create_stamp
    SimpleDateFormat update_stamp

    static constraints = {
        name nullable: true
        user_created_id nullable: true
        type nullable: true
        size nullable: true
        project_id nullable: true
        create_stamp nullable: true
        update_stamp nullable: true
    }
}

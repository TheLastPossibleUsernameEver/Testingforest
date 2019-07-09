package testingforest
import grails.compiler.GrailsCompileStatic

import java.text.SimpleDateFormat;

@GrailsCompileStatic
class Case implements Serializable {
    Integer case_id
    String name
    Integer user_created_id
    String type
    Integer size
    Project project
    SimpleDateFormat create_stamp
    SimpleDateFormat update_stamp
    


     static mapping = {
        id composite : ['case_id','project']
        name sqlType: "varchar(45)"
        type sqlType: "varchar(45)"
        create_stamp sqlType:"timestamp"
        update_stamp sqlType:"timestamp"
        project index :'fk_case_project1_idx'
        project column:'project_id'
        
    }

    static constraints = {
        case_id nullable: true
        project nullable: true
        name nullable: true
        user_created_id nullable: true
        type nullable: true
        size nullable: true
        create_stamp nullable: true
        update_stamp nullable: true
    }
}
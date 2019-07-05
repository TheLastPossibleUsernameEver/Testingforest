package testingforest

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class User {
    String name
    String role
    String login
    String password
    static constraints = {
        name nullable: true
        role nullable: true
        login nullable: true
        password nullable: true
    }
}

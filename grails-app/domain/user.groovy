package testingforest

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class User {
    Integer user_id
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

    static mapping = {
        id name: 'user_id'
    }
}
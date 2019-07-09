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
        user_id nullable: true
        name nullable: true
        role nullable: true
        login nullable: true
        password nullable: true
    }

    static mapping = {
        id name: 'user_id'
        name sqlType: "varchar(45)"
        role sqlType: "varchar(45)"
        login sqlType: "varchar(45)"
        password sqlType: "varchar(45)"
    }
}
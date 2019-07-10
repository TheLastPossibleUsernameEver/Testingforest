package testingforest

class User {

    String login
    String password
    String userName
    String role

    //User created any TestCase
    static hasMany = [caseList : TestCase]

    //User can be associated with only one project
    static hasOne = [project : Project]

    static mapping = {
        autoTimestamp true
    }

    static constraints = {
        login size: 5..30, matches: "[a-zA-Z0-9]", unique: true
        password size: 5..30, password: true
        userName size: 1..255, matches: "[a-zA-Z0-9]"
        role inList: ["admin", "user"]
        project nullable: true
        caseList nullable: true
    }
}

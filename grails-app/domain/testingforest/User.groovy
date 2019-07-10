package testingforest

class User {

    String login
    String password
    String userName
    String role
    Date dateCreated
    Date lastUpdated

    //User created any TestCase
    static hasMany = [caseList : TestCase]

    static constraints = {
        login size: 5..30, matches: "[a-zA-Z0-9]+", unique: true
        password size: 5..30, password: true
        userName size: 1..255, matches: "[a-zA-Z0-9]+"
        role inList: ["admin", "user"]
        caseList nullable: true
    }
}

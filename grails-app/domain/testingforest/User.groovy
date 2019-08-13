package testingforest

class User {
    String name
    String role
    String login
    String password
    Date dateCreated
    Date lastUpdated
    //User created any TestCase
    static hasMany = [caseList : TestCase, feedList : Feed]

    static mapping = {
        sort name: 'asc'
    }

    static constraints = {
        login size: 1..45, unique:true, validator: {
            if (! it.matches(/(\w)+/) ) return ['errorLogin']
        }
        password size: 5..45
        name size: 1..45
        role inList: ["admin", "user"]
        caseList nullable: true
        feedList nullable: true
    }

    def beforeInsert(){
        encodePassword()
    }

    def beforeUpdate(){
        def oldPassword = getPersistentValue("password")
        if (oldPassword != password) {
            encodePassword()
        }
    }
    protected encodePassword(){
        password = password.encodeAsSHA1()
    }
}


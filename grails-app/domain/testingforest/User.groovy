package testingforest

class User {
    String name
    String role
    String login
    String password
    String email
    Date dateCreated
    Date lastUpdated
    //User created any TestCase
    static hasMany = [caseList : TestCase]

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
        email unique: true, nullable: false
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


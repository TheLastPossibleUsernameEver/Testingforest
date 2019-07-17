package testingforest

class User {
    String name
    String role
    String login
    String password

    //User created any TestCase
    static hasMany = [caseList : TestCase]

    static constraints = {
        login size: 1..45, unique:true, validator: {
            if (! it.matches("^[a-zA-Z]*[a-zA-Z0-9_]") ) return ['errorLogin']
        }
        password size: 5..45
        name size: 1..45
        role inList: ["admin", "user"]
        caseList nullable: true
    }

    def beforeInsert(){
        encodePassword()
    }
    def dataSource
    def beforeUpdate(){
        def u =User.get(id)
        if (u.password != password){
            encodePassword()
        }
    }
    protected encodePassword(){
        password=password.encodeAsSHA1()
    }
}


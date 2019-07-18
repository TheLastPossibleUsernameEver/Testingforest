package testingforest
import groovy.sql.Sql
class User {
    String name
    String role
    String login
    String password

    @Override
    String toString() {
        return login
    }
//User created any TestCase
    static hasMany = [caseList : TestCase]

    static constraints = {
        login size: 1..45, unique:true, validator: {
            if (! it.matches(/(\w)+/) ) return ['errorLogin']
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
        def query = new Sql(dataSource)
        def old_password =  query.firstRow("select password from tfdb.user WHERE user_id="+id)
        if (old_password != password){
            encodePassword()
        }
    }
    protected encodePassword(){
        password=password.encodeAsSHA1()
    }
}


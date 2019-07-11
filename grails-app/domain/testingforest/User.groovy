package testingforest

import groovy.sql.Sql

class User {
    String name;
    String role;
    String login;
    String password;
    static constraints = {
        name size: 1..45
        role size: 1..45
        login size: 1..45, unique:true
        login validator: {
            if (! it.matches("^[a-zA-Z]*[a-zA-Z0-9_]") ) return ['errorLogin']
        }
        password size: 1..45,
    }
    static mapping = {
        table "tfdb.user"
        version false
        id column : 'user_id'

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
        password=password.encodeAsSHA1();
    }
}


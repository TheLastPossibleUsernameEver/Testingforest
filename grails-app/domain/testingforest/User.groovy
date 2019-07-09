package testingforest

import org.apache.commons.codec.digest.DigestUtils;
class User {
    String name;
    String role;
    String login;
    String password;
    static constraints = {
        name size: 1..45,blank: false
        role size: 1..45,blank: false
        login size: 1..45,blank: false, unique:true
        login validator: {
            if (! it.matches("^[a-zA-Z]*[a-zA-Z0-9_]") ) return ['errorLogin']
        }
        password size: 1..45,blank: false
    }
    static mapping = {
        table "tfdb.user"
        version false
        id column : 'user_id'

    }
    def beforeInsert(){
        encodePassword()
    }
    protected encodePassword(){
        password=DigestUtils.shaHex(password);
    }
}


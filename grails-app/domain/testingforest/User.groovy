package testingforest

class User {

    int id
    String login
    String password
    String name
    String role

    @Override
    String toString() {
        return login
    }
    static constraints = {
        login size: 5..30, matches: "[a-zA-Z0-9]+", unique: true
        password size: 5..30, password: true
        name size: 1..255, matches: "[a-zA-Z0-9]+"
        role inList: ["admin", "user"]
    }
}

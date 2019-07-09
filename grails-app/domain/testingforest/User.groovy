package testingforest

class User {

    int id
    String login
    String password
    String name
    String role

    static constraints = {
        login(unique: true)
        password(password: true)
    }

    static mapping = {
        id column: "id"
    }
}

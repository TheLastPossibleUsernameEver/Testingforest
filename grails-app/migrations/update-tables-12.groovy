databaseChangeLog = {

    changeSet(author: "pogre (generated)", id: "1565853193836-1") {
        dropUniqueConstraint(constraintName: "UC_USEREMAIL_COL", tableName: "user")

        addUniqueConstraint(columnNames: "email", constraintName: "UC_USEREMAIL_COL", tableName: "user")
    }

    changeSet(author: "pogre (generated)", id: "1565853193836-2") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

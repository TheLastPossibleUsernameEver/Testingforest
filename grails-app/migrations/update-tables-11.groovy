databaseChangeLog = {

    changeSet(author: "root (generated)", id: "1565784624521-2") {
        addColumn(tableName: "user") {
            column(name: "email", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "root (generated)", id: "1565784624521-3") {
        addUniqueConstraint(columnNames: "email", constraintName: "UC_USEREMAIL_COL", tableName: "user")
    }

    changeSet(author: "root (generated)", id: "1565784624521-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

databaseChangeLog = {

    changeSet(author: "nikita (generated)", id: "1564837482984-2") {
        addColumn(tableName: "user") {
            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "nikita (generated)", id: "1564837482984-3") {
        addColumn(tableName: "user") {
            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "nikita (generated)", id: "1564837482984-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

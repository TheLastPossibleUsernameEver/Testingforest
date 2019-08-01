databaseChangeLog = {

    changeSet(author: "galina (generated)", id: "1564682484549-3") {
        addColumn(tableName: "user") {
            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "galina (generated)", id: "1564682484549-1") {
        addNotNullConstraint(columnDataType: "datetime", columnName: "date_created", tableName: "user")
    }

    changeSet(author: "galina (generated)", id: "1564682484549-2") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

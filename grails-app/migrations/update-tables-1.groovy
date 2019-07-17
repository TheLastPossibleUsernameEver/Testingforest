databaseChangeLog = {

    changeSet(author: "galina (generated)", id: "1563390655247-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

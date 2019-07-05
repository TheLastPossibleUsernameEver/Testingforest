databaseChangeLog = {

    changeSet(author: "Оля (generated)", id: "1562334844999-1") {
        dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "firstname", tableName: "user")
    }

    changeSet(author: "Оля (generated)", id: "1562334844999-2") {
        dropNotNullConstraint(columnDataType: "varchar(255)", columnName: "name", tableName: "user")
    }
}

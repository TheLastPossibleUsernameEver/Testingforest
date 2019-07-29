databaseChangeLog = {

    changeSet(author: "root (generated)", id: "1563819052288-2") {
        createTable(tableName: "test_case_document") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "test_case_documentPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "upload_date", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)")

            column(name: "type", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "data", type: "LONGBLOB") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "root (generated)", id: "1563819052288-3") {
        dropTable(tableName: "test_case_data")
    }

    changeSet(author: "root (generated)", id: "1563819052288-4") {
        dropColumn(columnName: "size_data", tableName: "test_case")
    }

    changeSet(author: "root (generated)", id: "1563819052288-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

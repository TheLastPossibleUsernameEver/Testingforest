databaseChangeLog = {

    changeSet(author: "nikita (generated)", id: "1565437947097-2") {
        createTable(tableName: "feed") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "feedPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "user_id", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "feed", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "project_id", type: "BIGINT") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "nikita (generated)", id: "1565437947097-3") {
        addForeignKeyConstraint(baseColumnNames: "project_id", baseTableName: "feed", constraintName: "FK2dx5mk4xv8k86xxmknxa9vuql", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "project", validate: "true")
    }

    changeSet(author: "nikita (generated)", id: "1565437947097-4") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "feed", constraintName: "FKeupe1ba7u2e7sr6r3fa4dhdo7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", validate: "true")
    }

    changeSet(author: "nikita (generated)", id: "1565437947097-1") {
        dropUniqueConstraint(constraintName: "UC_USERLOGIN_COL", tableName: "user")

        addUniqueConstraint(columnNames: "login", constraintName: "UC_USERLOGIN_COL", tableName: "user")
    }
}

databaseChangeLog = {

    changeSet(author: "Оля (generated)", id: "1562698692028-1") {
        createTable(tableName: "case") {
            column(name: "case_id", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "project_id", type: "INT") {
                constraints(nullable: "false")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "user_created_id", type: "INT")

            column(name: "size", type: "INT")

            column(name: "name", type: "VARCHAR(45)")

            column(name: "type", type: "VARCHAR(45)")

            column(name: "create_stamp", type: "timestamp")

            column(name: "update_stamp", type: "timestamp")
        }
    }

    changeSet(author: "Оля (generated)", id: "1562698692028-2") {
        createTable(tableName: "project") {
            column(autoIncrement: "true", name: "project_id", type: "INT") {
                constraints(primaryKey: "true", primaryKeyName: "projectPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(45)")

            column(name: "teamlist", type: "VARCHAR(45)")

            column(name: "create_stamp", type: "timestamp")
        }
    }

    changeSet(author: "Оля (generated)", id: "1562698692028-3") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "user_id", type: "INT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "login", type: "VARCHAR(45)")

            column(name: "role", type: "VARCHAR(45)")

            column(name: "name", type: "VARCHAR(45)")

            column(name: "password", type: "VARCHAR(45)")
        }
    }

    changeSet(author: "Оля (generated)", id: "1562698692028-4") {
        addPrimaryKey(columnNames: "case_id, project_id", constraintName: "casePK", tableName: "case")
    }

    changeSet(author: "Оля (generated)", id: "1562698692028-5") {
        createIndex(indexName: "fk_case_project1_idx", tableName: "case") {
            column(name: "project_id")
        }
    }

    changeSet(author: "Оля (generated)", id: "1562698692028-6") {
        addForeignKeyConstraint(baseColumnNames: "project_id", baseTableName: "case", constraintName: "FKlb2o2feupwrcyxucvust6l7r", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "project_id", referencedTableName: "project")
    }
}

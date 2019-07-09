databaseChangeLog = {

    changeSet(author: "Оля (generated)", id: "1562677987244-1") {
        createTable(tableName: "case") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "casePK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "project_id", type: "INT")

            column(name: "user_created_id", type: "INT")

            column(name: "size", type: "INT")

            column(name: "name", type: "VARCHAR(255)")

            column(name: "type", type: "VARCHAR(255)")

            column(name: "create_stamp", type: "BLOB")

            column(name: "update_stamp", type: "BLOB")
        }
    }

    changeSet(author: "Оля (generated)", id: "1562677987244-2") {
        createTable(tableName: "project") {
            column(autoIncrement: "true", name: "project_id", type: "INT") {
                constraints(primaryKey: "true", primaryKeyName: "projectPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)")

            column(name: "teamlist", type: "VARCHAR(255)")

            column(name: "create_stamp", type: "BLOB")
        }
    }

    changeSet(author: "Оля (generated)", id: "1562677987244-3") {
        createTable(tableName: "test") {
            column(autoIncrement: "true", name: "test_id", type: "INT") {
                constraints(primaryKey: "true", primaryKeyName: "testPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "path", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "Оля (generated)", id: "1562677987244-4") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "user_id", type: "INT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "login", type: "VARCHAR(255)")

            column(name: "role", type: "VARCHAR(255)")

            column(name: "name", type: "VARCHAR(255)")

            column(name: "password", type: "VARCHAR(255)")
        }
    }
}

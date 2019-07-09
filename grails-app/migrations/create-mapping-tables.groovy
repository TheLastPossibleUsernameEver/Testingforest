databaseChangeLog = {

    changeSet(author: "Оля", id: "create-mapping-tables") {
        sqlFile(path: '../scripts/create-mapping-tables.sql')
    }
}
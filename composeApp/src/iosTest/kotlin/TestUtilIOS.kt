import co.touchlab.sqliter.DatabaseConfiguration
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.driver.native.wrapConnection
import com.sap.flickersearch.db.Database

internal actual fun testDbConnection(): SqlDriver {
    val schema = Database.Schema
    return NativeSqliteDriver(
        DatabaseConfiguration(
            name = "flickerImageSearch.db",
            version = schema.version.toInt(),
            create = { connection ->
                wrapConnection(connection) { schema.create(it) }
            },
            upgrade = { connection, oldVersion, newVersion ->
                wrapConnection(connection) { schema.migrate(it, oldVersion.toLong(), newVersion.toLong()) }
            },
            inMemory = true
        )
    )
}

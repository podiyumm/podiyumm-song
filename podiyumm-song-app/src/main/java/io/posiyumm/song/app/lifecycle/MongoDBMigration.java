package io.posiyumm.song.app.lifecycle;

import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import io.quarkus.runtime.StartupEvent;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.SneakyThrows;

@ApplicationScoped
public class MongoDBMigration {

    @ConfigProperty(name = "quarkus.mongodb.connection-string")
    String connectionString;

    @ConfigProperty(name = "quarkus.mongodb.credentials.username")
    Optional<String> username;

    @ConfigProperty(name = "quarkus.mongodb.credentials.password")
    Optional<String> password;

    @SneakyThrows
    void onStart(@Observes StartupEvent ev) {
        Database database = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(connectionString, username.orElse(null), password.orElse(null), null , null);
        Liquibase liquiBase = new Liquibase("db/changeLog.json", new ClassLoaderResourceAccessor(), database);
        liquiBase.update("");
    }
}

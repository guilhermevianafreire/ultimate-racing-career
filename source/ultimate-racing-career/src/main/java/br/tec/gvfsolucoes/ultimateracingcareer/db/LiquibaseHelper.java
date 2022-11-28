package br.tec.gvfsolucoes.ultimateracingcareer.db;

import br.tec.gvfsolucoes.ultimateracingcareer.Launcher;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.DirectoryResourceAccessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

public class LiquibaseHelper implements AutoCloseable {

    private final Liquibase liquibase;
    private final DirectoryResourceAccessor resourceAccessor;

    public LiquibaseHelper() throws SQLException, FileNotFoundException, DatabaseException {
        Connection connection = DatabaseHelper
                .getInstance()
                .getDataSource()
                .getConnection();
        URL url = Launcher.class.getResource("/db/changelog");
        File changelogDirectory = new File(url.getPath());
        resourceAccessor = new DirectoryResourceAccessor(changelogDirectory);
        liquibase = new Liquibase(
                "changelog-master.xml",
                resourceAccessor,
                DatabaseFactory
                        .getInstance()
                        .findCorrectDatabaseImplementation(
                                new JdbcConnection(connection)
                        )
        );
    }

    public LiquibaseHelper validate() throws LiquibaseException {
        liquibase.validate();
        return this;
    }

    public LiquibaseHelper update() throws LiquibaseException {
        liquibase.update();
        return this;
    }

    @Override
    public void close() throws IOException {
        try {
            resourceAccessor.close();
            liquibase.close();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}

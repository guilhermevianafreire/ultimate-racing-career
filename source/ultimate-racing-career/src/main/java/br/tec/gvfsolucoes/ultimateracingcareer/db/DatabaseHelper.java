package br.tec.gvfsolucoes.ultimateracingcareer.db;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class DatabaseHelper {

    private static volatile DatabaseHelper instance;
    private static final Object MUTEX = new Object();

    private final SQLiteDataSource dataSource;

    private DatabaseHelper() {
        dataSource = new SQLiteDataSource(new SQLiteConfig());
        dataSource.setUrl("jdbc:sqlite:database/urc.db");
    }

    public static DatabaseHelper getInstance() {
        DatabaseHelper result = instance;
        if (result == null) {
            synchronized (MUTEX) {
                result = instance;
                if (result == null)
                    instance = result = new DatabaseHelper();
            }
        }
        return result;
    }

    public SQLiteDataSource getDataSource() {
        return dataSource;
    }

}

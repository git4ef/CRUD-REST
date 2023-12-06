package ef.util;

import org.flywaydb.core.Flyway;

public class FlywayMigrateUtil {
    public static Flyway migrateDB(){
        Flyway flyway = Flyway.configure().dataSource("jdbc:mysql://localhost:3306/public", "root", "test").load();
        return flyway;
    }
}

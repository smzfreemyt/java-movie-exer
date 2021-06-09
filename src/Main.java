import com.guiform.App;

import java.sql.SQLException;

/**
 * Main class
 * June 9, 2021
 * @author Samuel Amador
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        App app = new App("JDBC Exercise by Samuel");
        app.start();
    }
}

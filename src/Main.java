import com.database.Database;
import com.database.Movie;
import com.guiform.App;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class
 * June 9, 2021
 * @author Samuel Amador
 */
public class Main {
    private static  final ArrayList<String> fields = new ArrayList<>(
            Arrays.asList("username", "password", "favorite_number")
    );
    public static void main(String[] args) throws SQLException {
//        App app = new App("JDBC Exercise by Samuel");
//        app.start();

//        Map<Integer, Object> values = new HashMap<>();
//        values.put(1, "fourth");
//        values.put(2, "second");
//        values.put(3, 3);
        System.out.println("main movie");
        Movie movie = new Movie();
        movie.create();
    }
}

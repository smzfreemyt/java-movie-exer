import com.database.Database;

/**
 * Main class
 * June 4, 2021
 * @author Samuel Amador
 */
public class Main {
    private static final int WIN_WIDTH = 600;
    private static final int WIN_HEIGHT = 500;

    public static void main(String[] args) {
        new Window(WIN_WIDTH, WIN_HEIGHT, "Movie Database Exercise");
        Database db = new Database();
        db.create();
    }
}

import com.database.Movie;
import com.guiform.App;

import javax.swing.*;

/**
 * Main class
 * June 4, 2021
 * @author Samuel Amador
 */
public class Main {

    public static void main(String[] args) {

        Movie movie = new Movie();
        System.out.println(movie.search());

        new App("Welcome to my App by Samuel");
    }
}

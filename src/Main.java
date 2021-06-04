import com.database.Database;
import com.database.Movie;
import com.guiform.App;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class
 * June 4, 2021
 * @author Samuel Amador
 */
public class Main {

    public static void main(String[] args) {

        Movie movie = new Movie();

        System.out.println(movie.getAll());

//        System.out.println("Running...");
//        JFrame frame = new JFrame("Movie Exercise in Java By Sam");
//        frame.setContentPane(new App().getPanelMain());
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setBounds(30, 30, 600, 500);
//        frame.setVisible(true);
    }
}

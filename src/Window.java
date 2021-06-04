import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * Window class
 * @author Samuel amador
 */
public class Window extends Canvas{

    public Window(int width, int height, String title) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

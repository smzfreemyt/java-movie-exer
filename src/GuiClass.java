import javax.swing.*;
import java.awt.Canvas;
import java.awt.Dimension;

/**
 * Window class
 * @author Samuel amador
 */
public class GuiClass extends Canvas{

    private JFrame frame = new JFrame();

    private static final int WIN_WIDTH = 600;
    private static final int WIN_HEIGHT = 500;

    public GuiClass() {
        this.setWindow();
    }

    public void setWindow() {
        this.frame.setTitle("Java Movie Database Exercise by Sam");
        this.frame.setPreferredSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        this.frame.setMaximumSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        this.frame.setMinimumSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }
}

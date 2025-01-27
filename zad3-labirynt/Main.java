import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private Maze maze;

    public Main() {
        super("Maze");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        maze = new Maze();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Image offImage = createImage(getWidth(), getHeight());
        if (offImage != null) {
            maze.draw(offImage);
            g.drawImage(offImage, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}

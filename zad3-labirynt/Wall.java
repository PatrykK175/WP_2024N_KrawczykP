import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(int x, int y, Directions direction) {
        super(x, y);
        this.direction = direction;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);

        int sx = getX();
        int sy = getY();
        int length = MapSite.LENGHT;

        switch (direction) {
            case North:
                g.drawLine(sx, sy, sx + length, sy);
                break;

            case South:
                g.drawLine(sx, sy, sx + length, sy);
                break;

            case East:
                g.drawLine(sx, sy, sx, sy + length);
                break;

            case West:
                g.drawLine(sx, sy, sx, sy + length);
                break;
        }
    }
}

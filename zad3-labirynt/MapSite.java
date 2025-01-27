import java.awt.*;

public abstract class MapSite {
    public static final int LENGHT = 50;

    public enum Directions { North, East, South, West }

    private int x, y;

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Image image) {
    }
}

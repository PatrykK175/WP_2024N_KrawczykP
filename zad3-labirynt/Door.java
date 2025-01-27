import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {
    private Room room1;
    private Room room2;
    private boolean isOpen;
    private Directions direction;

    public Door(Room r1, Room r2, Directions direction) {
        super(-1, -1); 
        this.room1 = r1;
        this.room2 = r2;
        this.direction = direction;
        this.isOpen = true; 
    }

    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    public Room otherSideFrom(Room r) {
        return (r == room1) ? room2 : room1;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);

        int sx = getX();
        int sy = getY();
        int length = MapSite.LENGHT;

        int gap = 10;
        int half = length / 2;

        switch (direction) {
            case North:
                g.drawLine(sx, sy, sx + half - gap/2, sy);
                g.drawLine(sx + half + gap/2, sy, sx + length, sy);
                break;

            case South:
                g.drawLine(sx, sy, sx + half - gap/2, sy);
                g.drawLine(sx + half + gap/2, sy, sx + length, sy);
                break;

            case East:
                g.drawLine(sx, sy, sx, sy + half - gap/2);
                g.drawLine(sx, sy + half + gap/2, sx, sy + length);
                break;

            case West:
                g.drawLine(sx, sy, sx, sy + half - gap/2);
                g.drawLine(sx, sy + half + gap/2, sx, sy + length);
                break;
        }
    }
}

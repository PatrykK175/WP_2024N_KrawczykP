import java.awt.Graphics;
import java.awt.Image;

public class Room extends MapSite {
    private MapSite[] sites = new MapSite[4];
    private int roomNumber;

    public Room(int roomNumber, int x, int y) {
        super(x, y);
        this.roomNumber = roomNumber;
    }

    public void setSite(Directions direction, MapSite site) {
        sites[direction.ordinal()] = site;

        if (site instanceof Wall || site instanceof Door) {
            switch (direction) {
                case North:
                    site.setX(getX());
                    site.setY(getY());
                    break;
                case East:
                    site.setX(getX() + LENGHT);
                    site.setY(getY());
                    break;
                case South:
                    site.setX(getX());
                    site.setY(getY() + LENGHT);
                    break;
                case West:
                    site.setX(getX());
                    site.setY(getY());
                    break;
            }
        }
    }

    public MapSite getSite(Directions direction) {
        return sites[direction.ordinal()];
    }

    @Override
    public void draw(Image image) {
        for (MapSite m : sites) {
            if (m != null) {
                m.draw(image);
            }
        }

        Graphics g = image.getGraphics();
        g.drawString("" + roomNumber, getX() + 5, getY() + 25);
    }
}

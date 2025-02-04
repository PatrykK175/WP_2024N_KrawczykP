import java.awt.Image;

public class Room extends MapSite {
    private int nr;
    private MapSite[] sites = new MapSite[4];

    public Room(int x, int y, int nr) {
        super(x, y);
        this.nr = nr;
    }

    public void setSite(Directions d, MapSite mapSite) {
        switch (d) {
            case North:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY());
                }
                sites[0] = mapSite;
                break;

            case East:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX() + LENGTH);
                    mapSite.setY(getY());
                }
                sites[1] = mapSite;
                break;

            case South:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY() + LENGTH);
                }
                sites[2] = mapSite;
                break;

            case West:
                if (mapSite instanceof Wall) {
                    mapSite.setX(getX());
                    mapSite.setY(getY());
                }
                sites[3] = mapSite;
                break;

            default:
                break;
        }
    }

    @Override
    public void draw(Image image) {
        for (MapSite mapSite : sites) {
            if (mapSite != null) {
                mapSite.draw(image);
            }
        }
    }
}
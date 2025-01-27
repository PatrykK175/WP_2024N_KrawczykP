import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms = new ArrayList<>();

    public Maze() {
        int offsetX = 50;
        int offsetY = 75;

        Room r1 = new Room(1, offsetX +   0, offsetY +  50);
        Room r2 = new Room(2, offsetX +  50, offsetY +  50);
        Room r3 = new Room(3, offsetX +  50, offsetY +   0);
        Room r4 = new Room(4, offsetX +  50, offsetY + 100);
        Room r5 = new Room(5, offsetX + 100, offsetY +  50);

        Room r6 = new Room(6, offsetX + 150, offsetY +   0);

        Room r7 = new Room(7, offsetX + 150, offsetY +  50);
        Room r8 = new Room(8, offsetX + 150, offsetY + 100);

        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);
        rooms.add(r7);
        rooms.add(r8);

        Door d12 = new Door(r1, r2, MapSite.Directions.East);
        r1.setSite(MapSite.Directions.East, d12);
        r2.setSite(MapSite.Directions.West, d12);

        r1.setSite(MapSite.Directions.North, new Wall(r1.getX(), r1.getY(), MapSite.Directions.North));
        r1.setSite(MapSite.Directions.South, new Wall(r1.getX(), r1.getY(), MapSite.Directions.South));
        r1.setSite(MapSite.Directions.West,  new Wall(r1.getX(), r1.getY(), MapSite.Directions.West));

        Door d23 = new Door(r2, r3, MapSite.Directions.North);
        r2.setSite(MapSite.Directions.North, d23);
        r3.setSite(MapSite.Directions.South, d23);

        Door d24 = new Door(r2, r4, MapSite.Directions.South);
        r2.setSite(MapSite.Directions.South, d24);
        r4.setSite(MapSite.Directions.North, d24);

        Door d25 = new Door(r2, r5, MapSite.Directions.East);
        r2.setSite(MapSite.Directions.East, d25);
        r5.setSite(MapSite.Directions.West, d25);

        r3.setSite(MapSite.Directions.North, new Wall(r3.getX(), r3.getY(), MapSite.Directions.North));
        r3.setSite(MapSite.Directions.East,  new Wall(r3.getX(), r3.getY(), MapSite.Directions.East));
        r3.setSite(MapSite.Directions.West,  new Wall(r3.getX(), r3.getY(), MapSite.Directions.West));

        r4.setSite(MapSite.Directions.West,  new Wall(r4.getX(), r4.getY(), MapSite.Directions.West));
        r4.setSite(MapSite.Directions.East,  new Wall(r4.getX(), r4.getY(), MapSite.Directions.East));
        r4.setSite(MapSite.Directions.South, new Wall(r4.getX(), r4.getY(), MapSite.Directions.South));

        r5.setSite(MapSite.Directions.North, new Wall(r5.getX(), r5.getY(), MapSite.Directions.North));
        r5.setSite(MapSite.Directions.South, new Wall(r5.getX(), r5.getY(), MapSite.Directions.South));
        r5.setSite(MapSite.Directions.East,  new Wall(r5.getX(), r5.getY(), MapSite.Directions.East));
        r5.setSite(MapSite.Directions.West,  null);  

        Door d67 = new Door(r6, r7, MapSite.Directions.South);
        r6.setSite(MapSite.Directions.South, d67);
        r7.setSite(MapSite.Directions.North, d67);

        r6.setSite(MapSite.Directions.North, new Wall(r6.getX(), r6.getY(), MapSite.Directions.North));
        r6.setSite(MapSite.Directions.East,  new Wall(r6.getX(), r6.getY(), MapSite.Directions.East));
        r6.setSite(MapSite.Directions.West,  new Wall(r6.getX(), r6.getY(), MapSite.Directions.West));

        Door d78 = new Door(r7, r8, MapSite.Directions.South);
        r7.setSite(MapSite.Directions.South, d78);
        r8.setSite(MapSite.Directions.North, d78);

        r7.setSite(MapSite.Directions.East, new Wall(r7.getX(), r7.getY(), MapSite.Directions.East));
        r7.setSite(MapSite.Directions.West, new Wall(r7.getX(), r7.getY(), MapSite.Directions.West));

        r8.setSite(MapSite.Directions.East,  new Wall(r8.getX(), r8.getY(), MapSite.Directions.East));
        r8.setSite(MapSite.Directions.West,  new Wall(r8.getX(), r8.getY(), MapSite.Directions.West));
        r8.setSite(MapSite.Directions.South, new Wall(r8.getX(), r8.getY(), MapSite.Directions.South));
    }

    public void draw(Image image) {
        for (Room r : rooms) {
            r.draw(image);
        }
    }
}

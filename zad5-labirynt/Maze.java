import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms;

    public Maze() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void draw(Image image) {
        for (Room room : rooms) {
            room.draw(image);
        }
    }
}
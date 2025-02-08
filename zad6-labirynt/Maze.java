import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms = new ArrayList<>(); 

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public List<Room> get() { 
        return rooms;
    }

    @Override
    public String toString() {
        return "Maze with rooms: " + rooms;
    }
}
import java.util.HashMap;
import java.util.Map;

public class StandardMazeBuilder implements MazeBuilder {
    private Maze currentMaze;
    private Map<Integer, Room> rooms;

    public StandardMazeBuilder() {
        currentMaze = new Maze();
        rooms = new HashMap<>();
    }

    @Override
    public void buildRoom(int roomNumber) {
        if (!rooms.containsKey(roomNumber)) {
            Room room = new Room(50 * roomNumber, 100, roomNumber);
            rooms.put(roomNumber, room);
            currentMaze.addRoom(room);
        }
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo) {
        Room room1 = rooms.get(roomFrom);
        Room room2 = rooms.get(roomTo);

        if (room1 != null && room2 != null) {
            Door door = new Door(room1, room2);
            room1.setSite(Directions.East, door);
            room2.setSite(Directions.West, door);
        }
    }

    @Override
    public Maze getMaze() {
        return currentMaze;
    }
}
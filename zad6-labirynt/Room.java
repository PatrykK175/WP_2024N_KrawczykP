import java.util.HashMap;
import java.util.Map;

public class Room {
    private int roomNumber;
    private Map<MapSite> sides = new HashMap<>();
    boolean hasBomb = false;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setSide(Direction direction, MapSite site) {
        sides.put(direction, site);
    }

    public MapSite getSide(Direction direction) {
        return sides.get(direction);
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public void checkIfIsolated() {
        boolean isolated = true;
        for (MapSite side : sides.values()) {
            if (side instanceof Door) {
                isolated = false;
                break;
            }
        }
        hasBomb = isolated;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + (hasBomb ? " *" : "");
    }
}
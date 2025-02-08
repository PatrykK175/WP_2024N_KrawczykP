public class MazeDirector {
    private MazeFactory factory;

    public MazeDirector(MazeFactory factory) {
        this.factory = factory;
    }

    public Maze constructMaze() {
        Maze maze = factory.makeMaze();
        Room room1 = factory.makeRoom(1);
        Room room2 = factory.makeRoom(2);
        Door door = factory.makeDoor(room1, room2);

        maze.addRoom(room1);
        maze.addRoom(room2);

        room1.setSide(Direction.NORTH, factory.makeWall());
        room1.setSide(Direction.EAST, door);
        room1.setSide(Direction.SOUTH, factory.makeWall());
        room1.setSide(Direction.WEST, factory.makeWall());

        room2.setSide(Direction.NORTH, factory.makeWall());
        room2.setSide(Direction.EAST, factory.makeWall());
        room2.setSide(Direction.SOUTH, factory.makeWall());
        room2.setSide(Direction.WEST, door);

        for (Room room : maze.getRooms()) {
            room.checkIfIsolated();
        }

        return maze;
    }
}
public interface MazeBuilder {
    void buildRoom(int roomNumber);
    void buildDoor(int roomFrom, int roomTo);
    Maze getMaze();
}
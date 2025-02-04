public class MazeDirector {
    private MazeBuilder builder;

    public MazeDirector(MazeBuilder builder) {
        this.builder = builder;
    }

    public void constructSimpleMaze() {
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1, 2);
    }

    public Maze getMaze() {
        return builder.getMaze();
    }
}
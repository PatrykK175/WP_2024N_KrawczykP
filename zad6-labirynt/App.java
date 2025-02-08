import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;

public class App extends JFrame {

    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw maze");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildMaze();
            }
        });
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(button, "North");
    }

    public void buildMaze() {
        image = panel.getImage(); 
    
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
        g.dispose(); 

        Random random = new Random();
        int maxRooms = 3 + random.nextInt(6); 
        List<Room> rooms = new ArrayList<>(); 
        Set<String> occupiedPositions = new HashSet<>(); 

        int x = 50;
        int y = 100;
        int roomNumber = 1;
    
        Room firstRoom = new Room(x, y, roomNumber++);
        firstRoom.setSite(Directions.North, new Wall(x, y, Directions.North));
        firstRoom.setSite(Directions.East, new Wall(x, y, Directions.East));
        firstRoom.setSite(Directions.South, new Wall(x, y, Directions.South));
        firstRoom.setSite(Directions.West, new Wall(x, y, Directions.West));
        rooms.add(firstRoom);
        occupiedPositions.add(x + "," + y);
    
        for (int i = 1; i < maxRooms; i++) {
            boolean roomAdded = false;
    
            while (!roomAdded) {
                Room lastRoom = rooms.get(random.nextInt(rooms.size()));
                int direction = random.nextInt(4); 
    
                int newX = lastRoom.getX();
                int newY = lastRoom.getY();
    
                switch (direction) {
                    case 0: 
                        newY -= MapSite.LENGTH;
                        break;
                    case 1: 
                        newX += MapSite.LENGTH;
                        break;
                    case 2: 
                        newY += MapSite.LENGTH;
                        break;
                    case 3: 
                        newX -= MapSite.LENGTH;
                        break;
                }
    
                if (!occupiedPositions.contains(newX + "," + newY)) {
                    Room newRoom = new Room(newX, newY, roomNumber++);
                    newRoom.setSite(Directions.North, new Wall(newX, newY, Directions.North));
                    newRoom.setSite(Directions.East, new Wall(newX, newY, Directions.East));
                    newRoom.setSite(Directions.South, new Wall(newX, newY, Directions.South));
                    newRoom.setSite(Directions.West, new Wall(newX, newY, Directions.West));
    
                    Door door = new Door(lastRoom, newRoom);
                    if (direction == 0) { 
                        lastRoom.setSite(Directions.North, door);
                        newRoom.setSite(Directions.South, door); 
                    } else if (direction == 1) { 
                        lastRoom.setSite(Directions.East, door);
                        newRoom.setSite(Directions.West, door);
                    } else if (direction == 2) { 
                        lastRoom.setSite(Directions.South, door);
                        newRoom.setSite(Directions.North, door);
                    } else if (direction == 3) { 
                        lastRoom.setSite(Directions.West, door);
                        newRoom.setSite(Directions.East, door);
                    }
    
                    rooms.add(newRoom);
                    occupiedPositions.add(newX + "," + newY); 
                    roomAdded = true;
                }
            }
        }
    
        for (Room room : rooms) {
            room.draw(image);
        }
    
        panel.repaint();
    }

    public static void main(String[] args) {
        MazeFactory factory = new StandardMazeFactory(); 
        MazeDirector director = new MazeDirector(factory);
        Maze maze = director.constructMaze();

        System.out.println("Maze created:");
        System.out.println(maze);
    }
}
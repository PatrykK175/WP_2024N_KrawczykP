import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    public Wall (int x, int y, Directions d) {
       super(x, y);
       direction = d;
    }

    @Override
    public void draw(Image image) {
      Graphics g = image.getGraphics();
      int x = getX();
      int y = getY();
      g.setColor(Color.black);
      switch (direction) {
        case North:
        case South:
            System.out.println("Handling North or South");
            break;
        case East:
        case West:
            System.out.println("Handling East or West");
            break;
        default:
            System.out.println("Unknown direction");
      }
    }

    private Directions direction; 
   
    @Override
    public void enter() {
        System.out.println("You hit a wall!");
    }

    @Override
    public String toString() {
        return "Wall";
    }    
}

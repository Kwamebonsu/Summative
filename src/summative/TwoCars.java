package summative;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Random;
import static summative.GameDrawing.WIDTH;

/**
 *
 * @author bonsk5852
 */
public class TwoCars extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1300;
    static final int HEIGHT = 900;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
    // Create 2 Cars
    Rectangle RedCar = new Rectangle(220, 650, 160, 250);
    Rectangle BlueCar = new Rectangle(920, 650, 160, 250);
    // Create colours for the grass and the cars
    Color grassGreen = new Color(0, 92, 9);
    Color lightBlue = new Color(87, 139, 224);
    Color carRED = new Color(247, 27, 27);
    // Create variables to make the cars move
    int Redlane = 800;
    int Bluelane = 800;
    int move1 = 1600;
    int speed1 = 2;
    // Create variables for obstacles
    Rectangle Redball = new Rectangle(0, Redlane, 60, 60);
    Rectangle Blueball = new Rectangle(0, Bluelane, 60, 60);
    // Variables to control cars
    boolean right1 = false, left1 = false;
    boolean right2 = false, left2 = false;
    public static boolean[] keyID = new boolean[68836];

    // GAME VARIABLES END HERE   
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 
        // Draw Grass
        g.setColor(grassGreen);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // Draw roads
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 600, HEIGHT);
        g.fillRect(700, 0, 600, HEIGHT);
        // Draw lanes
        //Road 1
        g.setColor(Color.YELLOW);
        g.fillRect(190, Redlane - 800, 20, 100);
        g.fillRect(190, Redlane - 600, 20, 100);
        g.fillRect(190, Redlane - 400, 20, 100);
        g.fillRect(190, Redlane - 200, 20, 100);
        g.fillRect(190, Redlane, 20, 100);
        g.fillRect(390, Redlane - 800, 20, 100);
        g.fillRect(390, Redlane - 600, 20, 100);
        g.fillRect(390, Redlane - 400, 20, 100);
        g.fillRect(390, Redlane - 200, 20, 100);
        g.fillRect(390, Redlane, 20, 100);
        g.fillRect(190, Redlane + 800, 20, 100);
        g.fillRect(190, Redlane + 600, 20, 100);
        g.fillRect(190, Redlane + 400, 20, 100);
        g.fillRect(190, Redlane + 200, 20, 100);
        g.fillRect(190, Redlane, 20, 100);
        g.fillRect(390, Redlane + 800, 20, 100);
        g.fillRect(390, Redlane + 600, 20, 100);
        g.fillRect(390, Redlane + 400, 20, 100);
        g.fillRect(390, Redlane + 200, 20, 100);
        g.fillRect(390, Redlane, 20, 100);
        // Road 2
        g.fillRect(890, Bluelane - 800, 20, 100);
        g.fillRect(890, Bluelane - 600, 20, 100);
        g.fillRect(890, Bluelane - 400, 20, 100);
        g.fillRect(890, Bluelane - 200, 20, 100);
        g.fillRect(890, Bluelane, 20, 100);
        g.fillRect(1090, Bluelane - 800, 20, 100);
        g.fillRect(1090, Bluelane - 600, 20, 100);
        g.fillRect(1090, Bluelane - 400, 20, 100);
        g.fillRect(1090, Bluelane - 200, 20, 100);
        g.fillRect(1090, Bluelane, 20, 100);
        g.fillRect(890, Bluelane + 800, 20, 100);
        g.fillRect(890, Bluelane + 600, 20, 100);
        g.fillRect(890, Bluelane + 400, 20, 100);
        g.fillRect(890, Bluelane + 200, 20, 100);
        g.fillRect(890, Bluelane, 20, 100);
        g.fillRect(1090, Bluelane + 800, 20, 100);
        g.fillRect(1090, Bluelane + 600, 20, 100);
        g.fillRect(1090, Bluelane + 400, 20, 100);
        g.fillRect(1090, Bluelane + 200, 20, 100);
        g.fillRect(1090, Bluelane, 20, 100);
        // Draw the first Car
        // Draw the Car Body
        g.setColor(carRED);
        g.fillRoundRect(RedCar.x, RedCar.y, RedCar.width, RedCar.height, 35, 35);

        // Front Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(RedCar.x - 70, RedCar.y + 75, 300, 250, 70, 40);

        g.setColor(carRED);
        g.fillArc(RedCar.x - 15, RedCar.y + 115, 190, 210, 67, 45);

        // Back Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(RedCar.x - 70, RedCar.y - 15, 300, 250, 250, 40);

        g.setColor(carRED);
        g.fillArc(RedCar.x - 70, RedCar.y + 22, 300, 180, 248, 45);

        // Draw the second car
        // Draw the Car Body
        g.setColor(lightBlue);
        g.fillRoundRect(BlueCar.x, BlueCar.y, BlueCar.width, BlueCar.height, 35, 35);

        // Front Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(BlueCar.x - 70, BlueCar.y + 75, 300, 250, 70, 40);

        g.setColor(lightBlue);
        g.fillArc(BlueCar.x - 15, BlueCar.y + 115, 190, 210, 67, 45);

        // Back Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(BlueCar.x - 70, BlueCar.y - 15, 300, 250, 250, 40);

        g.setColor(lightBlue);
        g.fillArc(BlueCar.x - 70, BlueCar.y + 22, 300, 180, 248, 45);

        // Draw Obstacles
        g.fillOval(Redball.x, Redlane, Redball.width, Redball.height);
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 


            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        TwoCars game = new TwoCars();

        // starts the game loop
        game.run();
    }
}
package summative;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author bonsk5852
 */
public class GameDrawing extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 1300;
    static final int HEIGHT = 900;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
    Color grassGreen = new Color(0, 92, 9);
    Color lightBlue = new Color(87, 139, 224);
    Color carRED = new Color(247, 27, 27);
    int redWidth = 220;
    int blueWidth = 920;
    int redHeight = 650;
    int blueHeight = 650;
    int lane = 800;
    int move1 = 0;
    int speed1 = 1;
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
        g.fillRect(190, lane - 800, 20, 100);
        g.fillRect(190, lane - 600, 20, 100);
        g.fillRect(190, lane - 400, 20, 100);
        g.fillRect(190, lane - 200, 20, 100);
        g.fillRect(190, lane, 20, 100);
        g.fillRect(390, lane - 800, 20, 100);
        g.fillRect(390, lane - 600, 20, 100);
        g.fillRect(390, lane - 400, 20, 100);
        g.fillRect(390, lane - 200, 20, 100);
        g.fillRect(390, lane, 20, 100);
        g.fillRect(190, lane + 800, 20, 100);
        g.fillRect(190, lane + 600, 20, 100);
        g.fillRect(190, lane + 400, 20, 100);
        g.fillRect(190, lane + 200, 20, 100);
        g.fillRect(190, lane, 20, 100);
        g.fillRect(390, lane + 800, 20, 100);
        g.fillRect(390, lane + 600, 20, 100);
        g.fillRect(390, lane + 400, 20, 100);
        g.fillRect(390, lane + 200, 20, 100);
        g.fillRect(390, lane, 20, 100);
        // Road 2
        g.fillRect(890, lane - 800, 20, 100);
        g.fillRect(890, lane - 600, 20, 100);
        g.fillRect(890, lane - 400, 20, 100);
        g.fillRect(890, lane - 200, 20, 100);
        g.fillRect(890, lane, 20, 100);
        g.fillRect(1090, lane - 800, 20, 100);
        g.fillRect(1090, lane - 600, 20, 100);
        g.fillRect(1090, lane - 400, 20, 100);
        g.fillRect(1090, lane - 200, 20, 100);
        g.fillRect(1090, lane, 20, 100);
        g.fillRect(890, lane + 800, 20, 100);
        g.fillRect(890, lane + 600, 20, 100);
        g.fillRect(890, lane + 400, 20, 100);
        g.fillRect(890, lane + 200, 20, 100);
        g.fillRect(890, lane, 20, 100);
        g.fillRect(1090, lane + 800, 20, 100);
        g.fillRect(1090, lane + 600, 20, 100);
        g.fillRect(1090, lane + 400, 20, 100);
        g.fillRect(1090, lane + 200, 20, 100);
        g.fillRect(1090, lane, 20, 100);
        // Draw a Cars
        // Draw the Car Body
        g.setColor(carRED);
        g.fillRoundRect(redWidth, redHeight, 160, 250, 35, 35);
        // Front Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(redWidth - 70, redHeight + 75, 300, 250, 70, 40);
        g.setColor(carRED);
        g.fillArc(redWidth - 15, redHeight + 115, 190, 210, 67, 45);
        // Back Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(redWidth - 70, redHeight - 15, 300, 250, 250, 40);
        g.setColor(carRED);
        g.fillArc(redWidth - 70, redHeight + 22, 300, 180, 248, 45);
        // Draw the second car
        // Draw the Car Body
        g.setColor(lightBlue);
        g.fillRoundRect(blueWidth, blueHeight, 160, 250, 35, 35);
        // Front Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(blueWidth - 70, blueHeight + 75, 300, 250, 70, 40);
        g.setColor(lightBlue);
        g.fillArc(blueWidth - 15, blueHeight + 115, 190, 210, 67, 45);
        // Back Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(blueWidth - 70, blueHeight - 15, 300, 250, 250, 40);
        g.setColor(lightBlue);
        g.fillArc(blueWidth - 70, blueHeight + 22, 300, 180, 248, 45);
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
            drive();
            if (lane <= 0) {
                speed1 = 1;
            }
            if (lane >= 800) {
                lane = 0;
            }
            lane = lane + speed1;
            speed1 = speed1 + 1;
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

    private void drive() {
        boolean forward = keyID[KeyEvent.VK_W];
        boolean backward = keyID[KeyEvent.VK_S];
        boolean right = keyID[KeyEvent.VK_D];
        boolean left = keyID[KeyEvent.VK_A];
        boolean pause = keyID[KeyEvent.VK_P];

        if (forward = true) {
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("Two Cars");

        // creates an instance of my game
        GameDrawing game = new GameDrawing();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());

        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down

        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter {
        // if a key has been pressed down

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode > 0 || keyCode < keyID.length) {
                keyID[keyCode] = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
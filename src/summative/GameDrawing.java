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
        g.fillRect(190, 0, 20, 100);
        g.fillRect(190, 200, 20, 100);
        g.fillRect(190, 400, 20, 100);
        g.fillRect(190, 600, 20, 100);
        g.fillRect(190, 800, 20, 100);
        g.fillRect(390, 0, 20, 100);
        g.fillRect(390, 200, 20, 100);
        g.fillRect(390, 400, 20, 100);
        g.fillRect(390, 600, 20, 100);
        g.fillRect(390, 800, 20, 100);
        // Road 2
        g.fillRect(890, 0, 20, 100);
        g.fillRect(890, 200, 20, 100);
        g.fillRect(890, 400, 20, 100);
        g.fillRect(890, 600, 20, 100);
        g.fillRect(890, 800, 20, 100);
        g.fillRect(1090, 0, 20, 100);
        g.fillRect(1090, 200, 20, 100);
        g.fillRect(1090, 400, 20, 100);
        g.fillRect(1090, 600, 20, 100);
        g.fillRect(1090, 800, 20, 100);
        // Draw a Cars
        // Draw the Car Body
        g.setColor(Color.RED);
        g.fillRoundRect(220, 650, 160, 250, 35, 35);
        // Front Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(220, 725, 160, 250, 70, 40);
//        g.setColor(Color.RED);
//        g.fillArc(265, 765, 70, 75, 40, 100);
        // Back Windshield
        g.setColor(Color.DARK_GRAY);
        g.fillArc(220, 725, 160, 150, 220, 100);
        g.setColor(Color.RED);
        g.fillArc(265, 760, 70, 75, 220, 100);
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
        JFrame frame = new JFrame("My Game");

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
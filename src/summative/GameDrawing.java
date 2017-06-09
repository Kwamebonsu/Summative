package summative;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.Random;

/**
 *
 * @author bonsk5852
 */
public class GameDrawing extends JComponent implements KeyListener {

    // Height and Width of our game
    static final int WIDTH = 1300;
    static final int HEIGHT = 900;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // GAME VARIABLES WOULD GO HERE
    // Create variables to reset the game
    int resetText = -1000;
    boolean resetgame = false;
    // Create 2 Cars
    Rectangle RedCar = new Rectangle(220, 650, 160, 250);
    Rectangle BlueCar = new Rectangle(920, 650, 160, 250);
    // Create colours for the grass and the cars
    Color grassGreen = new Color(0, 92, 9);
    Color lightBlue = new Color(87, 139, 224);
    Color carRED = new Color(247, 27, 27);
    // Create variables to make the cars appear to move
    int Redlane = 800;
    int Bluelane = 800;
    int speed1 = 2;
    int speed2 = 2;
    int velRed = 3;
    int velBlue = 3;
    // Create Variables for text
    int Loser = -1000;
    int Winner = -1000;
    // Create Scoring variables
    int Redcounter = 0;
    int Bluecounter = 0;
    // Create variables for obstacles
    Rectangle Redball = new Rectangle(0, 800, 60, 60);
    Rectangle Blueball = new Rectangle(0, 800, 60, 60);
    // Create bonus obstacles
    Rectangle RedBonus = new Rectangle(0, 835, 30, 30);
    Rectangle BlueBonus = new Rectangle(0, 835, 30, 30);
    // Variables to control cars
    boolean right1 = false, left1 = false;
    boolean right2 = false, left2 = false;
    boolean forward1 = false, back1 = false;
    boolean forward2 = false, back2 = false;
    public static boolean[] keyID = new boolean[68836];
    //  Create a font
    Font myFont = new Font("Arial", Font.CENTER_BASELINE, 75);
    // Sound effects
    InputStream crash;

//    public boolean collides(int x, int y, int w, int h, int bx, int by, int bw, int bh) {
//        if ((x + w < bx || x > bx + bw || y + h < by || y > by + bh)) {
//            return false;
//        } else {
//            return true;
//        }
//    }
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
        g.fillRect(190, Redlane + 800, 20, 100);
        g.fillRect(190, Redlane + 600, 20, 100);
        g.fillRect(190, Redlane + 400, 20, 100);
        g.fillRect(190, Redlane + 200, 20, 100);
        g.fillRect(190, Redlane, 20, 100);
        g.fillRect(190, Redlane - 1600, 20, 100);
        g.fillRect(190, Redlane - 1400, 20, 100);
        g.fillRect(190, Redlane - 1200, 20, 100);
        g.fillRect(190, Redlane - 1000, 20, 100);
        g.fillRect(190, Redlane - 800, 20, 100);
        g.fillRect(190, Redlane - 600, 20, 100);
        g.fillRect(190, Redlane - 400, 20, 100);
        g.fillRect(190, Redlane - 200, 20, 100);
        g.fillRect(190, Redlane, 20, 100);
        g.fillRect(390, Redlane + 800, 20, 100);
        g.fillRect(390, Redlane + 600, 20, 100);
        g.fillRect(390, Redlane + 400, 20, 100);
        g.fillRect(390, Redlane + 200, 20, 100);
        g.fillRect(390, Redlane, 20, 100);
        g.fillRect(390, Redlane - 1000, 20, 100);
        g.fillRect(390, Redlane - 1600, 20, 100);
        g.fillRect(390, Redlane - 1400, 20, 100);
        g.fillRect(390, Redlane - 1200, 20, 100);
        g.fillRect(390, Redlane - 800, 20, 100);
        g.fillRect(390, Redlane - 600, 20, 100);
        g.fillRect(390, Redlane - 400, 20, 100);
        g.fillRect(390, Redlane - 200, 20, 100);
        g.fillRect(390, Redlane, 20, 100);



        // Road 2
        g.fillRect(890, Bluelane + 800, 20, 100);
        g.fillRect(890, Bluelane + 600, 20, 100);
        g.fillRect(890, Bluelane + 400, 20, 100);
        g.fillRect(890, Bluelane + 200, 20, 100);
        g.fillRect(890, Bluelane, 20, 100);
        g.fillRect(890, Bluelane - 1600, 20, 100);
        g.fillRect(890, Bluelane - 1400, 20, 100);
        g.fillRect(890, Bluelane - 1200, 20, 100);
        g.fillRect(890, Bluelane - 1000, 20, 100);
        g.fillRect(890, Bluelane - 800, 20, 100);
        g.fillRect(890, Bluelane - 600, 20, 100);
        g.fillRect(890, Bluelane - 400, 20, 100);
        g.fillRect(890, Bluelane - 200, 20, 100);
        g.fillRect(890, Bluelane, 20, 100);
        g.fillRect(1090, Bluelane + 800, 20, 100);
        g.fillRect(1090, Bluelane + 600, 20, 100);
        g.fillRect(1090, Bluelane + 400, 20, 100);
        g.fillRect(1090, Bluelane + 200, 20, 100);
        g.fillRect(1090, Bluelane, 20, 100);
        g.fillRect(1090, Bluelane - 1000, 20, 100);
        g.fillRect(1090, Bluelane - 1600, 20, 100);
        g.fillRect(1090, Bluelane - 1400, 20, 100);
        g.fillRect(1090, Bluelane - 1200, 20, 100);
        g.fillRect(1090, Bluelane - 800, 20, 100);
        g.fillRect(1090, Bluelane - 600, 20, 100);
        g.fillRect(1090, Bluelane - 400, 20, 100);
        g.fillRect(1090, Bluelane - 200, 20, 100);
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
        // Draw Bonus Obstacles
        g.setColor(Color.yellow);
        g.fillOval(RedBonus.x, RedBonus.y, RedBonus.width, RedBonus.height);
        g.fillOval(BlueBonus.x, BlueBonus.y, BlueBonus.width, BlueBonus.height);

        // Draw Bonus Obstacles
        g.setColor(Color.yellow);
        g.fillOval(RedBonus.x, RedBonus.y, RedBonus.width, RedBonus.height);
        g.fillOval(BlueBonus.x, BlueBonus.y, BlueBonus.width, BlueBonus.height);
        // Draw Obstacles
        g.setColor(Color.blue);
        g.fillOval(Redball.x, Redball.y, Redball.width, Redball.height);
        g.fillOval(Blueball.x, Blueball.y, Blueball.width, Blueball.height);

        // You Lost!
        g.setFont(myFont);
        g.setColor(Color.PINK);
        g.drawString("You Lose", Loser, 100);
        g.drawString("You won", Winner, 100);
        // Draw counter
        g.drawString("" + Redcounter, 210, 200);
        g.drawString("" + Bluecounter, 910, 200);

        // Draw text to restart the game
        g.drawString("Press SPACE to restart", resetText, 500);
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







            // Start the counter for the red car
            if (RedCar.y > -4000) {
                Redcounter = Redcounter + 1;
            }
            // Start the counter for the blue car
            if (BlueCar.y > -4000) {
                Bluecounter = Bluecounter + 1;
            }
            // Red Car Start
            // Make the car appear to move
            if (Redlane <= 0) {
                speed1 = 1;
            }
            if (Redlane >= 1600) {
                Redlane = 0;
                Redball.y = 0;
                RedBonus.y = 0;
                speed1 = velRed;
                // Speed up every time the car passes an obstacle
                if (velRed > 0 && velRed < 20) {
                    velRed++;
                }
                // Randomly Generate Bonus Obstacles in one of the three lanes
                Random rand = new Random();
                int space = rand.nextInt(3) + 1;
                if (space == 1) {
                    Redball.x = 70;
                }
                if (space == 2) {
                    Redball.x = 270;
                }
                if (space == 3) {
                    Redball.x = 470;
                }
                // Randomly generate obstacles in one of the three lanes
                Random Bonus = new Random();
                int Bonusobject = Bonus.nextInt(3) + 1;
                if (Bonusobject == 1) {
                    RedBonus.x = 85;
                }
                if (Bonusobject == 2) {
                    RedBonus.x = 285;
                }
                if (Bonusobject == 3) {
                    RedBonus.x = 485;
                }
            }
            //Increase the speed
            RedBonus.y = RedBonus.y + speed1;
            Redlane = Redlane + speed1;
            Redball.y = Redball.y + speed1;
            // Stop moving if it collides with the obstacle
            if (RedCar.intersects(Redball)) {
//                if (Loser != 800 && Winner != 100) {
//                    Loser = 100;
//                    Winner = 800;
//                }
                speed1 = 0;
                RedCar.y = -10000;
            }
            // Add 100 points if the car collides with a bonus obstacle
            if (RedCar.intersects(RedBonus)) {
                Redcounter = Redcounter + 100;
                RedBonus.y = 1000;
            }
//            if(collides(RedCar.x, RedCar.y, RedCar.width, RedCar.height, Redball.x, Redball.y, Redball.width, Redball.height)){
//                break;
//            }

            // Blue Car Start
            // Make the car appear to move
            if (Bluelane <= 0) {
                speed2 = 1;
            }
            if (Bluelane >= 1600) {
                Bluelane = 0;
                Blueball.y = 0;
                BlueBonus.y = 0;
                speed2 = velBlue;
                // Speed up every time the car passes an obstacle
                if (velBlue > 0 && velBlue < 20) {
                    velBlue++;
                }
                // Randomly generate bonus obstacles in one of the three lanes
                Random Bonus = new Random();
                int Bonusobject = Bonus.nextInt(3) + 1;
                if (Bonusobject == 1) {
                    BlueBonus.x = 785;
                }
                if (Bonusobject == 2) {
                    BlueBonus.x = 985;
                }
                if (Bonusobject == 3) {
                    BlueBonus.x = 1185;
                }
                // Randomly generate obstacles in one of the three lanes
                Random rand = new Random();
                int object = rand.nextInt(3) + 1;
                if (object == 1) {
                    Blueball.x = 770;
                }
                if (object == 2) {
                    Blueball.x = 970;
                }
                if (object == 3) {
                    Blueball.x = 1170;
                }
            }
            //Increase the speed
            Bluelane = Bluelane + speed2;
            Blueball.y = Blueball.y + speed2;
            BlueBonus.y = BlueBonus.y + speed2;
            // Break the loop if it collides with the obstacle
            if (BlueCar.intersects(Blueball)) {
//                if (Loser != 100 && Winner != 800) {
//                    Loser = 800;
//                    Winner = 100;
//                }
                BlueCar.y = -10000;
                speed2 = 0;
            }
            // Add 100 points if the blue car collides with a bonus obstacle
            if (BlueCar.intersects(BlueBonus)) {
                Bluecounter = Bluecounter + 100;
                BlueBonus.y = 1000;
            }

            // Break the loop once both cars collide
            if (speed1 == 0 && speed2 == 0) {
                if (Redcounter < Bluecounter) {
                    Loser = 800;
                    Winner = 100;
                }
                if (Redcounter < Bluecounter) {
                    Winner = 800;
                    Loser = 100;
                }
                // Restart the game by pressing space
                resetText = 250;

                repaint();
//                if(resetgame == true){
                while (!resetgame) {
                }
                Redcounter = 0;
                Bluecounter = 0;
                Redlane = 800;
                Bluelane = 800;
                speed1 = 2;
                speed2 = 2;
                velRed = 3;
                velBlue = 3;
                resetText = -2250;
                Redball.y = 800;
                Blueball.y = 800;
                RedBonus.y = 835;
                BlueBonus.y = 835;
                RedCar.y = 550;
                BlueCar.y = 550;
                Loser = -1000;
                Winner = -1000;
                resetgame = false;

            }
//            if(collides(BlueCar.x, BlueCar.y, BlueCar.width, BlueCar.height, Blueball.x, Blueball.y, Blueball.width, Blueball.height)){
//                break;
//            }

            // Set controls for movement
            // Red Car right
            if (right1 && RedCar.x < 440) {
                RedCar.x += 15;
            }
            // Red Car left
            if (left1 && RedCar.x > 0) {
                RedCar.x -= 15;
            }
            // Blue car right
            if (right2 && BlueCar.x < 1400 - 275) {
                BlueCar.x += 15;
            }
            // Blue car left
            if (left2 && BlueCar.x > 700) {
                BlueCar.x -= 15;
            }
            // Red car forward
            if (forward1 && RedCar.y > 0) {
                RedCar.y -= 10;
            }
            // Blue car forward
            if (forward2 && BlueCar.y > 0) {
                BlueCar.y -= 10;
            }
            // Red car backward
            if (back1 && RedCar.y < 650) {
                RedCar.y += 10;
            }
            // Blue car backward
            if (back2 && BlueCar.y < 650) {
                BlueCar.y += 10;
            }

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
        frame.addKeyListener(game);
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
    // if a key has been pressed down
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                left1 = true;
                break;
            case KeyEvent.VK_D:
                right1 = true;
                break;
            case KeyEvent.VK_LEFT:
                left2 = true;
                break;
            case KeyEvent.VK_RIGHT:
                right2 = true;
                break;
            case KeyEvent.VK_W:
                forward1 = true;
                break;
            case KeyEvent.VK_S:
                back1 = true;
                break;
            case KeyEvent.VK_UP:
                forward2 = true;
                break;
            case KeyEvent.VK_DOWN:
                back2 = true;
                break;
            case KeyEvent.VK_SPACE:
                resetgame = true;
                break;

        }
    }

    // if a key has been released
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                left1 = false;
                break;
            case KeyEvent.VK_D:
                right1 = false;
                break;
            case KeyEvent.VK_LEFT:
                left2 = false;
                break;
            case KeyEvent.VK_RIGHT:
                right2 = false;
                break;
            case KeyEvent.VK_UP:
                forward2 = false;
                break;
            case KeyEvent.VK_W:
                forward1 = false;
                break;
            case KeyEvent.VK_DOWN:
                back2 = false;
                break;
            case KeyEvent.VK_S:
                back1 = false;
                break;
            case KeyEvent.VK_SPACE:
                resetgame = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
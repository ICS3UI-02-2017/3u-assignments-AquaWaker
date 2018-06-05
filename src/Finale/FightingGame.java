package Finale;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.Timer;

/**
 * final project
 *
 * @author pritb9521
 */
public class FightingGame extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "Fight!";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 35;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    BasicStroke biggerLine = new BasicStroke(5);
    BasicStroke bigishLine = new BasicStroke(3);
    BasicStroke normal = new BasicStroke();
    boolean moveLP1 = false;
    boolean moveRP1 = false;
    int mouseX = 0;
    int mouseY = 0;
    // make the limbs
    double[] leftArm = new double[8];
    double[] leftLeg = new double[8];
    double[] rightLeg = new double[8];
    double[] rightArm = new double[8];
    double[] leftArmP2 = new double[8];
    double[] leftLegP2 = new double[8];
    double[] rightLegP2 = new double[8];
    double[] rightArmP2 = new double[8];
    // movement variables
    int moveLAV = 0;
    int moveRAV = 0;
    int moveLAH = 0;
    int moveRAH = 0;
    // sets a changable horizontal starting spot
    int positionH = 150;
    int runAnime = 0;
    int runTimer = 0;
    int runLU = 0;
    int runRU = 0;
    // sets a changable vertical starting spot
    int positionV = 310;
    int bottemLegV = 525;
    // adds gravity into the program
    int gravity = 0;
    // is it punching?
    boolean activateLPunch = false;
    boolean activateRPunch = false;
    boolean leftPunching = false;
    boolean rightPunching = false;
    // helps with animation
    int animationFrameL = 0;
    int animationFrameR = 0;
    // back skip variable
    boolean backSkip = false;
    int skipTimer = 0;
    // for one punch easter egg
    Color Peach = new Color(252, 200, 159);
    boolean opm = false;
    int timer = 0;
    // variables for the punching bag
    double healthBar = 100;
    int momentum;
    Rectangle bag = new Rectangle(800, 200, 100, 300);
    Rectangle string = new Rectangle(845, 0, 10, 300);
    boolean haveBeenPunched = false;
    boolean onePunched = false;
    // string animation
    int numSegments = 8;
    double[] x = new double[numSegments];
    double[] y = new double[numSegments];
    double[] angle = new double[numSegments];
    double segLength = 26;
    double targetX = 0;
    double targetY = 0;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public FightingGame() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        preSetup();
        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        if (opm == true) {
            if (leftPunching == true || rightPunching == true) {
                g.setColor(Color.BLACK);
            }
        } else {
            g.setColor(Color.WHITE);
        }

        g.fillRect(0, 0, WIDTH + 100, HEIGHT + 100);

        Graphics2D g2d = (Graphics2D) g;

        // GAME DRAWING GOES HERE

        g.setColor(Color.BLACK);
        g2d.setStroke(biggerLine);

        // make the ground
        g.fillRect(0, 525, WIDTH + 100, 100);

        // draw head
        if (opm == true) {
            g.setColor(Peach);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillOval(positionH - 75 / 2, (positionV - 75), 75, 75);

        // draw body
        if (opm == true) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawLine(positionH, positionV, positionH, (positionV + 100));

        // draw limbs
        limbMath(g2d, leftArm);
        limbMath(g2d, rightArm);

        limbMath(g2d, leftLeg);
        limbMath(g2d, rightLeg);

        // draw the punching bag
        g.setColor(Color.BLACK);
        g2d.fill(bag);

        // play with the string
        g.setColor(Color.BLACK);
        string(g);

        // Punching bag health bar
        g.fillRect(325, 25, 350, 50);
        g.setColor(Color.RED);
        g.fillRect(350, 30, 300, 40);
        g.setColor(Color.GREEN);
        g.fillRect(350, 30, (3 * (int) healthBar), 40);



        // GAME DRAWING ENDS HERE
    }

    // determines the angle
    void limbMath(Graphics2D g2d, double[] limb) {

        double dx = limb[4] - limb[0];
        double dy = limb[5] - limb[1];
        double angle1 = Math.atan2(dy, dx);

        double tx = limb[4] - Math.cos(angle1) * limb[6];
        double ty = limb[5] - Math.sin(angle1) * limb[6];

        dx = tx - limb[2];
        dy = ty - limb[3];
        double angle2 = Math.atan2(dy, dx);

        limb[0] = limb[2] + Math.cos(angle2) * limb[6];
        limb[1] = limb[3] + Math.sin(angle2) * limb[6];

        if (limb[7] == 1) {
            if (angle2 > angle1) {
                double angleD = angle1 - angle2;
                angle2 = angle1;; // + angleD;
                limb[0] = limb[2] + Math.cos(angle2) * limb[6];
                limb[1] = limb[3] + Math.sin(angle2) * limb[6];
            }
        } else if (limb[7] == 0) {
            if (angle2 < angle1) {
                double angleD = angle1 - angle2;
                angle2 = angle1; // - angleD;
                limb[0] = limb[2] + Math.cos(angle2) * limb[6];
                limb[1] = limb[3] + Math.sin(angle2) * limb[6];
            }
        }

        // changes the colour of the segments of the limbs
        if (opm == true) {
            g2d.setColor(Color.RED);
        } else {
            g2d.setColor(Color.BLACK);
        }
        // send the information to draw the first segment
        segment(g2d, limb[0], limb[1], angle1, limb[6]);

        // changes the colour of the segments of the limbs
        if (opm == true) {
            g2d.setColor(Color.YELLOW);
        } else {
            g2d.setColor(Color.BLACK);
        }

        // send the information to draw the second segment
        segment(g2d, limb[2], limb[3], angle2, limb[6]);
    }

    void string(Graphics g) {

        // allows the draw
        Graphics2D g2d = (Graphics2D) g;

        // bag variables
        x[x.length - 1] = 845;     // Set base x-coordinate
        y[x.length - 1] = 0;  // Set base y-coordinate

        // 
        reachSegment(0, mouseX, mouseY);
        for (int i = 1; i < numSegments; i++) {
            reachSegment(i, targetX, targetY);
        }
        for (int i = x.length - 1; i >= 1; i--) {
            positionSegment(i, i - 1);
        }
        for (int i = 0; i < x.length; i++) {
            segment(g2d, x[i], y[i], angle[i], segLength);
        }

    }

    void positionSegment(int a, int b) {
        x[b] = x[a] + Math.cos(angle[a]) * segLength;
        y[b] = y[a] + Math.sin(angle[a]) * segLength;
    }

    void reachSegment(int i, double xin, double yin) {
        double dx = xin - x[i];
        double dy = yin - y[i];
        angle[i] = Math.atan2(dy, dx);
        targetX = xin - Math.cos(angle[i]) * segLength;
        targetY = yin - Math.sin(angle[i]) * segLength;
    }

    void segment(Graphics2D g, double x, double y, double a, double seglength) {

        g.translate(x, y);
        g.rotate(a);
        g.drawLine(0, 0, (int) seglength, 0);
        g.rotate(-a);
        g.translate(-x, -y);

    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        leftArm[0] = 0;
        leftArm[1] = 0;
        leftArm[6] = 60;
        leftArm[7] = 0;

        rightArm[0] = 0;
        rightArm[1] = 0;
        rightArm[6] = 60;
        rightArm[7] = 0;

        leftLeg[0] = 0;
        leftLeg[1] = 0;
        leftLeg[6] = 62.5;
        leftLeg[7] = 1;

        rightLeg[0] = 0;
        rightLeg[1] = 0;
        rightLeg[6] = 62.5;
        rightLeg[7] = 1;


    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {

        // set all of the positions
        leftArm[2] = positionH;
        leftArm[3] = (positionV + 2);

        rightArm[2] = positionH;
        rightArm[3] = (positionV + 2);

        leftLeg[2] = positionH;
        leftLeg[3] = (positionV + 100);
        leftLeg[4] = positionH + runAnime - 25;
        leftLeg[5] = bottemLegV + runLU;

        rightLeg[2] = positionH;
        rightLeg[3] = (positionV + 100);
        rightLeg[5] = bottemLegV + runRU;
        rightLeg[4] = positionH - runAnime + 25;

        leftArm[4] = (positionH - 25) + moveLAH;
        leftArm[5] = positionV + 100 + moveLAV;

        rightArm[4] = (positionH + 25) + moveRAH;
        rightArm[5] = positionV + 100 + moveRAV;


        // running animation
        if (moveRP1 == true && runTimer >= 0 && runTimer < 10) {
            runAnime = runAnime + 5;
            runTimer++;

            // raise the left leg during the run
            if (runTimer >= 0 && runTimer < 5) {
                runLU = runLU - 10;
            } else if (runTimer >= 5 && runTimer < 9) {
                runLU = runLU + 10;
            }

        } else if (moveRP1 == true && runTimer >= 10 && runTimer < 20) {
            runAnime = runAnime - 5;
            runTimer++;

            // raise the right leg during the run
            if (runTimer >= 10 && runTimer < 15) {
                runRU = runRU - 10;
            } else if (runTimer >= 15 && runTimer < 19) {
                runRU = runRU + 10;
            }

            // reset the leg positions
        } else if (moveRP1 == false) {
            runAnime = 0;
            runLU = 0;
            runRU = 0;
        }

        // reset the animation
        if (runTimer >= 20) {
            runTimer = 0;
        }


        // sets gravity to work when needed
        positionV = positionV + gravity;

        if (positionV > 310) {
            positionV = 310;
            gravity = 0;
            backSkip = false;
            skipTimer = 0;
            // allows another jump
        } else if (positionV < 310) {
            gravity = 10;
        }

        // adds a small back skip/dash animation
        if (backSkip = true && skipTimer < 8 && skipTimer > 0) {
            positionV = positionV - 10;
            positionH = positionH - 5;
            skipTimer++;
        }

        // allows the figure to move across the area
        if (moveLP1 == true) {
            positionH = positionH - 5;
        } else if (moveRP1 == true) {
            positionH = positionH + 5;
        }

        // stops the player from going off stage
        if (positionH <= 0) {
            positionH = 0;
        } else if (positionH >= WIDTH) {
            positionH = WIDTH;
        }

        // set the animations to start 
        if (activateLPunch == true && animationFrameL == 0) {
            animationFrameL = 1;
            leftPunching = true;
        } else if (activateRPunch == true && animationFrameR == 0) {
            animationFrameR = 1;
            rightPunching = true;
        }

        // Perform the left punch animation 
        // move the arm forward
        if (leftPunching == true && animationFrameL > 0 && animationFrameL < 10) {
            moveLAV = moveLAV - 8;
            moveLAH = moveLAH + 14;
            animationFrameL++;

            // reset the varibles for the thrid part
        } else if (animationFrameL == 10) {
            leftPunching = false;
            animationFrameL = 20;
            // move the arm back    
        } else if (animationFrameL > 11 && animationFrameL <= 20) {
            moveLAV = moveLAV + 8;
            moveLAH = moveLAH - 14;
            animationFrameL--;
            // allow the punch to happen again    
        } else if (animationFrameL == 11) {
            animationFrameL = 0;
        }

        // Perform the right punch animation 
        // move the arm forward
        if (rightPunching == true && animationFrameR > 0 && animationFrameR < 10) {
            moveRAV = moveRAV - 10;
            moveRAH = moveRAH + 10;
            animationFrameR++;
            // reset the varibles for the thrid part
        } else if (animationFrameR == 10) {
            rightPunching = false;
            animationFrameR = 20;
            // move the arm back    
        } else if (animationFrameR > 11 && animationFrameR <= 20) {
            moveRAV = moveRAV + 10;
            moveRAH = moveRAH - 10;
            animationFrameR--;

            // allow the punch to happen again    
        } else if (animationFrameR == 11) {
            animationFrameR = 0;

        }

        // punch the punching bag
        if (bag.contains(leftArm[4], leftArm[5]) && leftPunching == true) {
            if (opm == false) {
                healthBar = healthBar - 1;
            } else if (opm == true) {
                healthBar = 0;
                onePunched = true;
            }

        } else if (bag.contains(rightArm[4], rightArm[5]) && rightPunching == true) {
            if (opm == false) {
                healthBar = healthBar - 1;
            } else if (opm == true) {
                healthBar = 0;
                onePunched = true;
            }
        }

        // if the bag is one punched it flies around the world infinitely
        if (healthBar == 0 && onePunched == true) {
            bag.x = bag.x + 50;

        }
        if (bag.x >= 2000) {
            bag.x = - 1000;
        }

    }

    // WIP
    void animation(int animationFrame, boolean animation) {


        if (animation == true && animationFrame > 0 && animationFrame < 10) {
            moveLAV = moveLAV - 8;
            moveLAH = moveLAH + 14;
            animationFrame++;

            // reset the varibles for the thrid part
        } else if (animationFrame == 10) {
            animation = false;
            animationFrame = 20;
            // move the arm back    
        } else if (animationFrame > 11 && animationFrame <= 20) {
            moveLAV = moveLAV + 8;
            moveLAH = moveLAH - 14;
            animationFrame--;
            // allow the punch to happen again    
        } else if (animationFrame == 11) {
            animationFrame = 0;
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
            mouseX = e.getX();
            mouseY = e.getY();
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            // get the key code
            int keyCode = e.getKeyCode();

            // which key is being pressed

            // move left
            if (keyCode == KeyEvent.VK_A) {
                moveLP1 = true;

                if (backSkip == false) {
                    if (skipTimer == 0) {
                        backSkip = true;
                        skipTimer = 1;
                    }
                }

                // move right
            } else if (keyCode == KeyEvent.VK_D) {
                moveRP1 = true;

                // do the left punch
            } else if (keyCode == KeyEvent.VK_Q) {
                activateLPunch = true;


                // do the right punch
            } else if (keyCode == KeyEvent.VK_E) {
                activateRPunch = true;

            } // Qwap physics
            // move left arm up
            else if (keyCode == KeyEvent.VK_T) {
                moveLAV = moveLAV - 5;

                // move left arm down
            } else if (keyCode == KeyEvent.VK_G) {
                moveLAV = moveLAV + 5;

                // move right arm up
            } else if (keyCode == KeyEvent.VK_Y) {
                moveRAV = moveRAV - 5;

                // move right arm down
            } else if (keyCode == KeyEvent.VK_H) {
                moveRAV = moveRAV + 5;

                // move left arm left
            } else if (keyCode == KeyEvent.VK_U) {
                moveLAH = moveLAH - 5;

                // move left arm right
            } else if (keyCode == KeyEvent.VK_I) {
                moveLAH = moveLAH + 5;

                // move right arm left
            } else if (keyCode == KeyEvent.VK_J) {
                moveRAH = moveRAH - 5;

                // move right arm right
            } else if (keyCode == KeyEvent.VK_K) {
                moveRAH = moveRAH + 5;

                // makes the character like opm
            } else if (keyCode == KeyEvent.VK_P) {
                if (timer == 0) {
                    if (opm == true) {
                        opm = false;
                        timer++;

                    }
                }
                if (timer == 0) {
                    if (opm == false) {
                        opm = true;
                        timer++;
                    }
                }

                // reset the bag health
            } else if (keyCode == KeyEvent.VK_ENTER) {
                if (healthBar <= 0) {
                    healthBar = 100;
                    bag.x = 800;
                    onePunched = false;
                }

            }


        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            // get the key code
            int keyCode = e.getKeyCode();

            // which key is being pressed


            if (keyCode == KeyEvent.VK_A) {
                moveLP1 = false;

            } else if (keyCode == KeyEvent.VK_D) {
                moveRP1 = false;

                // reset timer for opm
            } else if (keyCode == KeyEvent.VK_P) {
                timer = 0;

                // stop continuous punches  
            } else if (keyCode == KeyEvent.VK_Q) {
                activateLPunch = false;


                // stop continuous punches  
            } else if (keyCode == KeyEvent.VK_E) {
                activateRPunch = false;

            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        FightingGame game = new FightingGame();
    }
}

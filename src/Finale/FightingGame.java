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
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
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
    // line sizes
    BasicStroke biggerLine = new BasicStroke(5);
    BasicStroke bigishLine = new BasicStroke(3);
    BasicStroke normal = new BasicStroke();
    // movement variables for the character
    boolean moveLP1 = false;
    boolean moveRP1 = false;
    // make something follow the mouse
    int mouseX = 0;
    int mouseY = 0;
    // make the limbs
    double[] leftArm = new double[8];
    double[] leftLeg = new double[8];
    double[] rightLeg = new double[8];
    double[] rightArm = new double[8];
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
    int bagGravity = 1;
    // are the arms punching?
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
    // variables for the punching bag
    double healthBar = 100;
    int momentum;
    Rectangle bag = new Rectangle(800, 200, 100, 300);
    Rectangle string = new Rectangle(845, 0, 10, 300);
    // array to make a hit box
    double hitBoxX[] = new double[4];
    double hitBoxY[] = new double[4];
    // check to see if the bag has been hit and do whats required if it is
    boolean haveBeenPunched = false;
    int punchedTimer = 0;
    boolean onePunched = false;
    // string animation
    // how long it is
    int numSegments = 8;
    // arrays that store the positions and the angles of the segments
    double[] x = new double[numSegments];
    double[] y = new double[numSegments];
    double[] angle = new double[numSegments];
    // length of the segments
    double segLength = 25;
    double targetX = 0;
    double targetY = 0;
    // where the end of the string starts
    int endReachX = 845;
    int endReachY = 200;
    // boolean for making the bag fall over
    boolean fallenOver = false;
    // for one punch easter egg
    Color Peach = new Color(252, 200, 159);
    boolean opm = false;
    int timer = 0;
    // for Hulk easter egg
    BasicStroke hulkedOut = new BasicStroke(30);
    int gammaStrength = 1;
    Color trunks = new Color(153, 0, 204);
    Color gamma = new Color(0, 128, 0);
    boolean hulk = false;
    // change the colour of the punching bag
    int bagColour = 0;
    BufferedImage face = loadImage("blah.jpg");

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

    // gain an image
    BufferedImage loadImage(String name) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        // change the colour of the screen if you are One Punch Man
        if (opm == true) {
            if (leftPunching == true || rightPunching == true) {
                g.setColor(Color.BLACK);
            }
        } else {
            g.setColor(Color.WHITE);
        }
        // clear the screen
        g.fillRect(0, 0, WIDTH + 100, HEIGHT + 100);

        // set up the advanced graphics code
        Graphics2D g2d = (Graphics2D) g;

        // GAME DRAWING GOES HERE

        g.setColor(Color.BLACK);
        if (opm == true && hulk == true) {
            g2d.setStroke(biggerLine);
        } else if (hulk == true) {
            g2d.setStroke(hulkedOut);
        } else {
            g2d.setStroke(biggerLine);
        }

        // make the ground
        g.fillRect(0, 525, WIDTH + 100, 100);

        // draw head
        if (opm == true) {
            g.setColor(Peach);
        } else if (hulk == true) {
            g.setColor(gamma);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillOval(positionH - 75 / 2, (positionV - 75), 75, 75);

        // draw body
        if (opm == true) {
            g.setColor(Color.YELLOW);
        } else if (hulk == true) {
            g.setColor(gamma);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawLine(positionH, positionV, positionH, (positionV + 100));

        // draw limbs
        limbMath(g2d, leftLeg);
        limbMath(g2d, rightLeg);
        limbMath(g2d, leftArm);
        limbMath(g2d, rightArm);


        // play with the string
        g.setColor(Color.BLACK);
        g2d.setStroke(biggerLine);
        string(g);

        // change the coloour of the bag
        if (bagColour == 0) {
            g.setColor(Color.BLACK);
        } else if (bagColour == 1) {
            g.setColor(Color.RED);
        } else if (bagColour == 2) {
            g.setColor(Color.ORANGE);
        } else if (bagColour == 3) {
            g.setColor(Color.YELLOW);
        } else if (bagColour == 4) {
            g.setColor(Color.GREEN);
        } else if (bagColour == 5) {
            g.setColor(Color.CYAN);
        } else if (bagColour == 6) {
            g.setColor(Color.BLUE);
        } else if (bagColour == 7) {
            g.setColor(trunks);
        } else if (bagColour == 8) {
            g.setColor(Color.MAGENTA);
        } else if (bagColour == 9) {
            g.setColor(Color.PINK);
        } else if (bagColour == 10) {
            bagColour = 0;
        }

        // draw the punching bag
        if (healthBar != 0) {
            g2d.translate(bag.x + bag.width / 2, bag.y);
            g2d.rotate(angle[0] - (Math.PI / 2));
            g2d.fillRect(-bag.width / 2, 0, bag.width, bag.height);
            g2d.rotate(-(angle[0] - (Math.PI / 2)));
            g2d.translate(-bag.x - bag.width / 2, -bag.y);
        } else {
            g2d.fill(bag);
        }

        // Punching bag health bar
        g.setColor(Color.BLACK);
        g.fillRect(325, 25, 350, 50);
        g.setColor(Color.RED);
        g.fillRect(350, 30, 300, 40);
        g.setColor(Color.GREEN);
        g.fillRect(350, 30, (3 * (int) healthBar), 40);


        // GAME DRAWING ENDS HERE
    }

    // creates the limbs positions 
    void limbMath(Graphics2D g2d, double[] limb) {

        // determines the angle that the bottem leg will be at 
        double dx = limb[4] - limb[0];
        double dy = limb[5] - limb[1];
        double angle1 = Math.atan2(dy, dx);

        // determine the mid-point between the top and bottom of the leg 
        double tx = limb[4] - Math.cos(angle1) * limb[6];
        double ty = limb[5] - Math.sin(angle1) * limb[6];

        // creates a right angle triangle with the mid-point and the bottom point
        dx = tx - limb[2];
        dy = ty - limb[3];
        // determines the angle for how much it opens from the midpoint
        double angle2 = Math.atan2(dy, dx);

        // figures out where the knee will be displayed
        limb[0] = limb[2] + Math.cos(angle2) * limb[6];
        limb[1] = limb[3] + Math.sin(angle2) * limb[6];

        // stop the legs from caving in
        if (limb[7] == 1) {
            if (angle2 > angle1) {
                double angleD = angle1 - angle2;
                angle2 = angle1; // + angleD;
                limb[0] = limb[2] + Math.cos(angle2) * limb[6];
                limb[1] = limb[3] + Math.sin(angle2) * limb[6];
            }
            // stop the arms from caving in
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
        } else if (hulk == true) {
            g2d.setColor(gamma);
        } else {
            g2d.setColor(Color.BLACK);
        }
        // send the information to draw the first segment
        segment(g2d, limb[0], limb[1], angle1, limb[6]);

        // changes the colour of the segments of the limbs
        if (opm == true) {
            g2d.setColor(Color.YELLOW);
        } else if (hulk == true && limb[7] == 1) {
            g2d.setColor(trunks);
        } else if (hulk == true) {
            g2d.setColor(gamma);
        } else {
            g2d.setColor(Color.BLACK);
        }

        // send the information to draw the second segment
        segment(g2d, limb[2], limb[3], angle2, limb[6]);
    }

    // runs all of the methods that make string 
    void string(Graphics g) {

        // allows the draw
        Graphics2D g2d = (Graphics2D) g;

        // bag variables
        x[x.length - 1] = 845;     // Set base x-coordinate
        y[x.length - 1] = 0;  // Set base y-coordinate


        // draw the first segment
        reachSegment(0, endReachX, endReachY);
        // draw each segment after the first
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

    // determines where the next point in the sequence will be
    void positionSegment(int a, int b) {
        // the next points position
        x[b] = x[a] + Math.cos(angle[a]) * segLength;
        y[b] = y[a] + Math.sin(angle[a]) * segLength;
    }

    // rotate the points
    void reachSegment(int i, double xin, double yin) {
        double dx = xin - x[i];
        double dy = yin - y[i];
        angle[i] = Math.atan2(dy, dx);
        targetX = xin - Math.cos(angle[i]) * segLength;
        targetY = yin - Math.sin(angle[i]) * segLength;
    }

    // moves the screen to create a rotated limb
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

        // set the starting position of all the non-changing limb parts and lengths
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

        // set all of the positions of the changing limb variables so the guy can move
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

        // move the bag back to a regular width and height
        if (healthBar != 0) {
            bag.width = 100;
            bag.height = 300;
        }

        // stop the legs from going into the ground
        if (rightLeg[5] > 525) {
            rightLeg[5] = 525;
        } else if (leftLeg[5] > 525) {
            leftLeg[5] = 525;
        }

        // bag is attached to string
        if (onePunched == false) {
            bag.x = (int) x[0] - 45;
            bag.y = (int) y[0];
        }

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

        // back swings more and takes more damage if hulked out
        if (hulk == true) {
            gammaStrength = 4;
        } else {
            gammaStrength = 1;
        }

        // punching the punching bag does damage it and starts it moving
        // left punch hits
        if (healthBar != 0) {
            if (bag.contains(leftArm[4], leftArm[5]) && leftPunching == true) {
                if (opm == false) {
                    healthBar = healthBar - 1;
                    if (haveBeenPunched == false) {
                        haveBeenPunched = true;
                    } else if (haveBeenPunched == true) {
                        punchedTimer = 0;
                        haveBeenPunched = true;
                    }

                } else if (opm == true) {
                    healthBar = 0;
                    onePunched = true;
                }

                // right punch hits
            } else if (bag.contains(rightArm[4], rightArm[5]) && rightPunching == true) {
                // if you are not one punch man
                if (opm == false) {
                    // bag health goes down
                    healthBar = healthBar - 1 * gammaStrength;
                    // starts the swinging
                    if (haveBeenPunched == false) {
                        haveBeenPunched = true;
                    } else if (haveBeenPunched == true) {
                        punchedTimer = 0;
                        haveBeenPunched = true;
                    }
                    // if one punch man is true, insta-kill the bag
                } else if (opm == true) {
                    healthBar = 0;
                    onePunched = true;
                }
            }
            // Bag swings when it's punched
            if (haveBeenPunched == true && punchedTimer == 0) {
                punchedTimer = 1;
            }
        }

        // it swings right
        if (punchedTimer > 0 && punchedTimer < 11) {
            endReachX = endReachX + 5 * gammaStrength;
            endReachY = endReachY - 1 * gammaStrength;
            punchedTimer++;
            // it swings left
        } else if (punchedTimer > 10 && punchedTimer < 31) {
            endReachX = endReachX - 5 * gammaStrength;
            endReachY = endReachY + 1 * gammaStrength;
            punchedTimer++;
            // resets the animation
        } else if (punchedTimer > 30) {
            haveBeenPunched = false;
            punchedTimer = 0;
        }

        // bag tries to go back to it's original position
        // gravity for the bag
        endReachY = endReachY + bagGravity;

        if (!(punchedTimer > 0 && punchedTimer < 11) && endReachX > 845) {
            endReachX = endReachX - 5;
        } else if (!(punchedTimer > 0 && punchedTimer < 11) && endReachX < 845) {
            endReachX = endReachX + 5;
        } else if (endReachY > 200) {
            endReachY = 200;
        }


        // if the bag is one punched it flies around the world infinitely
        if (healthBar == 0 && onePunched == true) {
            bag.x = bag.x + 50;

        } else if (healthBar == 0 && onePunched == false) {
            punchBagDeath();
        }
        // when it's far off it sends the bag to the other side of the screen
        if (bag.x >= 2000) {
            bag.x = - 1000;
        }



    }

    void punchBagDeath() {
        // bag falls to the ground

        while (bag.y + bag.height < 525) {
            bag.y = bag.y + 1;

        }
        bag.y = 525 - bag.height;

        if (fallenOver == false) {
            if (bag.contains(leftArm[4], leftArm[5]) && leftPunching == true) {
                bag = new Rectangle(800, 425, 300, 100);
                fallenOver = true;
            } else if (bag.contains(rightArm[4], rightArm[5]) && rightPunching == true) {
                bag = new Rectangle(800, 425, 300, 100);
                fallenOver = true;
            }



        }

    }

    // a function to make a box that can be rotated manually
    void hitBoxRotation() {

        // x = x * cosA - y * sinA
        // y = x * sinA + y * cosA
        // bag.x+bag.width/2, bag.y
        // -bag.width/2, 0, bag.width, bag.height
        // Rotates the bag hit box
        hitBoxX[0] = (-bag.width / 6) * Math.cos(angle[0] - (Math.PI / 2)) - 0 * Math.sin(angle[0] - (Math.PI / 2)) + bag.x;  // box.x 
        hitBoxX[1] = bag.width / 6 * Math.cos(angle[0] - (Math.PI / 2)) - 0 * Math.sin(angle[0] - (Math.PI / 2)) + bag.x + bag.width;  // box.x + bag.width
        hitBoxX[2] = bag.width / 6 * Math.cos(angle[0] - (Math.PI / 2)) - bag.height * Math.sin(angle[0] - (Math.PI / 2)) + bag.x + bag.width;  // box.x + bag.width
        hitBoxX[3] = (-bag.width / 6) * Math.cos(angle[0] - (Math.PI / 2)) - bag.height * Math.sin(angle[0] - (Math.PI / 2)) + bag.x;  // box.x

        hitBoxY[0] = (-bag.width / 6) * Math.sin(angle[0] - (Math.PI / 2)) + 0 * Math.cos(angle[0] - (Math.PI / 2)) + bag.y;  // box.y
        hitBoxY[1] = bag.width / 6 * Math.sin(angle[0] - (Math.PI / 2)) + 0 * Math.cos(angle[0] - (Math.PI / 2)) + bag.y;  // box.y
        hitBoxY[2] = bag.width / 6 * Math.sin(angle[0] - (Math.PI / 2)) + bag.height * Math.cos(angle[0] - (Math.PI / 2)) + bag.height / 2;  // box.y + bag.height
        hitBoxY[3] = (-bag.width / 6) * Math.sin(angle[0] - (Math.PI / 2)) + bag.height * Math.cos(angle[0] - (Math.PI / 2)) + bag.height / 2;  // box.y + bag.height


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
                // incredible Hulk easter egg
            } else if (keyCode == KeyEvent.VK_B) {
                if (timer == 0) {
                    if (hulk == true) {
                        hulk = false;
                        timer++;

                    }
                }
                if (timer == 0) {
                    if (hulk == false) {
                        hulk = true;
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
                // changes the colour of the bag
            } else if (keyCode == KeyEvent.VK_C) {
                if (timer == 0) {
                    bagColour++;
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

                // reset timer for hulk
            } else if (keyCode == KeyEvent.VK_B) {
                timer = 0;

            } else if (keyCode == KeyEvent.VK_C) {
                timer = 0;
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

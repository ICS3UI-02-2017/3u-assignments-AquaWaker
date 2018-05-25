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
import javax.swing.Timer;

/**
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
    int desiredFPS = 60;
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
//    double x, y, startAX = 150, startAY = 300;
//    double x2 = 150, y2 = 300; 
    
    double[] leftArm = new double[7];
    double[] leftLeg = new double[7];
    double[] rightLeg = new double[7];
    double[] rightArm = new double[7];
    double[] leftArmP2 = new double[7];
    double[] leftLegP2 = new double[7];
    double[] rightLegP2 = new double[7];
    double[] rightArmP2 = new double[7];
   
    // movement variables
    int moveLAV = 0;
    int moveRAV = 0;
    int moveLAH = 0;
    int moveRAH = 0;
    
    // sets the horizontal starting spot
    int position = 150;
    
    // is it punching?
    boolean leftPunch = false;
    boolean rightPunch = false;
    // helps with animation
    int animationFrameL = 0;
    int animationFrameR = 0;

    // for one punch easter egg
    Color Peach = new Color(252, 200, 159);
    boolean opm = false;
    int timer = 0;
    
    
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
        g.clearRect(0, 0, WIDTH, HEIGHT);

        Graphics2D g2d = (Graphics2D) g;

        // GAME DRAWING GOES HERE
        g.setColor(Color.BLACK);
        g2d.setStroke(biggerLine);

        // make the ground
        g.fillRect(0, 525, WIDTH, 75);

        // draw head
        if (opm == true){
            g.setColor(Peach);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillOval(position - 75/2, 225, 75, 75);

        // draw body
        if (opm == true){
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawLine(position, 300, position, 400);

        // draw limbs
        limbMath(g2d, leftArm);
        limbMath(g2d, rightArm);
        
        if (opm == true){
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.BLACK);
        }
        limbMath(g2d, leftLeg);
        limbMath(g2d, rightLeg);

//        // right arm
//        g.drawLine(150, 300, 175, 375);
//        g.drawLine(175, 375, 200, 300);
//
//        // left arm
//        g.drawLine(150, 300, 125, 375);
//        g.drawLine(125, 375, 175, 325);


        // GAME DRAWING ENDS HERE
    }

    // determines the angle
    void limbMath(Graphics2D g2d, double[] limb) {

        //System.out.println("---NOT WORKING");

        double dx = limb[4] - limb[0];
        double dy = limb[5] - limb[1];
        double angle1 = Math.atan2(dy, dx);
        //System.out.printf("DX: %f  DY: %f  angle1: %f \n", dx, dy, angle1);
        double tx = limb[4] - Math.cos(angle1) * limb[6];
        double ty = limb[5] - Math.sin(angle1) * limb[6];
        //System.out.printf("TX: %f  TY: %f \n", tx, ty);
        dx = tx - limb[2];
        dy = ty - limb[3];
        double angle2 = Math.atan2(dy, dx);
        //;System.out.printf("DX: %f  DY: %f  angle2: %f \n", dx, dy, angle2);
        limb[0] = limb[2] + Math.cos(angle2) * limb[6];
        limb[1] = limb[3] + Math.sin(angle2) * limb[6];
        //System.out.printf("X: %f  Y: %f  \n", x, y);

        if (opm == true){
            g2d.setColor(Color.RED);
        } else {
            g2d.setColor(Color.BLACK);
        }
        segment(g2d, limb[0], limb[1], angle1, limb[6]);
        
        if (opm == true){
            g2d.setColor(Color.YELLOW);
        } else {
            g2d.setColor(Color.BLACK);
        }
        segment(g2d, limb[2], limb[3], angle2, limb[6]);
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
        leftArm[3] = 302;
        leftArm[6] = 60;

        rightArm[0] = 0;
        rightArm[1] = 0;
        rightArm[3] = 302;
        rightArm[6] = 60;

        leftLeg[0] = 0;
        leftLeg[1] = 0;
        leftLeg[3] = 400;
        leftLeg[5] = 525;
        leftLeg[6] = 62.5;

        rightLeg[0] = 0;
        rightLeg[1] = 0;
        rightLeg[3] = 400;
        rightLeg[5] = 525;
        rightLeg[6] = 62.5;
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {

        leftArm[2] = position;
        rightArm[2] = position;
        leftLeg[2] = position;
        leftLeg[4] = position - 25;
        rightLeg[2] = position;
        rightLeg[4] = position + 25;

        leftArm[4] = (position - 25) + moveLAH;
        leftArm[5] = 400 + moveLAV;

        rightArm[4] = (position + 25) + moveRAH;
        rightArm[5] = 400 + moveRAV;


        // starts to avoid the arm wanting to reach a point farther then it can reach
        if (moveLAH >= 80) {
            moveLAH = 80;
        } else if (moveLAV >= 80) {
            moveLAH = 80;
        } else if (moveRAH >= 80) {
            moveLAH = 80;
        } else if (moveRAV >= 80) {
            moveLAH = 80;
        }

        // allows the figure to move across the area
        if (moveLP1 == true) {
            position = position - 5;
        } else if (moveRP1 == true) {
            position = position + 5;
        }

        // stops the player from going off stage
        if (position <= 0) {
            position = 0;
        } else if (position >= WIDTH) {
            position = WIDTH;
        }

        // Perform the left punch animation 
        // move the arm forward
        if (leftPunch == true && animationFrameL > 0 && animationFrameL < 10) {
            moveLAV = moveLAV - 3;
            moveLAH = moveLAH + 12;
            animationFrameL++;
            
        // reset the varibles for the thrid part
        } else if (animationFrameL == 10) {
            leftPunch = false;
            animationFrameL = 20;
        // move the arm back    
        } else if (animationFrameL > 11 && animationFrameL <= 20) {
            moveLAV = moveLAV + 3;
            moveLAH = moveLAH - 12;
            animationFrameL--;
            // allow the punch to happen again    
        } else if (animationFrameL == 11){
            animationFrameL = 0;
        }

        // Perform the right punch animation 
        // move the arm forward
        if (rightPunch == true && animationFrameR > 0 && animationFrameR < 10) {
            moveRAV = moveRAV - 3;
            moveRAH = moveRAH + 12;
            animationFrameR++;
        // reset the varibles for the thrid part
        } else if (animationFrameR == 10) {
            rightPunch = false;
            animationFrameR = 20;
        // move the arm back    
        } else if (animationFrameR > 11 && animationFrameR <= 20) {
            moveRAV = moveRAV + 3;
            moveRAH = moveRAH - 12;
            animationFrameR--;

            // allow the punch to happen again    
        } else if (animationFrameR == 11){
            animationFrameR = 0;

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
                // move right
            } else if (keyCode == KeyEvent.VK_D) {
                moveRP1 = true;

                // do the left punch
            } else if (keyCode == KeyEvent.VK_Q) {
                if (animationFrameL == 0) {
                    leftPunch = true;
                    animationFrameL = 1;
                }

                // do the right punch
            } else if (keyCode == KeyEvent.VK_E) {
                if (animationFrameR == 0) {
                    rightPunch = true;
                    animationFrameR = 1;
                }
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
            } else if (keyCode == KeyEvent.VK_P){
                if (timer == 0){
                    if(opm == true){
                        opm = false;
                        timer++;
                    } 
                }
                if (timer == 0){
                    if(opm == false){
                        opm = true;
                        timer++;
                    } 
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
            } else if (keyCode == KeyEvent.VK_P){
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

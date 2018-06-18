package Finale;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;

/**
 *
 * @author pritb9521
 */
public class AnimationFunStuffs extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "My Game";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    // line sizes
    BasicStroke biggerLine = new BasicStroke(5);
    BasicStroke bigishLine = new BasicStroke(3);
    BasicStroke normal = new BasicStroke();
    Rectangle string = new Rectangle(845, 0, 10, 300);
    // string animation
    // make something follow the mouse
    int mouseX = 0;
    int mouseY = 0;
    // how long it is
    int numSegments = 15;
    // arrays that store the positions and the angles of the segments
    double[] firstStringX = new double[numSegments];
    double[] firstStringY = new double[numSegments];
    double[] angle = new double[numSegments];
    
    double[] secondStringX = new double[numSegments];
    double[] secondStringY = new double[numSegments];
    
    double[] thirdStringX = new double[numSegments];
    double[] thirdStringY = new double[numSegments];
    
    double[] fourthStringX = new double[numSegments];
    double[] fourthStringY = new double[numSegments];
    
    double[] fifthStringX = new double[numSegments];
    double[] fifthStringY = new double[numSegments];
    
    double[] sixthStringX = new double[numSegments];
    double[] sixthStringY = new double[numSegments];
    
    double[] sevenStringX = new double[numSegments];
    double[] sevenStringY = new double[numSegments];
    
    // length of the segments
    double segLength = 25;
    double targetX = 0;
    double targetY = 0;
    // where the end of the string starts
    int endReachX = mouseX;
    int endReachY = mouseY;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public AnimationFunStuffs() {
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

        // GAME DRAWING GOES HERE

        // set up the advanced graphics code
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.BLACK);
        g2d.setStroke(biggerLine);

        // play with the string
        
        firstStringX[firstStringX.length - 1] = WIDTH / 2;     // Set base x-coordinate
        firstStringY[firstStringX.length - 1] = HEIGHT;  // Set base y-coordinate
        string(g, firstStringX, firstStringY);
        
        secondStringX[secondStringX.length - 1] = WIDTH / 4;     // Set base x-coordinate
        secondStringY[secondStringX.length - 1] = HEIGHT;  // Set base y-coordinate
        string(g, secondStringX, secondStringY);

        thirdStringX[thirdStringX.length - 1] = WIDTH*3 / 4;     // Set base x-coordinate
        thirdStringY[thirdStringX.length - 1] = HEIGHT;  // Set base y-coordinate
        string(g, thirdStringX, thirdStringY);
        
        fourthStringX[fourthStringX.length - 1] = WIDTH / 4;     // Set base x-coordinate
        fourthStringY[fourthStringX.length - 1] = 0;  // Set base y-coordinate
        string(g, fourthStringX, fourthStringY);

        fifthStringX[fifthStringX.length - 1] = WIDTH*3 / 4;     // Set base x-coordinate
        fifthStringY[fifthStringX.length - 1] = 0;  // Set base y-coordinate
        string(g, fifthStringX, fifthStringY);
        
//        secondStringX[secondStringX.length - 1] = WIDTH / 4;     // Set base x-coordinate
//        secondStringY[secondStringX.length - 1] = HEIGHT;  // Set base y-coordinate
//        string(g, secondStringX, secondStringY);
//        
//        secondStringX[secondStringX.length - 1] = WIDTH / 4;     // Set base x-coordinate
//        secondStringY[secondStringX.length - 1] = HEIGHT;  // Set base y-coordinate
//        string(g, secondStringX, secondStringY);
        // GAME DRAWING ENDS HERE
    }

    // runs all of the methods that make string 
    void string(Graphics g, double[] x, double[] y) {

        // allows the draw
        Graphics2D g2d = (Graphics2D) g;

        // bag variables


        // draw the first segment
//        reachSegment(0, endReachX, endReachY);
        double dx = endReachX - x[0];
        double dy = endReachY - y[0];
        angle[0] = Math.atan2(dy, dx);
        targetX = endReachX - Math.cos(angle[0]) * segLength;
        targetY = endReachY - Math.sin(angle[0]) * segLength;
        // draw each segment after the first
        for (int i = 1; i < numSegments; i++) {
//            reachSegment(i, targetX, targetY);
            dx = targetX - x[i];
            dy = targetY - y[i];
            angle[i] = Math.atan2(dy, dx);
            targetX = targetX - Math.cos(angle[i]) * segLength;
            targetY = targetY - Math.sin(angle[i]) * segLength;
        }
        for (int i = x.length - 1; i >= 1; i--) {
//            positionSegment(i, i - 1);

            x[i - 1] = x[i] + Math.cos(angle[i]) * segLength;
            y[i - 1] = y[i] + Math.sin(angle[i]) * segLength;
        }
        for (int i = 0; i < x.length; i++) {
            segment(g2d, x[i], y[i], angle[i], segLength);
        }



    }

    // determines where the next point in the sequence will be
//    void positionSegment(int a, int b) {
//        // the next points position
//        x[b] = x[a] + Math.cos(angle[a]) * segLength;
//        y[b] = y[a] + Math.sin(angle[a]) * segLength;
//    }
    // rotate the points
//    void reachSegment(int i, double xin, double yin) {
//        double dx = xin - x[i];
//        double dy = yin - y[i];
//        angle[i] = Math.atan2(dy, dx);
//        targetX = xin - Math.cos(angle[i]) * segLength;
//        targetY = yin - Math.sin(angle[i]) * segLength;
//    }
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
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        endReachX = mouseX;
        endReachY = mouseY;
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
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        AnimationFunStuffs game = new AnimationFunStuffs();
    }
}

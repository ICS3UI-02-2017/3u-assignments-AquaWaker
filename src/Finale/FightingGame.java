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
    
    double segLength = 80;
    double x, y, x2, y2;
    
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

        g.fillRect(0, 525, WIDTH, 75);

        
        double dx = 150 - x;
        double dy = 300 - y;
        double angle1 = Math.atan2(dy, dx);  
  
        double tx = 150 - Math.cos(angle1) * segLength;
        double ty = 300 - Math.sin(angle1) * segLength;
        dx = tx - x2;
        dy = ty - y2;
        double angle2 = Math.atan2(dy, dx);  
        x = x2 + Math.cos(angle2) * segLength;
        y = y2 + Math.sin(angle2) * segLength;
  
        segment(g2d,x, y, angle1); 
        segment(g2d,x2, y2, angle2); 
        
        
        
        // head
        g.fillOval(100, 200, 100, 100);

        // body
        g.drawLine(150, 300, 150, 400);

        // right leg
        g.drawLine(150, 400, 165, 430);

        // left leg
        g.drawLine(150, 400, 145, 430);

//        // right arm
//        g.drawLine(150, 300, 175, 375);
//        g.drawLine(175, 375, 200, 300);
//
//        // left arm
//        g.drawLine(150, 300, 125, 375);
//        g.drawLine(125, 375, 175, 325);


        // GAME DRAWING ENDS HERE
    }

    void segment(Graphics2D g, double x, double y, double a) {

        g.translate(x, y);
        g.rotate(a);
        g.drawLine(0, 0, (int) segLength, 0);
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
            int mouseX = e.getX();
            int mouseY = e.getY();
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

            if (keyCode == KeyEvent.VK_A) {
                moveLP1 = true;
            } else if (keyCode == KeyEvent.VK_D) {
                moveRP1 = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            // get the key code
            int keyCode = e.getKeyCode();

            // which key is being pressed

            if (keyCode == KeyEvent.VK_W) {
            } else if (keyCode == KeyEvent.VK_A) {
            } else if (keyCode == KeyEvent.VK_S) {
            } else if (keyCode == KeyEvent.VK_D) {
            }
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
        FightingGame game = new FightingGame();
    }
}

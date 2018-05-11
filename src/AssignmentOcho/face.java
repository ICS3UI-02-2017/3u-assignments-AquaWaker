package AssignmentOcho;

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
public class face extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 500;
    static final int HEIGHT = 500;

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
    int[] hairX = {180, 320, 295, 205};
    int[] hairY = {150, 150, 255, 255};
    
    Color Brown = new Color(122, 58, 6);
    Color Peach = new Color(252, 200, 159);
    Color toneHighlight = new Color(239, 165, 107);
    Color mustache = new Color(61, 28, 3);
    Color trueGreen = new Color(82, 175, 68);
    
    int[] faceX = {190, 310, 285, 215};
    int[] faceY = {150, 150, 280, 280};
    
    BasicStroke biggerLine = new BasicStroke(5);
    BasicStroke bigishLine = new BasicStroke(3);
    BasicStroke normal = new BasicStroke();
    
    int eyeBrowY = 150;
    int eyebrowChange = 1;
    
    int mustacheL = 135;
    int mustacheEh = 200;
    int mustacheR = 190;
    int mustacheUgh = 215;
    int mustacheChange = 1;
    
    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public face(){
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
        
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        
        // back hat
        g2d.setStroke(biggerLine);
        g.setColor(Color.BLACK);
        g.drawOval(165, 125, 170, 75);
        
        g.setColor(trueGreen);
        g.fillOval(165, 125, 170, 75);
        
        // hair
        g.setColor(Brown);
        g.fillPolygon(hairX, hairY, 4);
        g.fillOval(270, 285, 15, 15);
        g.fillOval(215, 285, 15, 15);
	
        // face
        g.setColor(Peach);
        g.fillPolygon(faceX, faceY, 4);
	
        g.fillArc(215, 250, 70, 60, 180, 180);
        
        // hat
        g.setColor(trueGreen);
        g.fillArc(161, 75, 178, 125, 320, 260);
        
        g.setColor(Color.white);
        g.fillOval(224, 90, 50, 50);
        
        g.setColor(trueGreen);
        g.fillRect(237, 100, 10, 30);
        g.fillRect(237, 120, 25, 10);
        
        // eye brows
        g.setColor(mustache);
        g.fillOval(207, eyeBrowY, 35, 20);
        g.fillOval(257, eyeBrowY, 35, 20);
        
        g.setColor(Peach);
        g.fillOval(207, (eyeBrowY+10), 35, 20);
        g.fillOval(257, (eyeBrowY+10), 35, 20);
        
        // eyes
        g.setColor(Color.white);
        g.fillOval(217, 165, 25, 50);
        g.fillOval(257, 165, 25, 50);
        
        g.setColor(Color.CYAN);
        g.fillOval(225, 175, 18, 35);
        g.fillOval(258, 175, 18, 35);
        
        g.setColor(Color.BLACK);
        g.fillOval(230, 180, 12, 30);
        g.fillOval(259, 180, 12, 30);
        
        // mustache
        g.setColor(mustache);
        g.fillArc(190, 210, 80, 60, mustacheL, mustacheEh);
        g.fillArc(230, 210, 80, 60, mustacheUgh, mustacheR);
        
        // nose
        g2d.setStroke(normal);
        g.setColor(Peach);
        g.fillOval(220, 200, 60, 60);
        g.setColor(toneHighlight);
        g.drawOval(220, 200, 60, 60);
        
        // smile
        g2d.setStroke(bigishLine);
        g.setColor(Color.BLACK);
        g.drawArc(230, 265, 40, 15, 190, 160);
        
        
        // GAME DRAWING ENDS HERE
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        
        if (eyeBrowY == 145) {
            eyebrowChange = 1;
        } else if (eyeBrowY == 155) {
            eyebrowChange = -1;
        }
        
        if (mustacheL == 135){
            mustacheChange = 1;
        } else if(mustacheL == 160) {
            mustacheChange = - 1;
        }
        
        eyeBrowY = eyeBrowY + eyebrowChange;
        
        mustacheL = mustacheL + mustacheChange;
        mustacheEh = mustacheEh - mustacheChange;
        mustacheR = mustacheR - mustacheChange;
        
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
        face game = new face();
    }
}


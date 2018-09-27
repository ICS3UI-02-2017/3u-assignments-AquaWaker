package EnglishProject;

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
public class MediaProject extends JComponent implements ActionListener {

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
    
    String[] analysis = new String[10];
    
    // make something follow the mouse
    int mouseX = 0;
    int mouseY = 0;
    
    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public MediaProject() {
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

        
        // GAME DRAWING ENDS HERE
    }

   

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        
        analysis[0] = "The Author of this piece of work is K.R. Hamilton, \n
        and the work is a Game Design Document, or a GDD, for a game called Race’n’Chase";

        
        analysis[1] = "The purpose of a GDD is to present the idea of a game, with all the specific details, to the team \n
        that are going to be working on the game that has been laid out for them, and they will use the \n
        GDD as a reference to make sure everyone is working on the same project, and will be a cane \n
        for them to walk on while the game takes shape.  This is so that in the end, there is a finished, \n
        working product that can be put into stores which is where the investment of time and money \n
        pays back.";
        
        analysis[2] = "The ‘arguments’ that the author uses to get their point of the game across comes in two main ideas, \n
        specification, and gameplay.";
            
        analysis[3] = "Now what does it mean by specification?  Specification would include the finer details of the \n
        project that shape the game to have complete thoughts and function properly, but may not \n
        include directly any playable part of the game.  Some examples of this are the concept and \n
        story, the objectives, and finally details that specify system limitations.";
            
        analysis[4] = "Concept and store aren’t as important then maybe a game such as Doom, or even the Mario \n
        bros because of when it was made, because it’s a multiplayer game.  Back in 1995 when this \n
        game was produced, a game that functioned as a multiplayer cops and robbers time game \n
        would be what they focused on, not any story.";

        analysis[5] = "Objectives is explained more thoroughly in Race’N’Chase as it describes the goals the player \n
        will have, whether it be racing across a city from point A to point B, or trying to crash into \n
        people’s cars, the goals are clearly defined showing a larger focus on the playing aspect of the \n
        game, rather than any story that they could fit in.";
            
        analysis[6] = "Finally the specification includes the details like the system they are programming the game for, \n
        the main ones being Windows 95 and PlayStation 1, and they go over details such as the ram \n
        and graphic capabilities that they have to work within so that the game’s intended audience can \n
        properly play the game.";

        analysis[7] = "

        
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
        MediaProject game = new MediaProject();
    }
}

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

// GamePanel is inheriting  attributes and methods of JPanel
// GamePanel is taking methods of ActionListener (allows for processing an
// action event)
public class GamePanel extends JPanel implements ActionListener {
    
    // final means constant; the value cannot change
    static final int SCREEN_HEIGHT = 600; 
    static final int SCREEN_WIDTH =  600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    // square brackets [] indicate there is an array
    final int x[] = new int [GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    int bodyParts = 6; 
    int applesEaten;
    int applesX;
    int applesY;
    char direction = 'R';
    boolean running = false;
    // triggers action events at certain intervals
    Timer timer;
    // used to generate random numbers
    Random random;

    GamePanel() {

    }

    public void startGame() {

    }
    // Graphics allows application to draw onto components
    public void paintComponent(Graphics g) {
        
    }

    public void draw(Graphics g) {
        
    }

    public void move() {

    }

    public void checkApple() {

    }

    public void checkCollisions() {

    }

    public void gameOver(Graphics g) {

    }

    // @override is used when we override a method in subclass
    // in this case the actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    // keyadapter is class for receiving keyboard events
    public class MyKeyAdapter extends KeyAdapter {

    }
}

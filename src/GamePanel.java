import java.awt.Color;
import java.awt.Dimension;
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
    static final int UNIT_SIZE = 50;
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
        random = new Random();
        // set the preferred size for each JPanel object
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        // set background settings
        this.setBackground(Color.black);
        // gives component option of being focused on or not
        this.setFocusable(true);
        // adds listener that is triggered when keys are pressed
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    // Graphics allows application to draw onto components
    public void paintComponent(Graphics g) {
        // paints over parts that haven't been painted over
        super.paintComponent(g);
        // calls draw() method
        draw(g);
    }

    public void draw(Graphics g) {        
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            // draws line in format (x1, x2, y1, y2)
            g.setColor(Color.darkGray);
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
        }
        g.setColor(Color.RED);
        g.fillOval(applesX, applesY, UNIT_SIZE, UNIT_SIZE);
        
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0 ) {
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            } else {
                g.setColor(new Color(45, 180, 0));
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }

    public void newApple() {
        applesX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        applesY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        // the switch statement basically has different outcomes 
        // depending on the value of the expression
        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {

    }

    public void checkCollisions() {
        // check if head collides w/ any part of body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        //  puts restriction on left side of panel
        if(x[0] < 0) {
            running = false;
        }
        //  puts restriction on top of panel
        if(y[0] < 0) {
            running = false;
        }
        //  puts restriction on bottom of panel
        if(x[0] > SCREEN_WIDTH) {
            running = false;
        }
        //  puts restriction on right side of panel
        if(y[0] > SCREEN_HEIGHT) {
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {

    }

    // @override is used when we override a method in subclass
    // in this case the actionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    // keyadapter is class for receiving keyboard events
    public class MyKeyAdapter extends KeyAdapter {

    }
}

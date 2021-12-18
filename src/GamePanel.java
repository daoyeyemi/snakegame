import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import javax.swing.JPanel;

// GamePanel is inheriting  attributes and methods of JPanel
// GamePanel is taking methods of ActionListener (allows for processing an
// action event)
public class GamePanel extends JPanel implements ActionListener {
    
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

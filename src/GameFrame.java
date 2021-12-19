import javax.swing.JFrame;

public class GameFrame extends JFrame {
    
    GameFrame() {
        // add area where things like buttons checkboxes and textfields 
        // can be added
        this.add(new GamePanel());
        // sets title of Frame / browser
        this.setTitle("Snake");
        // adds exit button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // makes it so that user can't resize interface
        this.setResizable(false);
        // make frame so that it fits snugly around components within
        this.pack();
        // controls whether or not component is displayed onscreen
        this.setVisible(true);
        // centers to middle of whatever component it is in
        this.setLocationRelativeTo(null); 
    }
}

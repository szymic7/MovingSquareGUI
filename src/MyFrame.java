import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {

    private JPanel jPanel;
    private MyPanel myPanel;

    public MyFrame() {
        this.generateFrame();
    }

    public void generateFrame() {

        // JFrame
        this.setTitle("SIMPLE WINDOW APP");
        this.setSize(835, 657);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JPanel
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());
        jPanel.setFocusable(false);
        jPanel.setSize(this.getSize());
        this.add(jPanel);

        // MyPanel - field
        myPanel = new MyPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        jPanel.add(myPanel, gbc);

        this.addKeyListener(this);

        // Thread responsible for updating square's position
        this.startThread();

    }

    public void startThread() {

        Timer timer = new Timer(30, e -> {
            if(myPanel.getSquare().getX() <= - myPanel.getSquare().getA() || myPanel.getSquare().getX() >= myPanel.getWidth() ||
                    myPanel.getSquare().getY() <= - myPanel.getSquare().getA() || myPanel.getSquare().getY() >= myPanel.getHeight()) {
                myPanel.setSquare(new Square());
            }

            myPanel.repaint();
        });

        timer.start();

    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                myPanel.getSquare().setX(myPanel.getSquare().getX() + 10);
                break;
            case KeyEvent.VK_LEFT:
                myPanel.getSquare().setX(myPanel.getSquare().getX() - 10);
                break;
            case KeyEvent.VK_UP:
                myPanel.getSquare().setY(myPanel.getSquare().getY() - 10);
                break;
            case KeyEvent.VK_DOWN:
                myPanel.getSquare().setY(myPanel.getSquare().getY() + 10);
                break;
            case KeyEvent.VK_1:
                myPanel.setColorSet(0); // BLUE
                break;
            case KeyEvent.VK_2:
                myPanel.setColorSet(1); // ORANGE
                break;
            case KeyEvent.VK_3:
                myPanel.setColorSet(2); // RED
                break;
            case KeyEvent.VK_4:
                myPanel.setSizeSet(0);  // a = 40
                break;
            case KeyEvent.VK_5:
                myPanel.setSizeSet(1);  // a = 20
                break;
            case KeyEvent.VK_6:
                myPanel.setSizeSet(2);  // a = 80
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

}

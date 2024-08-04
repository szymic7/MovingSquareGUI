import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyPanel extends JPanel {

    private Square square = null;
    private int colorSet = 0, sizeSet = 0;   // default value = BLUE
    private BufferedImage bufferedImage;
    public static final Color color = new Color(157, 156, 145);
    public static final LineBorder border = new LineBorder(Color.BLACK, 5, true);


    public MyPanel() {
        this.generateMyPanel();
    }


    public void generateMyPanel() {
        this.setBackground(color);
        this.setBorder(border);
        this.setSize(new Dimension(800, 600));
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(null);
        this.setFocusable(false);

        square = new Square();

        // BufferedImage (double-buffering)
        bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);

    }

    public Square getSquare() {
        return this.square;
    }

    public void setSquare(Square newSquare) {
        this.square = newSquare;
    }

    public void setColorSet(int colorSet) {
        this.colorSet = colorSet;
    }

    public void setSizeSet(int sizeSet) {
        this.sizeSet = sizeSet;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        try {
            drawBuffer();
            g2d.drawImage(bufferedImage, 0, 0, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawBuffer() {
        Graphics2D g2dBuffer = (Graphics2D) bufferedImage.getGraphics();

        try {
            g2dBuffer.setColor(this.getBackground());
            g2dBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());

            switch (colorSet) {
                case 0:
                    g2dBuffer.setColor(Color.BLUE);
                    break;
                case 1:
                    g2dBuffer.setColor(Color.ORANGE);
                    break;
                case 2:
                    g2dBuffer.setColor(Color.RED);
                    break;
                default:
                    g2dBuffer.setColor(Color.BLUE);
                    break;
            }

            int sideLength;
            switch (sizeSet) {
                case 0:
                    sideLength = 40;
                    break;
                case 1:
                    sideLength = 20;
                    break;
                case 2:
                    sideLength = 80;
                    break;
                default:
                    sideLength = 40;
                    break;
            }
            square.setA(sideLength);

            g2dBuffer.fillRect(getSquare().getX(), getSquare().getY(), getSquare().getA(), getSquare().getA());
            g2dBuffer.setColor(Color.BLACK);
            g2dBuffer.setStroke(new BasicStroke(2));
            g2dBuffer.drawRect(getSquare().getX(), getSquare().getY(), getSquare().getA(), getSquare().getA());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            g2dBuffer.dispose();
        }

    }


}

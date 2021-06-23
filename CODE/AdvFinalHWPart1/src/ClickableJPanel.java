import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//@AUTHOR: GORKEM TOPRAK
//DATE: February 2, 2021 Wednesday

// THIS IS THE SECOND OPTION FOR THE LAST PART OF THE IMAGE PROCESSING HOMEWORK
public class ClickableJPanel extends Component implements MouseListener {

    public JPanel [][]sub=new JPanel[10][10];
    public JPanel screen = new JPanel();
    public JFrame f = new JFrame("Clickable Panel (TAB 6) Second Option");
    public static int positionx1;
    public static int positiony1;
    public static int x1 = 1;
    public static int y1 = 1;

    public ClickableJPanel()
    {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200, 1200);
        screen.setBorder(BorderFactory.createLineBorder(Color.black));
        screen.setLayout(new GridLayout(10,10));

        for (int i=0; i<=9;i++) {
            for (int j=0; j<=9;j++) {
                sub[i][j]= new JPanel();
//                sub[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                screen.add(sub[i][j]);
                positionx1 = i;
                positiony1 = j;
                sub[i][j].addMouseListener(this);
                f.add(screen);
            }
        }
        f.pack();
        f.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        JPanel source = (JPanel) e.getSource();
        BufferedImage bufImage;
        if(e.getButton() == MouseEvent.BUTTON1) {
            x1=e.getX();
            y1=e.getY();
            source.setBackground(Color.black);
            source.setSize(300, 300);
            try {
                bufImage =  ImageIO.read(new File("circle.jpg"));
                JLabel picLabel = new JLabel (new ImageIcon(bufImage));
                source.add(picLabel);
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
            source.add(new drawClickablePanel());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}

class drawClickablePanel extends JPanel {

    Image image;

    public drawClickablePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        int x1 = ClickableJPanel.x1;
        int y1 = ClickableJPanel.y1;

        try {
            image =  ImageIO.read(new File("circle.jpg"));
            g.drawImage(image, x1, y1, image.getWidth(this), image.getHeight(this) , Color.darkGray, this);
            g.drawString("Coordinate at: " + "x1: "+ x1 + " " + "y1: " + y1, x1,y1);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
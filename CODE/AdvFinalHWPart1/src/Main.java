import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

//@AUTHOR: GORKEM TOPRAK
//DATE: January 22, 2021 Friday

public class Main {

    public static int position = 0;

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.print("Please enter a txt name:");
        String fileName= scan.nextLine();

        ReadFile readFile = new ReadFile();
        readFile.scanFile(fileName+".txt");

        int width = readFile.width;
        int height = readFile.height;

        System.out.println(width + " " + height);

        //THIS IS FOR ORIGINAL IMAGE (TAB 0)
        int[][][] pixelsForOriginal = readFile.pixels;
        //gx= vertical gy=horizontal

        //THIS IS FOR GRAYSCALE. BECAUSE ORIGINAL IMAGE IS COLORED IMAGE SO I HAVE TO CREATE GREYSCALE IMAGE..
        GrayScale greyScale = new GrayScale();
        greyScale.createGrayScale(width, height, pixelsForOriginal);
        int[][] pixelsForGrayScale = greyScale.pixels;

        //THIS IS FOR GX EDGE IMAGE (TAB 1)
        GxEdgeImage gxEdgeImage = new GxEdgeImage();
        gxEdgeImage.createGxImage(width,height,pixelsForGrayScale);
        int [][] gX = gxEdgeImage.gY;

        //THIS IS FOR GY EDGE IMAGE (TAB 2)
        GyEdgeImage gyEdgeImage = new GyEdgeImage();
        gyEdgeImage.createGyImage(width,height,pixelsForGrayScale);
        int [][] gY = gyEdgeImage.gX;

        //THIS IS FOR GX and GY EDGE IMAGE (TAB 3)
        GEdgeImage createGEdge = new GEdgeImage();
        createGEdge.createGImage(gX,gY,width,height);
        int [][] g = createGEdge.g;

        //THIS IS FOR HORIZONTAL EDGE IMAGE (TAB 4)
        HOGEdge hogEdge = new HOGEdge();
        hogEdge.createHOGImage(gX, gY, width, height);
        int[][] pixelsForHorizantal = hogEdge.hogEdge;

        //THIS IS THE LAST PART OF THE HOMEWORK..(TAB 5)
        // (I created an array of 2 named posX and posY for x and y coordinates.)
        final int[] posX = new int[2];
        final int[] posY = new int[2];

        SketchPanel clickableTab1 = new SketchPanel(width, height, pixelsForGrayScale);
        ClickableImage clickableImage = new ClickableImage();

        //THIS IS THE SECOND OPTION FOR THE LAST PART OF THE HOMEWORK..(TAB 5)
        ClickableJPanel clickableJPanel = new ClickableJPanel();

//        SketchPanel tab1 = new SketchPanel(width,height,pixelsForGrayScale);
        SketchPanel tab2 = new SketchPanel(width,height,gX);
        SketchPanel tab3 = new SketchPanel(width,height,gY);
        SketchPanel tab4 = new SketchPanel(width,height,g);
        HOGSketch tab5 = new HOGSketch(width, height, pixelsForHorizantal);
        SketchPanel tab6 = new SketchPanel(width, height, new int[width][height]);

        final JFrame frame = new JFrame("Gorkem Toprak Final HW");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));

        JTabbedPane tabbedpane = new JTabbedPane(JTabbedPane.TOP);
        tabbedpane.addTab("Original",clickableTab1);
        tabbedpane.addTab("Gx Edge",tab2);
        tabbedpane.addTab("Gy Edge",tab3);
        tabbedpane.addTab("G Edge",tab4);
        tabbedpane.addTab("HOG Edge",tab5);
        tabbedpane.addTab("Tab6", tab6);
        frame.getContentPane().add(tabbedpane);

        // Here I have created a clickable panel using a addmouselistener. Here I went completely according to the oracle document
        // An abstract adapter class for receiving mouse events. The methods in this class are empty.
        // This class exists as convenience for creating listener objects.
        // After defining the mouse adapter class, I used the two methods in it. Named mousePressed and mouseReleased
        clickableTab1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) { // Invoked when a mouse button has been pressed on a component.
                if (position < 2) {
                    // A method from the getX and getY mouse event class.
                    posX[position] = me.getX(); // It returns the horizontal x position of the event relative to the source component.
                    posY[position] = me.getY(); // It returns the vertical y position of the event relative to the source component.
                }
            }

            public void mouseReleased(MouseEvent me) { // Invoked when a mouse button has been released on a component.
                if (me.getX() < pixelsForOriginal.length && me.getY() < pixelsForOriginal[0].length) {
                    position++; // If I do not increase the position, it will remain at 0 and a black screen will remain on the panel.
                    // If the positions at x and y are taken, it takes the positions of those selected
                    // pixels in the original image and draws them to tab 6.
                    if (position == 2) {
                        int[][] tab6Pixels = clickableImage.createClickableTab(posX, posY, pixelsForGrayScale);
                        tabbedpane.removeTabAt(5);
                        tabbedpane.addTab("Tab6", new SketchPanel(tab6Pixels.length, tab6Pixels[0].length, tab6Pixels));
                    }
                }
            }
        });
    }
}
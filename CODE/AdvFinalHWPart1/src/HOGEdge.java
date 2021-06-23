import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class HOGEdge {

    public int max=0;
    public int[][] hogEdge;
//    public int[][] g;
//    public int threshold = 0;
//    public int sideHeight = 0;
//    public int sideWidth = 0;
//    public int countWidth = 0;
//    public int countHeight = 0;

    public void createHOGImage(int gXPixels[][], int gYPixels[][], int c, int b) {
//        hogEdge = new int[width][height];
//        g = new int[width][height];
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(new File("circle.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width =bi.getWidth();
        int height =bi.getHeight();
        int anzpixel= width*height;
        int[] histogram = new int[255];
        int[] iarray = new int[1];
        int i =0;

        //read pixel into histogram
        for (int x = 1; x < width; x++) {
            for (int y = 1; y < height; y++) {
                int valueBefore=bi.getRaster().getPixel(x, y,iarray)[0];
                histogram[valueBefore]++;
            }
        }

        int sum =0;
        float[] lut = new float[anzpixel];
        for ( i=0; i < 255; ++i )
        {
            sum += histogram[i];
            lut[i] = sum * 255 / anzpixel;
        }

        for (int x = 1; x < width; x++) {
            for (int y = 1; y < height; y++) {
                int valueBefore=bi.getRaster().getPixel(x, y,iarray)[0];
                int valueAfter= (int) lut[valueBefore];
                iarray[0]=valueAfter;
                bi.getRaster().setPixel(x, y, iarray);
            }
        }

//        sideHeight = height - 2;
//        sideWidth = width - 2;
//
//        for (int i = 0; i < width; i++){
//            i = i+8;
//            if((i + 7 <= sideWidth)){
//               countWidth++;
//            }
//            else if((i + 7 <= sideHeight)){
//                countHeight++;
//            }
//            else{
//                i = countHeight * countWidth;
//            }
//        }
//        GxEdgeImage gxEdgeImage = new GxEdgeImage();
//        gxEdgeImage.createGxImage(width,height,gXPixels);
//
//        for (int i=0; i<countWidth; i++){
//            for (int j=0; j<countHeight; j++){
//
//            }
//        }

//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                int gradientValue = (int) Math.toDegrees(Math.atan(-gYPixels[i][j] / (gXPixels[i][j]+1)));
//                if (gradientValue < max) {
//                    max = gradientValue;
//                }
//                hogEdge[i][j] = gradientValue;
//            }
//        }
//        threshold = max / 255;
//        for (int i = 1; i < width - 1; i++) {
//            for (int j = 1; j < height - 1; j++) {
//                g[i][j] = hogEdge[i][j] / (threshold + 1);
//
//            }
//        }
    }
}

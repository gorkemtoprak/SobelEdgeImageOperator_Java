//@AUTHOR: GORKEM TOPRAK
//DATE: January 22, 2021 Friday

public class GyEdgeImage {

    public int max = 0;
    public int[][] gYEdge;
    public int[][] gX;
    public int threshold = 0;

    public void createGyImage(int width, int height, int[][] pixel) {
        gYEdge = new int[width][height];
        gX= new int[width][height];
        for (int i = 0; i < width-1; i++) {
            for (int j = 0; j < height-1; j++) {
                if(i != 0 && j!= 0){
                    int index00 = pixel[i - 1][j - 1];
                    int index01 = pixel[i - 1][j];
                    int index02 = pixel[i - 1][j + 1];
                    int index10 = pixel[i][j - 1];
                    int index11 = pixel[i][j];
                    int index12 = pixel[i][j + 1];
                    int index20 = pixel[i + 1][j - 1];
                    int index21 = pixel[i + 1][j];
                    int index22 = pixel[i + 1][j + 1];

                    int calculationY = Math.abs(((-1 * index00) + (0 * index01) + (1 * index02)) + ((-2 * index10) + (0 * index11) + (2 * index12))
                            + ((-1 * index20) + (0 * index21) + (1 * index22)));

                    if(calculationY>max){
                        max = calculationY;
                    }
                    gYEdge[i][j] = calculationY;
                }
            }
        }
        threshold = max / 255;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                gX[i][j] = gYEdge[i][j] / threshold;

            }
        }
    }
}
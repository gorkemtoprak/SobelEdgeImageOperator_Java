//@AUTHOR: GORKEM TOPRAK
//DATE: January 22, 2021 Friday

public class GxEdgeImage {
    public int max = 0;
    public int[][] gXEdge;
    public int[][] gY;
    public int threshold = 0;

    public void createGxImage(int width, int height, int[][] pixel) {
        gXEdge = new int[width][height];
        gY= new int[width][height];
        for (int i = 0; i < width-1; i++) {
            for (int j = 0; j < height-1; j++) {
                if(i != 0 && j != 0){
                    int index00 = pixel[i - 1][j - 1];
                    int index01 = pixel[i - 1][j];
                    int index02 = pixel[i - 1][j + 1];
                    int index10 = pixel[i][j - 1];
                    int index11 = pixel[i][j];
                    int index12 = pixel[i][j + 1];
                    int index20 = pixel[i + 1][j - 1];
                    int index21 = pixel[i + 1][j];
                    int index22 = pixel[i + 1][j + 1];
                    
                    int calculationX = Math.abs(((-1 * index00) + (-2 * index01) + (-1 * index02)) + ((0 * index10) + (0 * index11) + (0 * index12))
                            + ((1 * index20) + (2 * index21) + (1 * index22)));

                    if(calculationX>max){
                        max = calculationX;
                    }
                    gXEdge[i][j] = calculationX;
                }
            }
        }
        threshold = max / 255;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                gY[i][j] = gXEdge[i][j] / threshold;

            }
        }
    }
}
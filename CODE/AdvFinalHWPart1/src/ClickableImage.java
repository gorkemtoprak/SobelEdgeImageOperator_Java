//@AUTHOR: GORKEM TOPRAK
//DATE: February 3, 2021 Wednesday

//THIS IS THE ACTUAL PART OF THE TAB5
public class ClickableImage {

    public static int[][] createClickableTab(int[] x, int[] y, int[][] pixelsForGrayScale) {

        int x1 = Math.min(x[0], x[1]);
        int y1 = Math.min(y[0], y[1]);
        int x2 = Math.max(x[0], x[1]);
        int y2 = Math.max(y[0], y[1]);

        int xLength = (x2 - x1);
        int yLength = (y2 - y1);

        int[][] originalImagePixels = new int[xLength * 2][yLength * 2];

        for (int i = x1, positionX = 0; i < x2; i++, positionX += 2) {
            for (int j = y1, positionY = 0; j < y2; j++, positionY += 2) {
                originalImagePixels[positionX][positionY] = pixelsForGrayScale[i][j];
                originalImagePixels[positionX + 1][positionY] = pixelsForGrayScale[i][j];
                originalImagePixels[positionX][positionY + 1] = pixelsForGrayScale[i][j];
                originalImagePixels[positionX + 1][positionY + 1] = pixelsForGrayScale[i][j];
            }
        }
        return originalImagePixels;
    }
}

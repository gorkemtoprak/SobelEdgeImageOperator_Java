public class GrayScale {

    public int[][] pixels = null;

    public void createGrayScale(int width, int height, int[][][] pixelsForRGB) {

        pixels = new int[width][height];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                pixels[col][row] = (int) ((0.2126 * pixelsForRGB[col][row][0]) + (0.7152 * pixelsForRGB[col][row][1]) + (0.0722 * pixelsForRGB[col][row][2]));
            }
        }

    }
}
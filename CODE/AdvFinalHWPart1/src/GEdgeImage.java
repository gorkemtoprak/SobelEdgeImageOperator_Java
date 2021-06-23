public class GEdgeImage {
    public int max=0;
    public int[][] gEdge;
    public int[][] g;
    public int threshold = 0;

    public void createGImage(int gXPixels[][], int gYPixels[][],int width,int height){
        gEdge = new int[width][height];
        g= new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int gradientValue = (int) Math.sqrt(Math.pow(gXPixels[i][j], 2) + Math.pow(gYPixels[i][j], 2));
                if(gradientValue>max){
                    max=gradientValue;
                }
                gEdge[i][j]=gradientValue;
            }
        }
        threshold =max/255;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                g[i][j]= gEdge[i][j]/ threshold;

            }
        }

    }
}
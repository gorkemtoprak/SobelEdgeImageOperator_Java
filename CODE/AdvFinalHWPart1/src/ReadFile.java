import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public int width;
    public int height;
    public int[][][] pixels=null;

    public void scanFile(String fileName){
        Scanner inFile=null;
        try {
            inFile = new Scanner(new File(fileName));
            int fileType = inFile.nextInt();
            width = inFile.nextInt();
            height = inFile.nextInt();
            inFile.nextInt();
            System.out.printf("type: %d, width: %d, height:%d\n",
                    fileType, width, height);
            pixels = new int[width][height][3];
            for(int col = 0; col < height; col++)
                for(int row = 0; row < width; row++) {
                    for(int rgb=0;rgb<3;rgb++) {
                        pixels [row][col][rgb] = inFile.nextInt();
                    }
                }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

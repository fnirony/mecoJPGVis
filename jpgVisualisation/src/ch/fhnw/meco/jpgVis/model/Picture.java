package ch.fhnw.meco.jpgVis.model;

import java.awt.image.BufferedImage;

/**
 * class to save pictures current state
 */
public class Picture {

    public final static int SIZE = 8;
    private static int[][] pixel = new int[SIZE][SIZE];          //height, width
    private static Pixel[][] pixels = new Pixel[SIZE][SIZE];

    public Picture(BufferedImage image) {
        int x, y, z, pixl;

        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[0].length; j++) {

                pixel[i][j] = image.getRGB(i, j);

                pixl = image.getRGB(i, j);
//                alpha = pixl & 0xff000000;
                x = (pixl >> 16) & 0xff;             // red component
                y = (pixl >> 8) & 0xff;              // green
                z = (pixl) & 0xff;                     // blue

                pixels[i][j] = new Pixel(x, y, z);

//                System.out.println(pixels[i][j].toString());
            }
        }

    }

    static public void setPPixel(Pixel p, int i, int j) {
        pixels[i][j] = p;
    }

    static public Pixel getPPixel(int i, int j) {
        return pixels[i][j];
    }

    static public void setPixel(int p, int x, int y) {
        pixel[x][y] = p;
    }

    static public int getPixel(int x, int y) {
        return pixel[x][y];
    }

}

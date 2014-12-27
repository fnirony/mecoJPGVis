package ch.fhnw.meco.jpgVis.jpegAlgorithmus;

import processing.core.PApplet;
import ch.fhnw.meco.jpgVis.model.Picture;

/**
 * Created by Fiona on 24.12.14.
 */
public class RGB {
    PApplet frame;

    public RGB(PApplet frame) {
        this.frame = frame;
    }

    public void drawRGB() {
        int x, y, z, pixel, alpha;

        for (int i = 0; i < Picture.SIZE; i++) {
            for (int j = 0; j < Picture.SIZE; j++) {
                pixel = Picture.getPixel(i, j);
                alpha = pixel & 0xff000000;
                x = (pixel >> 16) & 0xff;               // red Komponente
                y = (pixel >> 8) & 0xff;                // green
                z = (pixel) & 0xff;                     // blue

                frame.stroke(x, y, z);

//                x = (int) PApplet.map(x, 0, 255, 0, 400);
//                y = (int) PApplet.map(y, 0, 255, 0, 400);
//                z = (int) PApplet.map(z, 0, 255, 0, 400);
                System.out.println("x: " + x + " y: " + y + " z: " + z);
//                frame.translate(frame.map(x, 0, 255, 0, 400), frame.map(y, 0, 255, 0, 400), frame.map(z, 0, 255, 0, 400));
                frame.pushMatrix();
//                frame.translate(x, y, z);
                frame.translate(x, y, z);
                frame.rectMode(PApplet.CENTER);
                frame.rect(0, 0, 10, 10);
                frame.popMatrix();
            }
        }
    }

//    image = ImageIO.read(new File("cowandchicken.png"));
//
//    int w = image.getWidth();
//    int h = image.getHeight();
//    r = new BufferedImage(w, h, TYPE);
//    g = new BufferedImage(w, h, TYPE);
//    b = new BufferedImage(w, h, TYPE);
//    // Create R, G, B planes
//    for (int i = 0; i < h; i++)
//            for (int j = 0; j < w; j++) {
//        int pixel = image.getRGB(i, j);
//        int alpha = pixel & 0xff000000;
//        int r1 = (pixel >> 16) & 0xff;
//        int g1 = (pixel >> 8) & 0xff;
//        int b1 = (pixel) & 0xff;
//        r.setRGB(i, j, alpha | (r1 << 16));
//        g.setRGB(i, j, alpha | (g1 << 8));
//        b.setRGB(i, j, alpha | b1);
//    }
//    // write three color planes
//    String f = "png";
//    ImageIO.write(r, f, new File("cowandchicken1.png"));
//    ImageIO.write(g, f, new File("g1.png"));
//    ImageIO.write(b, f, new File("b1.png"));
}

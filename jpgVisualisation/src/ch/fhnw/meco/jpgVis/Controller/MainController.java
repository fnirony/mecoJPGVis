package ch.fhnw.meco.jpgVis.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ch.fhnw.meco.jpgVis.Frame.Frame;
import ch.fhnw.meco.jpgVis.jpegAlgorithmus.YCrCb;
import ch.fhnw.meco.jpgVis.model.Picture;
import processing.core.PApplet;

public class MainController extends PApplet {
	Frame ui;

	public void setup() {
		try {
			BufferedImage img = ImageIO.read(new File("data/custom.jpg"));
			// for r,g,b coordinates are: x = red, y = green, z = blue
			Picture pic = new Picture(img);
		} catch (IOException e) {
			System.out.println("fehler beim Bild");
			e.printStackTrace();
		}

		size(400, 400, P3D);
        colorMode(RGB);
		background(255, 255, 255);
//        camera(width/2, height/2, (height/2) / tan(PI/6), width/2, height/2, 0, 0, 1, 0);

		ui = new Frame();

//        drawRGB();
		drawYCrCb();
//        test();
    }

	public void drawRGB() {
		ui.drawRGB(this);
	}

	public void drawYCrCb() {
		YCrCb ycrcb = new YCrCb();
		ycrcb.convertToYCrCb();
		ui.drawYCrCb(this);
	}

	public void test() {
		int z = 200;

		stroke(0, 0, 0);
		pushMatrix();
		translate(400, 400, z);
		rectMode(PApplet.CENTER);
		rect(0, 0, 10, 10);
		popMatrix();

		pushMatrix();
		translate(300, 300, z);
		rectMode(PApplet.CENTER);
		rect(0, 0, 10, 10);
		popMatrix();

		pushMatrix();
		translate(200, 200, z);
		rectMode(PApplet.CENTER);
		rect(0, 0, 10, 10);
		popMatrix();

		pushMatrix();
		translate(100, 100, z);
		rectMode(PApplet.CENTER);
		rect(0, 0, 10, 10);
		popMatrix();

		pushMatrix();
		translate(0, 0, 0);
		rectMode(PApplet.CENTER);
		rect(0, 0, 10, 10);
		popMatrix();
//    	resetMatrix();
    }

}

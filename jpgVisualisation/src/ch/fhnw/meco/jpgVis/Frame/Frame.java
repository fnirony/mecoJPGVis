package ch.fhnw.meco.jpgVis.Frame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import processing.core.PApplet;
import ch.fhnw.meco.jpgVis.jpegAlgorithmus.RGB;
import ch.fhnw.meco.jpgVis.model.Picture;

public class Frame {

	public void draw(PApplet parent) {
		int x, y, z;
		for (int i = 0; i < Picture.SIZE; i++) {
			for (int j = 0; j < Picture.SIZE; j++) {
				x = Picture.getPPixel(i, j).getX();
				y = Picture.getPPixel(i, j).getY();
				z = Picture.getPPixel(i, j).getZ();

				parent.stroke(x, y, z);
				parent.pushMatrix();
				//rgb
				x = (int) PApplet.map(x, 0, 255, 0, 330);
				y = (int) PApplet.map(y, 0, 255, 0, 330);
				z = (int) PApplet.map(z, 0, 255, -150, 100);
				//ycrcb
//            	x = (int)PApplet.map(x, 0, 255, 50, 350);
//            	y = (int)PApplet.map(y, 0, 255, 50, 350);
//            	z = (int)PApplet.map(z, 0, 255, -50, 200);
				System.out.println(" x: " + x + " y: " + y + " z: " + z);
				parent.translate(x, y, z);
				parent.rectMode(PApplet.CENTER);
				parent.rect(0, 0, 10, 10);
				parent.popMatrix();
			}
		}
	}

}

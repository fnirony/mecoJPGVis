package ch.fhnw.meco.jpgVis.Frame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import processing.core.PApplet;
import processing.core.PConstants;
import ch.fhnw.meco.jpgVis.jpegAlgorithmus.RGB;
import ch.fhnw.meco.jpgVis.model.Picture;

public class Frame {

	public void drawRGB(PApplet p3dspace) {
		int x, y, z;
		for (int i = 0; i < Picture.SIZE; i++) {
			for (int j = 0; j < Picture.SIZE; j++) {
				x = Picture.getPPixel(i, j).getX();                    // get actual stored Koordinates
				y = Picture.getPPixel(i, j).getY();
				z = Picture.getPPixel(i, j).getZ();

				p3dspace.stroke(x, y, z);                            // set rectangle color

				x = (int) PApplet.map(x, 0, 255, 0, 330);            // map value of range from 0,255 to 0,330
				y = (int) PApplet.map(y, 0, 255, 0, 330);
				z = (int) PApplet.map(z, 0, 255, -150, 100);

				p3dspace.pushMatrix();                                // push current matrix (identity matrix) to stack
				p3dspace.translate(x, y, z);                        // translate matrix
				p3dspace.rectMode(PApplet.CENTER);                    // draw rectangle in new coordinate system
				p3dspace.rect(0, 0, 10, 10);
				p3dspace.popMatrix();                                // pop identity matrix from stack again. Damit man immer wieder von Identity matrix her transliert und nicht von der schon translierten.
			}
		}
	}

	public void drawYCrCb(PApplet p3dspace) {
		int x, y, z;
		for (int i = 0; i < Picture.SIZE; i++) {
			for (int j = 0; j < Picture.SIZE; j++) {
				x = Picture.getPPixel(i, j).getX();
				y = Picture.getPPixel(i, j).getY();
				z = Picture.getPPixel(i, j).getZ();

				p3dspace.stroke(x, y, z);

				x = (int) PApplet.map(x, 0, 255, 50, 350);
				y = (int) PApplet.map(y, 0, 255, 50, 350);
				z = (int) PApplet.map(z, 0, 255, -50, 200);

				p3dspace.pushMatrix();
				p3dspace.translate(x, y, z);
				p3dspace.rotateX(PConstants.PI / 2);
				p3dspace.rectMode(PApplet.CENTER);
				p3dspace.rect(0, 0, 10, 10);
				p3dspace.popMatrix();
			}
		}
	}

}

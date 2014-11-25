package jpegAlgorithmus;

import javax.imageio.ImageIO;

import java.io.*;
import java.applet.Applet;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.awt.Graphics;

public class YCbCr extends Applet {
	
	 
	private Image I1, I2;
	private int w, h;
	int[] A;
	float Y, Cb, Cr, r1, g1, b1;
	int i = 0, r2, g2, b2;
	public void init() {
		try {
			try {	
				I1 = ImageIO.read(new File("NHKZeNp.jpg"));
			} catch (IOException ex) {
			}
			PixelGrabber grabber = new PixelGrabber(I1, 0, 0, -1, -1, true);
			if (grabber.grabPixels()) {
				w = grabber.getWidth();
				h = grabber.getHeight();
				int p[] = new int[w * h];
				A = (int[]) grabber.getPixels();
				for (i = 0; i < A.length; i++) {
					int c = A[i];
					int r = (c & 0xff0000) >> 16;
					int g = (c & 0x00ff00) >> 8;
					int b = (c & 0x0000ff);
					// Conversion from integer to float
					Y = (float) (0.299 * r + 0.587 * g + 0.114 * b);
					Cb = (float) (-0.169 * r - 0.331 * g + 0.500 * b);
					Cr = (float) (0.500 * r - 0.419 * g - 0.081 * b);
					r1 = (float) (Y + 1.140 * Cr);
					g1 = (float) (Y - 0.344 * Cb - 0.714 * Cr);
					b1 = (float) (Y + 1.773 * Cb);
					// Conversion from float to integer
					r2 = Math.round(r1);
					g2 = Math.round(g1);
					b2 = Math.round(b1);
					p[i] = ((255 << 24) | ((r2 & 0xff) << 16)
							| ((g2 & 0xff) << 8) | (b2 & 0xff));
				}
				I2 = createImage(new MemoryImageSource(w, h, p, 0, w));
			}
		} catch (InterruptedException ie) {
		}
	}
	public void paint(Graphics g) {
		g.drawImage(I2, 0, 0, this);
	}
}
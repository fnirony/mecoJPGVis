package jpegAlgorithmus;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
public class RGB {
	static BufferedImage image;
	static BufferedImage r, g, b;
	static final int TYPE = BufferedImage.TYPE_INT_ARGB;
	public static void main(String[] args) throws Exception {
		// Read input image

		image = ImageIO.read(new File("cowandchicken.png"));

		int w = image.getWidth();
		int h = image.getHeight();
		r = new BufferedImage(w, h, TYPE);
		g = new BufferedImage(w, h, TYPE);
		b = new BufferedImage(w, h, TYPE);
		// Create R, G, B planes
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				int pixel = image.getRGB(i, j);
				int alpha = pixel & 0xff000000;
				int r1 = (pixel >> 16) & 0xff;
				int g1 = (pixel >> 8) & 0xff;
				int b1 = (pixel) & 0xff;
				r.setRGB(i, j, alpha | (r1 << 16));
				g.setRGB(i, j, alpha | (g1 << 8));
				b.setRGB(i, j, alpha | b1);
			}
		// write three color planes
		String f = "png";
		ImageIO.write(r, f, new File("cowandchicken1.png"));
		ImageIO.write(g, f, new File("g1.png"));
		ImageIO.write(b, f, new File("b1.png"));
	}

}

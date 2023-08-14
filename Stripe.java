package algorithm.randomimage;

import java.awt.Color;
import java.awt.image.BufferedImage;

class HorizontalStripe extends RandImgGenerator {
	public HorizontalStripe(int diff) {
		super(Math.abs(diff));
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		image.setRGB(0, 0, color.getRGB());
		for (int i = 0; i < height; i++) {
			red += rand.nextInt(-diff, diff + 1);
			red = (red > 255) ? 255 : (red < 0) ? 0 : red;
			green += rand.nextInt(-diff, diff + 1);
			green = (green > 255) ? 255 : (green < 0) ? 0 : green;
			blue += rand.nextInt(-diff, diff + 1);
			blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
			color = new Color(red, green, blue);
			for (int j = 0; j < width; j++)
				image.setRGB(j, i, color.getRGB());
		}
		save(image, "horizontalstripe" + diff + ".png");
	}
}

class VerticalStripe extends RandImgGenerator {
	public VerticalStripe(int diff) {
		super(Math.abs(diff));
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		image.setRGB(0, 0, color.getRGB());
		for (int i = 0; i < width; i++) {
			red += rand.nextInt(-diff, diff + 1);
			red = (red > 255) ? 255 : (red < 0) ? 0 : red;
			green += rand.nextInt(-diff, diff + 1);
			green = (green > 255) ? 255 : (green < 0) ? 0 : green;
			blue += rand.nextInt(-diff, diff + 1);
			blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
			color = new Color(red, green, blue);
			for (int j = 0; j < height; j++)
				image.setRGB(i, j, color.getRGB());
		}
		save(image, "verticalstripe" + diff + ".png");
	}
}

class DiagonalStripe extends RandImgGenerator {
	public DiagonalStripe(int diff) {
		super(Math.abs(diff));
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		image.setRGB(0, 0, color.getRGB());
		for (int i = 1; i < width + height; i++) {
			red += rand.nextInt(-diff, diff + 1);
			red = (red > 255) ? 255 : (red < 0) ? 0 : red;
			green += rand.nextInt(-diff, diff + 1);
			green = (green > 255) ? 255 : (green < 0) ? 0 : green;
			blue += rand.nextInt(-diff, diff + 1);
			blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
			color = new Color(red, green, blue);
			for (int j = 0; j < height; j++) {
				if (i - j < width && i - j >= 0)
					image.setRGB(i - j, j, color.getRGB());
			}
		}
		save(image, "diagonalstripe" + diff + ".png");
	}
}

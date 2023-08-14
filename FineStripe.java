package algorithm.randomimage;

import java.awt.Color;
import java.awt.image.BufferedImage;

class FineHorizontalStripe extends RandImgGenerator {
	public FineHorizontalStripe(int diff) {
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
			for (int j = 0; j < width; j++) {
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				image.setRGB(j, i, color.getRGB());
			}
		}
		save(image, "finehorizontalstripe" + diff + ".png");
	}
}

class FineVerticalStripe extends RandImgGenerator {
	public FineVerticalStripe(int diff) {
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
			for (int j = 0; j < height; j++) {
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				image.setRGB(i, j, color.getRGB());
			}
		}
		save(image, "fineverticalstripe" + diff + ".png");
	}
}

class FineDiagonalStripe extends RandImgGenerator {
	public FineDiagonalStripe(int diff) {
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
			for (int j = 0; j < height; j++) {
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				if (i - j < width && i - j >= 0) {
					image.setRGB(i - j, j, color.getRGB());
				}
			}
		}
		save(image, "finediagonalstripe" + diff + ".png");
	}
}
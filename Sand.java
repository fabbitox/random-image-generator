package algorithm.randomimage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import javax.imageio.ImageIO;

public class Sand {
	public static void main(String[] args) throws Exception {
		Random random = new Random();
		int width = 1280, height = 720, ac = width;
		Color[] colors = {
				new Color(255, 255, 255),
				new Color(249, 232, 255),
				new Color(191, 207, 255),
				new Color(207, 191, 255),
				new Color(239, 191, 255),
		};
		int colorCount = colors.length;
//		int colorCount = 8;
//		Color[] colors = new Color[colorCount];
//		for (int i = 0; i < colorCount; i++) {
//			colors[i] = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
//		}
		int[] hs = new int[width], avails = new int[width], state[] = new int[width][height];
		for (int i = 0; i < width; i++) {
			avails[i] = i;
		}
		while (ac > 0) {
			int ci = random.nextInt(colorCount), count = random.nextInt(height / 20) + 1, s = random.nextInt(ac);
			while (count-- > 0 && ac > 0) {
				int l = random.nextInt(width / 24), r = random.nextInt(width / 24) + 1;
				for (int j = 0; j < l && ac > 0; j++) {
					int k = (s - j + width) % ac, k2 = avails[k];
					while (hs[k2] == height && ac > 0) {
						k2 = avails[k] = avails[--ac];
					}
					if (ac > 0) {
						state[k2][hs[k2]++] = ci;
					}
				}
				for (int j = 1; j < r && ac > 0; j++) {
					int k = (s + j) % ac, k2 = avails[k];
					while (hs[k2] == height && ac > 0) {
						k2 = avails[k] = avails[--ac];
					}
					if (hs[k2] < height) {
						state[k2][hs[k2]++] = ci;
					}
				}
			}
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				image.setRGB(i, j, colors[state[i][height - 1 - j]].getRGB());
			}
		}
		ImageIO.write(image, "png", new File("sand.png"));
	}
}

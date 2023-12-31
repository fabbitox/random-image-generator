package algorithm.randomimage;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Bomb extends RandImgGenerator {
	private double probability;
	private int divide;
	
	public Bomb(int diff, double probability, int divide) {
		super(Math.abs(diff));
		this.probability = Math.abs(probability);
		this.divide = divide;
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		LinkedList<int[]> q = new LinkedList<>();
		boolean[][] painted = new boolean[width][height];
		int count = width * height / divide;
		for (int j = 0; j < count; j++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			image.setRGB(x, y, color.getRGB());
			painted[x][y] = true;
			q.offer(new int[] { x, y });
			while (!q.isEmpty()) {
				int[] pos = q.poll();
				int px = pos[0];
				int py = pos[1];
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				int[] nexts = new int[] { px - 1, py, px, py - 1, px, py + 1, px + 1, py };
				for (int i = 0; i < 4; i++) {
					int nx = nexts[i * 2];
					int ny = nexts[i * 2 + 1];
					if (nx >= 0 && nx < width && ny >= 0 && ny < height && !painted[nx][ny]) {
						image.setRGB(nx, ny, color.getRGB());
						painted[nx][ny] = true;
						if (rand.nextDouble() < probability)
							q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		save(image, "bomb_" + diff + "_" + (int) (probability * 100) + "_" + divide + ".png");
	}
}

class Bomb2 extends RandImgGenerator {
	private double[] probability = new double[4];
	private int divide;
	
	public Bomb2(int diff, double[] probability, int divide) {
		super(Math.abs(diff));
		for (int i = 0; i < 4; i++)
			this.probability[i] = Math.abs(probability[i]);
		this.divide = divide;
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		LinkedList<int[]> q = new LinkedList<>();
		boolean[][] painted = new boolean[width][height];
		int count = width * height / divide;
		for (int j = 0; j < count; j++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			image.setRGB(x, y, color.getRGB());
			painted[x][y] = true;
			q.offer(new int[] { x, y });
			while (!q.isEmpty()) {
				int[] pos = q.poll();
				int px = pos[0];
				int py = pos[1];
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				int[] nexts = new int[] { px - 1, py, px, py - 1, px, py + 1, px + 1, py };
				for (int i = 0; i < 4; i++) {
					int nx = nexts[i * 2];
					int ny = nexts[i * 2 + 1];
					if (nx >= 0 && nx < width && ny >= 0 && ny < height && !painted[nx][ny]) {
						image.setRGB(nx, ny, color.getRGB());
						painted[nx][ny] = true;
						if (rand.nextDouble() < probability[i])
							q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		save(image, "bomb2_" + diff + "_" + Arrays.toString(probability) + "_" + divide + ".png");
	}
}

class Bomb3 extends RandImgGenerator {
	private double[] probability = new double[2];
	private int divide;
	
	public Bomb3(int diff, double[] probability, int divide) {
		super(Math.abs(diff));
		for (int i = 0; i < 2; i++)
			this.probability[i] = Math.abs(probability[i]);
		this.divide = divide;
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		LinkedList<int[]> q = new LinkedList<>();
		boolean[][] painted = new boolean[width][height];
		int count = width * height / divide;
		for (int j = 0; j < count; j++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			image.setRGB(x, y, color.getRGB());
			painted[x][y] = true;
			q.offer(new int[] { x, y });
			while (!q.isEmpty()) {
				int[] pos = q.poll();
				int px = pos[0];
				int py = pos[1];
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				int[] nexts = new int[] { px - 1, py, px, py - 1, px, py + 1, px + 1, py, px - 1, py - 1, px - 1, py + 1, px + 1 , py - 1, px + 1, py + 1 };
				for (int i = 0; i < 8; i++) {
					int nx = nexts[i * 2];
					int ny = nexts[i * 2 + 1];
					if (nx >= 0 && nx < width && ny >= 0 && ny < height && !painted[nx][ny]) {
						image.setRGB(nx, ny, color.getRGB());
						if (i < 4)
							if (rand.nextDouble() < probability[0]) {
								painted[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
						else if (i < 8)
							if (rand.nextDouble() < probability[1]) {
								painted[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
					}
				}
			}
		}
		save(image, "bomb3_" + diff + "_" + Arrays.toString(probability) + "_" + divide + ".png");
	}
}

class Bomb4 extends RandImgGenerator {
	private double[] probability = new double[8];
	private int divide;
	
	public Bomb4(int diff, double[] probability, int divide) {
		super(Math.abs(diff));
		for (int i = 0; i < 8; i++)
			this.probability[i] = Math.abs(probability[i]);
		this.divide = divide;
	}
	
	@Override
	public void make() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color color = new Color(red, green, blue);
		LinkedList<int[]> q = new LinkedList<>();
		boolean[][] painted = new boolean[width][height];
		int count = width * height / divide;
		for (int j = 0; j < count; j++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			image.setRGB(x, y, color.getRGB());
			painted[x][y] = true;
			q.offer(new int[] { x, y });
			while (!q.isEmpty()) {
				int[] pos = q.poll();
				int px = pos[0];
				int py = pos[1];
				red += rand.nextInt(-diff, diff + 1);
				red = (red > 255) ? 255 : (red < 0) ? 0 : red;
				green += rand.nextInt(-diff, diff + 1);
				green = (green > 255) ? 255 : (green < 0) ? 0 : green;
				blue += rand.nextInt(-diff, diff + 1);
				blue = (blue > 255) ? 255 : (blue < 0) ? 0 : blue;
				color = new Color(red, green, blue);
				int[] nexts = new int[] { px - 1, py, px, py - 1, px, py + 1, px + 1, py, px - 1, py - 1, px - 1, py + 1, px + 1 , py - 1, px + 1, py + 1 };
				for (int i = 0; i < 4; i++) {
					int nx = nexts[i * 2];
					int ny = nexts[i * 2 + 1];
					if (nx >= 0 && nx < width && ny >= 0 && ny < height && !painted[nx][ny]) {
						image.setRGB(nx, ny, color.getRGB());
						painted[nx][ny] = true;
						if (rand.nextDouble() < probability[i])
							q.offer(new int[] { nx, ny });
					}
				}
			}
		}
		save(image, "bomb4_" + diff + "_" + Arrays.toString(probability) + "_" + divide + ".png");
	}
}

package algorithm.randomimage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class RandImgGenerator {
	protected int diff;
	protected Random rand = new Random();
	protected int width = rand.nextInt(100, 501);
	protected int height = rand.nextInt(100, 501);
	
	public RandImgGenerator(int diff) {
		this.diff = diff;
	}
	
	public abstract void make();
	
	protected static void save(BufferedImage image, String filename) {
		try {
			ImageIO.write(image, "png", new File(filename));// project directory
//			ImageIO.write(image, "png", new File("path you want\\" + filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new HorizontalStripe(10).make();// max color difference of adjacent pixel(red, green and blue)
		new FineHorizontalStripe(10).make();
		new VerticalStripe(10).make();
		new FineVerticalStripe(10).make();
		new DiagonalStripe(10).make();
		new FineDiagonalStripe(10).make();
		new Bomb(10, 0.6, 500).make();// probability of progress to adjacent pixel, bomb count: width * height / divide
		new Bomb2(10, new double[] {0.7, 0.5, 0.55, 0.6}, 400).make();
		new Bomb3(10, new double[] {0.4, 0.1}, 100).make();
		new Bomb4(10, new double[] {0.57, 0.64, 0.54, 0.48, 0.51, 0.6, 0.52, 0.56}, 100).make();
	}
}

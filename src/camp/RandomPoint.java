package camp;
import java.util.Random;


public class RandomPoint {
	private double x, y, r; //location, plus r for Random value 
	Random rand = new Random();
	
	//predicts (x,y) according to the given point and deviation
	public RandomPoint(double commonX, double commonY, int deviation ) {
		r = rand.nextGaussian();
		x = commonX + r * deviation;
		r = rand.nextGaussian();
		y = commonY + r * deviation;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return String.format("(%.2f , %.2f)",x,y); 
	}

}

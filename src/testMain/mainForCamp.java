package testMain;
import java.util.Random;

public class mainForCamp {

	public static void main(String[] args) {
		double commonX, commonY;
		int commonDeviation=100, singleDeviation=50;
		double campCenterX = 0, campCenterY = 0;
		double r;
		Random randomno = new Random();
		
		r = randomno.nextGaussian();
		commonX = campCenterX + r*100;
		System.out.println(commonX);
	}

}



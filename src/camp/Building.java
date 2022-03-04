package camp;

public class Building {
	private double minX, maxX, minY, maxY; //combined, gives a building territory
	private double width, height;
	protected boolean hit;    //status after attack
	
	//calculate and set Building territory
	public Building(double x, double y, double width, double height) {
		this.width=width;
		this.height = height;
		minX = x - width/2;
		maxX = x + width/2;
		minY = y - height/2;
		maxY = y + height/2;
		hit=false;
	}
	
	//if (x,y) is within the building territory change the status to "hit"
	public void checkHit(double x, double y) {
		if ( (x >= minX && x<=maxX) && (y>=minY && y<=maxY) )
			hit=true;
	}
	
	//changes the building hit status to "false" 
	public void repair() {
		hit=false;
	}
	
	@Override
	public String toString() {
		return minX + "<X<"  + maxX + " --- " + minY + "<Y<" + maxY ;
	}
}

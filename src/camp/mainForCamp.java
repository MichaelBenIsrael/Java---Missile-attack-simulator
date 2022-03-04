package camp;
import java.util.Arrays;

public class mainForCamp {
	
	public static void main(String[] args) {
		//set the attack's parameters
		int numMissiles = 300000;  
		int numBuildings = 3;
		int t_numAttacks=100;
		double campCenterX = 0, campCenterY = 0;         //set Camp Center location
		
		int p_Deviation = 100, m_Deviation= 50, index=0; //set deviations, plus index for result[]
		double count= 0, numAttacks=t_numAttacks;
		int accuracy=5;   // Repetition 
		
		double[] result= new double[accuracy]; //contains the Success rate of 5 scenarios 
		RandomPoint sharedPoint;   							      
		RandomPoint[] missiles = new RandomPoint[numMissiles]; 
		Building[] targetsArr = new Building[numBuildings]; 
		
		targetsArr[0]=new Building(-50, 40, 20, 30); //calculate and save Buildings territories   
		targetsArr[1]=new Building(50, 0, 20, 30);
		targetsArr[2]=new Building(0, -30, 20, 30);
		 
		while(accuracy-- != 0) //Repeat the process 5 times- increase the accuracy of the hit percentage 
		{
			while(numAttacks-- != 0)   //run multiply scenarios of the given attack parameters
			{
				boolean success=true;
				sharedPoint = new RandomPoint(campCenterX, campCenterY, p_Deviation); //get Shared Hit Point prediction
				RandomPoint shp = sharedPoint;
				//Attack start
				for(RandomPoint m: missiles)  
				{
					m= new RandomPoint(shp.getX(), shp.getY(), m_Deviation);//predict missile hit location
					for(Building b: targetsArr)
						b.checkHit (m.getX(), m.getY() ); //check if any of the targets has been hit 
				} 
				//Attack end
				for(Building b: targetsArr) //damage report
				{
					if( b.hit == false)
						success=false;
					else b.repair();      //nullify damage
				}
				if(success)	   //if all the targets has been hit, up count
					count++;       
			}  
			result[index++]=(int)((count/t_numAttacks)*100); 
			count=0; numAttacks=t_numAttacks;  //set parameters for next iteration
	   }
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.stream(result).average().orElse(Double.NaN) + "%");
	}
}

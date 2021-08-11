package learnTestNG;

import org.testng.annotations.Test;

public class LearnTestNG {
	
	  @Test(priority = -2) 
	  public void Gadi() 
	  { System.out.println("Oranges");
	  
	  }
	  
	  @Test(priority = 1) 
	  public void Vehicle() 
	  { System.out.println("Apples"); }
	  
	  @Test(priority = 0) public void Bike() 
	  { System.out.println("Mango");
	  
	  
	  }
	 @Test(invocationCount = 1)
	 public void train() {
		 System.out.println("Cheran Express");
	 }

	 @Test(groups ="Sanity") 
	  public void Lorry() {
	  System.out.println("WaterMelon"); 
	  } 
	  
	  @Test(description = "Print Grapes")
	  public void Bus() 
	  {
	  System.out.println("Grapes"); 
	  } 
	 


}

package learnJava;

import java.util.ArrayList;
import java.util.List;

public class LearnListVsSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create List    
	    List<String> names = new ArrayList<String>();    
	    //Adding elements in the List. 
	    names.add("Emma");    
	    names.add("Emma");    
	    names.add("Aria");    
	    names.add("Ally");
	    names.add("Murali");
	    
	    //Performing iteration of list to print each element of it. 
	    
	    //System.out.println(names);
	    for(String name: names) {    
	        System.out.println(name);    
	    }
	}
}
	

	



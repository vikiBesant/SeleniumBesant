package learnJava;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class LearnSet {

	@Test
	public void main() {
		  // creating HashSet implementation using the Set    
        Set<String> veg = new TreeSet<String>();     
      
        veg.add("Ginger");     
        veg.add("Garlic");     
        veg.add("Onion");     
        veg.add("Ginger");
        veg.add("Apple");
        
        for (String lq : veg) {
        	 System.out.println(lq);
        	
			
		}
      
            
    }     

	}



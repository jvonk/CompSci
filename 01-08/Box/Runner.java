//Challenge: What does this do?
// imports the package Box
import Box.*;


public class Runner{
	public static void main (String args[]){
		
		ShippingBox obj = new ShippingBox();
		obj.printInfo();
				
		System.out.println("\nRunning inside Runner: ");
		
		
		StandardBox obj2 = new StandardBox();
		
		//Uncomment the code and answer. 
		
		//(1) Does it print? why?
		// yes it is public
		System.out.println( obj2.companyName );
		
		//(2) Does it print? why?
		// no it is private
		// System.out.println( obj2.password );
		
		//(3) Does it print? why?
		// no because it is protected
		// System.out.println( obj2.address );
		
		
		
	}
}

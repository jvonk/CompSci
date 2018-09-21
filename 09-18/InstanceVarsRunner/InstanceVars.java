public class InstanceVars{
    //Below are instance variables / fields
    //and they exist throughout the class
    private int one = 8, two = 3; 
    private int answer; 
 
 
    //(1) What does this method do?
	//It sets answer to 8+3 which is 11
    public void add(){
        answer = one + two;
        int three = 33;
    }
 
    //(2) What does this method do?
	//It prints answer
    public void print(){
        //(3) Can you print answer?
		//yes
        System.out.println(answer);
 
        //(4) If you uncomment the code below, will it run? why?
		//no because three is a variable of the add method not the entire class
        //System.out.println(three);
    }
 
}
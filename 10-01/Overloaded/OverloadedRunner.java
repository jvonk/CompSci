public class OverloadedRunner{
    public static void main(String[] args){
        //(1) What is the difference between the two constructors?
        //The first one constructs one that is blank and the other has an age and name
        Overloaded p1 = new Overloaded();
        Overloaded p2 = new Overloaded(16, "John");
         
        //(2) What is the difference between the outputs of p1 and p2? why?
        //p1 puts blank and 0 while p2 outputs John and 16 because p1 uses the default constructor and p2 has actual values passed in
        p1.print();
        p2.print();
        System.out.println();
         
        //(3) What is the difference between the outputs of p1 and p2? why?
        //The name is still different because print does not take in a name in this case
        p1.print(5);
        p2.print(5);
        System.out.println();
         
        //(4) What is the difference between the outputs of p1.print(5) and 
        //    p1.print("Henry")? why?
        //They are different because the first one calls with an age and the second with a name so the name is only set is the second and the age is only set in the first
        p1.print(5);
        p1.print("Henry");
    }
}
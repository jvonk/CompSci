public class For{
    public void test1(){
        //1) Describe what is happening below?
        //counts from 0 to 9
        System.out.println("\n\nTest1");
        for(int i=0; i < 10; i++){
            System.out.println(i);
        }
    }
     
    public void test2(){
        //2) Describe what is happening below?
        //counts down from 15 to 3

        System.out.println("\n\nTest2");
        for(int i=15; i > 2; i--){
            System.out.println(i);
        }
    }
     
    public void test3(int max){
        //3) Describe what is happening below?
        //counts down from 0 to max by 5
        System.out.println("\n\nTest3");
        for(int i=0; i <= max; i+=5){
            System.out.println(i);
        }
    }
     
    public void test4(int min, int max){
        //4) Describe what is happening below?
        //counts down from max to min + 2 by 2
        System.out.println("\n\nTest4");
        for(int i=max; i > min; i-=2){
            System.out.println(i);
        }
         
    }
     
    //5)What makes a for loop more useful than a while loop?
 
}
/*
 * NestedLoops
 */
public class NestedLoops {
    public void drawFilledBox() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) 
                System.out.print("*"+((j==9)?"\n":"")+""+(((i==9)&&(j==9))?"\n":""));
    }

    public void drawFilledBox(int width, int height) {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) 
                System.out.print("*"+((j==width-1)?"\n":"")+""+(((i==height-1)&&(j==width-1))?"\n":""));
    }

    public void drawMultiChart() {
        for (int i = 1; i <= 9; i++)
            for (int j = 1; j <= 9; j++) 
                System.out.print((i*j)+"\t"+((j==9)?"\n":"")+""+(((i==9)&&(j==9))?"\n":""));
    }

    public void drawTriangle() {
        for (int i = 0; i <= 5; i++)
            for (int j = i; j <= 5; j++) 
                System.out.print("*"+((j==5)?"\n":""));
    }
}
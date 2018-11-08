/**
 * Runner
 */

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        NestedLoops n = new NestedLoops();
        Scanner kb = new Scanner(System.in);
        n.drawFilledBox();
        n.drawFilledBox(kb.nextInt(), kb.nextInt());
        n.drawMultiChart();
        n.drawTriangle();
        kb.close();
    }    
}
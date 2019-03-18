import java.awt.Point;
import java.util.*;
public class WarmUp {
    private int[][] numMatrix;
    public WarmUp(int[][] in) {
        numMatrix=in;
    }
    public void print() {
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                System.out.print(numMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void replaceLargest() {
        int max = Integer.MIN_VALUE;
        List<Point> ps = new ArrayList<>();
        for (int i = 0; i < numMatrix.length; i++) {
            for (int j = 0; j < numMatrix[i].length; j++) {
                if (numMatrix[i][j]>max) {
                    ps.clear();
                }
                if (numMatrix[i][j]>=max) {
                    ps.add(new Point(i, j));
                    max = numMatrix[i][j];
                }
            }
        }
        for(Point p : ps)
            numMatrix[(int)p.getX()][(int)p.getY()]=-1;
    }
}
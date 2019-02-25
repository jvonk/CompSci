import java.util.*;
public class Array2DDemo {
    public void print2DInt(int[][] in) {
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                System.out.print(in[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public void test1() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=(int)(Math.random()*10+1);
            }
        }
        print2DInt(arr);
    }
    public void test2() {
        int[][] arr = new int[7][7];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=i*j;
            }
        }
        print2DInt(arr);
    }
    public void test3() {
        int[][] arr = new int[3][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j]=(int)(Math.random()*9+1);
            }
        }
        print2DInt(arr);
        Scanner sc = new Scanner(System.in);
        System.out.print("number to search: ");
        int search = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j] == search ? 1 : 0;
            }
        }
        System.out.println(sum);
    }
    public void test4() {
        String[][] arr = new String[][] {
                {"dog", "cat", "rat"},
                {"mouse", "bird", "parrot"},
                {"fish", "salmon", "herring"}
        };
        Scanner sc = new Scanner(System.in);
        System.out.print("String to search: ");
        String search = sc.nextLine();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j].equals(search) ? 1 : 0;
            }
        }
        System.out.println(sum);
    }
}
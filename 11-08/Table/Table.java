public class Table {
    int row;
    int column;

    public Table (int a, int b) {
        row = a;
        column = b;
    }

    public void printDrawBox() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
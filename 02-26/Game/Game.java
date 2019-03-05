public class Game {
    int[][] array;
    int turn, win;
    public Game(){
        array = new int[3][3];
        turn = 1;
        win = 0;
    }
    public void printTable(){
        for (int i = 0; i < array.length; i++){
            for (int x = 0; x < array[i].length; x++){
                if (array[i][x] == 1){
                    System.out.print("X");
                }
                else if (array[i][x] == 2){
                    System.out.print("O");
                }else{
                    System.out.print(array[i][x]);
                }
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
    public void insertXO(int a, int b){
        if (array[a][b] == 0){
            if (turn == 1){
                array[a][b] = 1;
            }else if (turn == 2){
                array[a][b] = 2;
            }
        }
        if (checkFull()||checkTicTacToe()==1) {
            win=turn;
        }
        if (turn == 1){
            turn = 2;
        }else{
            turn = 1;
        }
    }
    public boolean checkFull(){
        int num = 0;
        for (int i = 0; i < array.length; i++){
            for (int x = 0; x < array[i].length; x++){
                if (array[i][x] == 0){
                    num++;
                }
            }
        }
        if (num == 0){
            return true;
        }else{
            return false;
        }
    }
    public int checkTicTacToe() {
        for (int i = 0; i < 3; i++) {
            if (array[i][0]==1&&array[i][1]==1&&array[i][2]==1) return 1;
            if (array[0][i]==1&&array[1][i]==1&&array[2][i]==1) return 1;
        }
        if (array[0][0]==1&&array[1][1]==1&&array[2][2]==1) return 1;
        if (array[2][0]==1&&array[1][1]==1&&array[0][2]==1) return 1;
        return 0;
    }
}

package LeetCode.array;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Num79 {
    public boolean exist(char[][] board, String word) {
        boolean flag = false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    //初始化一个mark数组，默认值为0，将i，j位置的值置为1
                    int[][] mark = new int[board.length][board[i].length];
                    mark[i][j] = 1;
                    flag = startDp(board, mark, word.substring(1), i, j);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public boolean startDp(char[][] board, int[][] mark, String word, int i, int j) {
        if (word.length() == 0) {
            return true;
        }
        boolean flag = false;
        if (i + 1 < board.length && mark[i + 1][j] == 0 && board[i + 1][j] == word.charAt(0)) {
            mark[i][j] = 1;
            flag = startDp(board, mark, word.substring(1), i + 1, j);
            mark[i][j] = 0;
            if (flag) {
                return flag;
            }
        }
        if (i - 1 >= 0 && mark[i - 1][j] == 0 && board[i - 1][j] == word.charAt(0)) {
            mark[i][j] = 1;
            flag = startDp(board, mark, word.substring(1), i - 1, j);
            mark[i][j] = 0;
            if (flag) {
                return flag;
            }
        }
        if (j - 1 >= 0 && mark[i][j - 1] == 0 && board[i][j - 1] == word.charAt(0)) {
            mark[i][j] = 1;
            flag = startDp(board, mark, word.substring(1), i, j - 1);
            mark[i][j] = 0;
            if (flag) {
                return flag;
            }
        }
        if (j + 1 < board[i].length && mark[i][j + 1] == 0 && board[i][j + 1] == word.charAt(0)) {
            mark[i][j] = 1;
            flag = startDp(board, mark, word.substring(1), i, j + 1);
            mark[i][j] = 0;
            if (flag) {
                return flag;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Num79 num79=new Num79();
        char[][] board=new char[3][4];
        //board数组赋值[
        //             ["A","B","C","E"],
        //             ["S","F","E","S"],
        //             ["A","D","E","E"]]
        board[0][0]='A';
        board[0][1]='B';
        board[0][2]='C';
        board[0][3]='E';
        board[1][0]='S';
        board[1][1]='F';
        board[1][2]='E';
        board[1][3]='S';
        board[2][0]='A';
        board[2][1]='D';
        board[2][2]='E';
        board[2][3]='E';
        System.out.println(num79.exist(board,"ABCESEEEFS"));
    }
}

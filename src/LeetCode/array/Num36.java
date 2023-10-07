package LeetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你判断一个9 x 9的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 在每一个以粗实线分隔的宫内只能出现一次。
 */
public class Num36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxes = new HashMap[9];
        //初始化
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        //遍历数独
        for (int i = 0; i < 9; i++) {
            //行
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    //获取当前数独的值
                    int n = (int) num;
                    //获取当前数独所在的box的索引
                    int box_index = (i / 3) * 3 + j / 3;
                    //更新哈希表
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    //检查是否有重复
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board){
        //一个哈希表,用于记录数字出现在第几行
        Map<String, Integer> rowMap = new HashMap<>();
        //一个哈希表,用于记录数字出现在第几列
        Map<String, Integer> columMap = new HashMap<>();
        //一个哈希表,用于记录数字出现在第几块
        Map<String, Integer> areaMap = new HashMap<>();
        //先判断每一列是否有重复数字
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String keyRow = board[i][j] + "row" + i;
                    String keyColum = board[i][j] + "colum" + j;
                    int area=(i/3)*3+j/3;
                    String keyArea = board[i][j] + "area" + area;
                    if (rowMap.containsKey(keyRow)||columMap.containsKey(keyColum)||areaMap.containsKey(keyArea)) {
                        return false;
                    } else {
                        columMap.put(keyColum,1);
                        rowMap.put(keyRow, 1);
                        areaMap.put(keyArea,1);
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Num36 num36=new Num36();

    }
}

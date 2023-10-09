package LeetCode.array;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class Num48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length / 2;
        if (matrix.length % 2 == 1) {
            len++;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix[j].length - 1 - j][i];
                matrix[matrix[j].length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix[j].length - 1 - j];
                matrix[matrix.length - 1 - i][matrix[j].length - 1 - j] = matrix[j][matrix[i].length - 1 - i];
                matrix[j][matrix[i].length - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Num48 num48 = new Num48();
        int[][] matrix = new int[4][4];
        //[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        //	测试用例:[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        //	测试结果:[[15,12,2,5],[14,6,3,13],[10,8,4,9],[16,7,1,11]]
        //	期望结果:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        matrix[0][0] = 5;
        matrix[0][1] = 1;
        matrix[0][2] = 9;
        matrix[0][3] = 11;
        matrix[1][0] = 2;
        matrix[1][1] = 4;
        matrix[1][2] = 8;
        matrix[1][3] = 10;
        matrix[2][0] = 13;
        matrix[2][1] = 3;
        matrix[2][2] = 6;
        matrix[2][3] = 7;
        matrix[3][0] = 15;
        matrix[3][1] = 14;
        matrix[3][2] = 12;
        matrix[3][3] = 16;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        num48.rotate(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

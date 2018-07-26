class Solution {
    public void setZeroes(int[][] matrix) {

        int numOfRow = matrix.length;
        int numOfCol = (numOfRow > 0)? matrix[0].length : 0;
        if (numOfRow == 0 || numOfCol == 0) return;


        //找到第一个0的位置
        int firstZeroRow = -1;
        int firstZeroCol = -1;
        for (int i = 0; i < numOfRow; i++) {
            for(int j = 0; j < numOfCol; j++) {
                if (matrix[i][j] == 0) {
                    firstZeroRow = i;
                    firstZeroCol = j;
                    break;
                }
            }
        }


        if (firstZeroRow == -1 || firstZeroCol == -1) return;

        //映射其它0到第一个0所在的行和列
        for (int i = 0; i < numOfRow; i++) {
            for (int j = 0; j < numOfCol; j++){
                if (matrix[i][j] == 0){
                    matrix[firstZeroRow][j] = 0;
                    matrix[i][firstZeroCol] = 0;
                }
            }
        }

        //根据映射清0，留下第一个0所在的行和列
        for (int i = 0; i < numOfRow; i++) {
            if (i == firstZeroRow) continue;
            for (int j = 0; j < numOfCol; j++){
                if (j == firstZeroCol) continue;
                if (matrix[firstZeroRow][j] == 0 || matrix[i][firstZeroCol] == 0)
                    matrix[i][j] = 0;
            }
        }

        //清理行和列
        for (int i = 0; i < numOfRow; i++) {
            matrix[i][firstZeroCol] = 0;
        }
        for (int j = 0; j < numOfCol; j++) {
            matrix[firstZeroRow][j] = 0;
        }

    }
}
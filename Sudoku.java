/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author haoxuan.wang14
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    static int[][] map = new int[9][9];
    static Scanner kb = new Scanner(System.in);

    private static boolean isPlace(int count) {
        int row = count / 9;
        int col = count % 9;
        int j;
        for (j = 0; j < 9; ++j) {
            if (map[row][j] == map[row][col] && j != col) {

                return false;
            }
        }
        for (j = 0; j < 9; ++j) {

            if (map[j][col] == map[row][col] && j != row) {
                return false;
            }
        }

        int tempRow = row / 3 * 3;

        int tempCol = col / 3 * 3;

        for (j = tempRow; j < tempRow + 3; ++j) {
            for (int k = tempCol; k < tempCol + 3; ++k) {
                if (map[j][k] == map[row][col] && j != row) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void backtrace(int count, int remeber) {

        if (count == 81) {
            System.out.println("结果:");
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }
        int row = count / 9;
        int col = count % 9;
        if (map[row][col] == 0) {
            int i;
            for (i = remeber; i <= 9; ++i) {
                map[row][col] = i;
                if (isPlace(count)) {
                    remeber =  1;
                    backtrace(count + 1, remeber);
                    
                }
                map[row][col] = 0; //重置这个位置的数字
                remeber = i + 1;
            }
        } else {
            backtrace(count + 1, remeber); //跳过题目给的数字
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; ++i) {
            String[] temp = kb.nextLine().split(" ");
            for (int j = 0; j < 9; ++j) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        backtrace(0, 1);
    }
}

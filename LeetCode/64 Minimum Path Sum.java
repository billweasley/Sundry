/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example 1:
 [[1,3,1],
 [1,5,1],
 [4,2,1]]
 Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * */
//标准二维dp
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] matrix = new int[grid.length][grid[0].length];
        matrix[0][0] = grid[0][0];
        for(int i = 1; i < matrix.length; i++){
            matrix[i][0] =  matrix[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < matrix[0].length; i++){
            matrix[0][i] =  matrix[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + grid[i][j];
            }
        }
        return matrix[grid.length - 1][grid[0].length - 1];
    }
}
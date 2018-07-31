class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        int[] father = new int[grid.length * grid[0].length];

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    count++;
                    father[i * n + j] = i * n + j;
                }
            }
        }

        int[][] neighbors = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (grid[i][j] > '0'){
                    for(int[] nei: neighbors){
                        int x = i + nei[0];
                        int y = j + nei[1];
                        if (x >= 0 && y >= 0 && y < n && x < m && grid[x][y] > '0'){
                            count = union(father, i * n + j, x * n + y, count);
                        }
                    }
                }
            }
        }

        return count;
    }

    //return count
    public int union(int[] father, int i, int j, int count){
        int find1 = find(father, i);
        int find2 = find(father, j);
        if(find1 != find2){
            father[find1] = find2;
            count--;
        }
        return count;
    }

    public int find(int[] father, int i){
        if (father[i] == i) return father[i];
        father[i] = find(father, father[i]);
        return father[i];
    }

}
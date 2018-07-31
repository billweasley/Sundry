class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] table = new int[26];
        for (char t: tasks){
            table[(int) (t - 'A')]++;
        }
        Arrays.sort(table);
        int res = 0;
        int maxCol = table[25] - 1;
        int idle = n * maxCol;
        for (int i = 24; i >= 0 && table[i] > 0; i--){
            idle = idle - Math.min(maxCol, table[i]);
        }
        return (idle > 0)? idle + tasks.length : tasks.length;

    }
}
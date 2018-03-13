/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 * */
class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k < 0) return 0;
        if(k > prices.length / 2){
            int res = 0;
            for(int i = 1; i<prices.length;i++){
                if(prices[i] > prices[i-1]) res += (prices[i] - prices[i - 1]);
            }
            return res;
        }
        // For days before [i] th days(include the i th day), the maximum profit for at most [k] transanctions
        int[][] hold = new int[prices.length][k+1]; //hold[i][j] = Max(unhold[i-1][j-1]-prices[i], hold[i-1][j])
        int[][] unhold = new int[prices.length][k+1]; //unhold[i][j] = Max(hold[i-1][j] + prices[i], unhold[i-1][j])
        //hold[0][j] = -prices[0] //第 0 天的交易，只有这个值可选
        //hold[j][0] = MAX(-prices[j],hold[j-1][0]) 一共最多一笔交易，求这一笔最大值
        for(int i = 0; i<= k; i++) {
            hold[0][i] = -prices[0];
        }
        for(int i = 1; i< prices.length; i++) {
            hold[i][0] = Math.max(-prices[i], hold[i-1][0]);
        }
        for(int i = 1; i<prices.length; i++){
            for(int j = 1; j<=k; j++){
                hold[i][j] = Math.max(unhold[i-1][j-1] - prices[i], hold[i-1][j]);
                unhold[i][j] = Math.max(hold[i-1][j] + prices[i], unhold[i-1][j]);
            }
        }

        return unhold[prices.length - 1][k]; //hold 一定小于 unhold

    }
}
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * */
// DP
class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;

        int[] leftMaxProfit = new int[prices.length]; //l[i] = Profit max[0 ... i]
        int[] rightMaxProfit = new int[prices.length]; // r[i] = Profit max[i  ... n - 1]

        //l[i] = max(l[i - 1], price[i] - LowestPrice[0 ... i-1])
        int lowestPrice = prices[0];
        for(int i = 1; i<prices.length;i++){
            lowestPrice = Math.min(lowestPrice, prices[i-1]);
            leftMaxProfit[i] = Math.max(leftMaxProfit[i-1], prices[i] - lowestPrice);
        }

        //r[i] = max(r[i + 1], HighestPrice[i+1 ... n-1] - price[i])
        int highestPrice = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0;i--){
            highestPrice = Math.max(highestPrice, prices[i+1]);
            rightMaxProfit[i] = Math.max(rightMaxProfit[i+1], highestPrice - prices[i]);
        }

        int profit = 0;
        for(int i=0;i< prices.length;i++){
            profit = Math.max(leftMaxProfit[i]+rightMaxProfit[i], profit);
        }

        return profit;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int price: prices){
            if (price < lowest) lowest = price;
            if (price - lowest > maxProfit) maxProfit = price - lowest;
        }
        return maxProfit;
    }
}
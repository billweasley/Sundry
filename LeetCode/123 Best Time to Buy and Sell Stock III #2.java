class Solution {
    public int maxProfit(int[] prices) {

        if (prices.length == 0) return 0;

        int[] firstPart = new int[prices.length];
        int[] secondPart = new int[prices.length];

        int lowestFirst = prices[0];
        int highestSecond = prices[prices.length - 1];

        for (int i = 0; i < prices.length; i++){
            int j = prices.length - 1 - i;
            if (lowestFirst > prices[i])
                lowestFirst = prices[i];
            if (highestSecond < prices[prices.length - 1 - i])
                highestSecond = prices[prices.length - 1 - i];

            if (i - 1 >= 0) firstPart[i] = Math.max(firstPart[i - 1], prices[i] - lowestFirst);
            secondPart[j] = Math.max(secondPart[j], highestSecond - prices[j]);
        }

        int res = 0;

        for (int i = 0; i < prices.length; i++){
            res = Math.max(res, firstPart[i] + secondPart[i]);
        }
        return res;

    }
}
package mincountofpayandcharge;
/*
一道算法题：在超市用现金结账时，有以下几种纸币，arr[] =[100,50,20,5,1]
，现在求我如何付钱以及收银员如何找钱，才能使付给收银员张数和收银员找回的张数加起来最少？比如结账需付19，可以付20，然后收银员找1，这样只需要2张钱，数量最少。
*/
import java.util.Scanner;

public class MinCountOfPayAndCharge {

    public static void main(String[] args) {

        System.out.println("Please input the price needed to be calculated: ");
        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();
        int[] values = {100, 50, 20, 5, 1};
        MinCountOfPayAndCharge(values, input);
    }

    public static void MinCountOfPayAndCharge(int[] values, int price) {
        int minSumCount = Integer.MAX_VALUE;
        int minPaid = 0;
        int[] payMinCount = MinCountOfMoney(values, price+99);
        //calculate the possible used value [price,price+100), 100 is the largest value of given money type
        
        for (int pay = price; pay < price + 100; pay++) {
            int tempSumCount = payMinCount[pay] + payMinCount[pay - price]; 
            // tempSumCount = the minimum count of pay + the minimum Charge
            if (tempSumCount < minSumCount) {
                minSumCount = tempSumCount;
                minPaid = pay;
            }
        }
        System.out.println("The minimum number of count achieved if you pay " + minPaid + ", the actual number of that is " + minSumCount);
    }

    /** A simple change change problem using Dynamic Programming 
     * @param values array to storage existing type of money  
     * @param askedValue the money value needed to express 
     * @return array recording the intermediate results of minimum count can be achieved and final result(in last cell) 
     */
    public static int[] MinCountOfMoney(int[] values, int askedValue) {

        int numOfType = values.length; 
        //the number of money type  钱币种类数
        int[] minNumUsed = new int[askedValue + 1]; 
        //array if recording the intermediate result 记录中间结果（每一个给定钱币值）的数组

        for (int cent = 1; cent <= askedValue; cent++) { 
            //calculate the mininum used number for each value of money value from bottom to up 从小到大开始计算最小钱币数
            int minCount = cent; 
            //initally is maximum number (all expressed as 1) 初始值为最大值（全用1表示）
            for (int thisType = 0; thisType < numOfType; thisType++) { 
                //iterate all kind of money 遍历所有种类钱币
                if (values[thisType] <= cent) { 
                    //if accepted, use the kind of money
                    int temp = minNumUsed[cent - values[thisType]] + 1; 
                    //calculate the temporary count if use this kind of many and use intermediate result
                    if (temp < minCount) {
                        minCount = temp;
                    }
                }
            }
            minNumUsed[cent] = minCount; 
            //record the intermediate/final result
        }
        return minNumUsed;

    }

}

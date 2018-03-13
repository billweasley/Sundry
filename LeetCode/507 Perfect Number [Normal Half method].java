/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 Example:
 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14
 Note: The input number n will not exceed 100,000,000. (1e8)
 *
 * */

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 1) return false;
        int half = num >> 1;
        int sum = 1;
        int temp = 0;
        for(int i = 2; i <= half; i++){ // 2 <-> 14; 4 <--> 7
            if(num % i == 0) {
                sum += i;
                if(i != half) {
                    temp = num/i;
                    sum += temp;
                    half = temp >> 1;
                }
            }
        }
        return sum == num;
    }
}
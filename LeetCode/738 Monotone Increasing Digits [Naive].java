/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

 (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

 Example 1:
 Input: N = 10
 Output: 9

 Example 2:
 Input: N = 1234
 Output: 1234

 Example 3:
 Input: N = 332
 Output: 299

 Note: N is an integer in the range [0, 10^9].
 *
 * */
// 末尾开始 换为9， 前一位 -1，注意对 0 的处理。
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] charArr = String.valueOf(N).toCharArray();
        int max = -1;
        if(isIncreasing(charArr)){
            return N;
        }else{
            for(int i = charArr.length - 1; i > 0; i--){
                charArr[i] = '9';
                if(charArr[i-1] == '0'){
                    while (i>0 && charArr[i-1] == '0'){
                        charArr[i-1] = '9';
                        i--;
                    }
                    if(i == 0){
                        charArr[0] = '0';
                    }else{
                        charArr[i-1]--;
                    }
                }else{
                    charArr[i-1]--;
                }
                if(isIncreasing(charArr)){
                    max = Math.max(reAssemblyNum(charArr),max);
                }
            }
            return max;
        }
    }
    private int reAssemblyNum(char[] charArr){
        int res = 0;
        for(int i = 0; i < charArr.length; i++){
            res = res * 10 + (charArr[i] - '0');
        }
        return res;
    }
    private boolean isIncreasing(char[] charArr){
        for(int i = 0; i < charArr.length - 1; i++){
            if(charArr[i] > charArr[i+1]) return false;
        }
        return true;
    }
}
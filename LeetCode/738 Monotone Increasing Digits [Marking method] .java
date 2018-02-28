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
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] charArr = String.valueOf(N).toCharArray();
        int marker = charArr.length;
        for(int i = charArr.length - 1; i > 0; i--){
            if(charArr[i-1]>charArr[i]){
                marker = i; //最前逆序处，该位置及后面均为9
                charArr[i-1]--;//前一位-1
            }
        }
        for(int i = marker; i< charArr.length; i++){
            charArr[i] = '9';
        }
        return Integer.parseInt(new String(charArr));
    }
}
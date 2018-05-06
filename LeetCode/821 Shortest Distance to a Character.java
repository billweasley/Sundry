/*Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 

Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        int lastIndex = -1;
        int[] res = new int[S.length()];
        //part before first 0
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                for (int j = 0; j < i; j++) res[j] = i - j;
                lastIndex = i;
                break;
            }
        }
        for (int i = lastIndex + 1; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                int distance = i - lastIndex - 1;
                int k = (lastIndex + i) >> 1; //k is the mid index of the internal === (lastIndex + currentIndex) / 2
                int j = ((distance & 1) == 1) ? k : k + 1; //Initially, <- kPointer == mid == jPointer (or == mid + 1 for even distance case) ->
                for (; j <= i; j++, k--) res[j] = res[k] = i - j;
                lastIndex = i;
            }
        }
        for (int i = lastIndex + 1; i < S.length(); i++) res[i] = i - lastIndex;
        return res;
    }
}
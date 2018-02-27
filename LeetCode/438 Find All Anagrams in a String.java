/**
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.isEmpty() || s.length() < p.length()) return new LinkedList<>();
        char[] pArr = p.toCharArray();
        int[] pHash = new int[26];
        for(char c: pArr){
            pHash[c - 'a']++;
        }

        int[] sHash = new int[26];
        char[] sArr = s.toCharArray();

        for(int i=0; i<p.length();i++){
            sHash[sArr[i] - 'a']++;
        }
        List<Integer> result = new LinkedList<>();
        int leftIndex = 0;
        int rightIndex = p.length() - 1;
        while(rightIndex < sArr.length){
            if(Arrays.equals(sHash, pHash)){
                result.add(leftIndex);
            }
            sHash[sArr[leftIndex] - 'a'] --;
            if(rightIndex + 1 < sArr.length)
                sHash[sArr[rightIndex + 1] - 'a'] ++;
            rightIndex++;
            leftIndex++;
        }

        return result;

    }
}

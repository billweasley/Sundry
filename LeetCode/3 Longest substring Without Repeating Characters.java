class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> mark = new HashSet<>();
        int i = 0;
        int j = 0;
        //window
        while (i < s.length() && j < s.length()){
            if (!mark.contains(s.charAt(j))){
                mark.add(s.charAt(j++));
                if (maxLength < j - i) maxLength = j - i;
            }else{
                mark.remove(s.charAt(i++)); //直到上一个被移除
            }
        }

        return maxLength; //dvdf
    }
}
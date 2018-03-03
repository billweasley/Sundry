/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 Note:

 S will be a string with length at most 12.
 S will consist only of letters or digits.
 *
 */

//BFS
class Solution {
    public List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.add(S);
        int i = 0, j = 0;
        while(i < S.length()){
            if(Character.isAlphabetic(S.charAt(i))){
                int size = queue.size();
                j=0;
                while(j++ < size){
                    char[] cnt = queue.poll().toCharArray();
                    queue.add(String.valueOf(cnt));
                    if(Character.isUpperCase(cnt[i])){
                        cnt[i] = Character.toLowerCase(cnt[i]);
                    }else{
                        cnt[i] = Character.toUpperCase(cnt[i]);
                    }
                    queue.add(String.valueOf(cnt));
                }
            }
            i++;
        }
        return new LinkedList<String>(queue);

    }
}
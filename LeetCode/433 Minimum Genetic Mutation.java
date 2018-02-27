/**
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

 Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

 For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

 Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

 Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

 Note:

 Starting point is assumed to be valid, so it might not be included in the bank.
 If multiple mutations are needed, all mutations during in the sequence must be valid.
 You may assume start and end string is not the same.
 Example 1:

 start: "AACCGGTT"
 end:   "AACCGGTA"
 bank: ["AACCGGTA"]

 return: 1
 Example 2:

 start: "AACCGGTT"
 end:   "AAACGGTA"
 bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

 return: 2
 Example 3:

 start: "AAAAACCC"
 end:   "AACCCCCC"
 bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

 return: 3

 *
 * */

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(end)) return -1;
        char[] symbols = new char[]{'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size(); //IMPORTANT!
            for(int s = 0; s< size; s++){
                String ori = queue.poll();
                if(ori.equals(end)) return level;
                for(int i = 0; i < 8; i++){
                    for(char symbol: symbols){
                        if(ori.charAt(i) != symbol){
                            StringBuilder sb = new StringBuilder(ori);
                            sb.setCharAt(i,symbol);
                            String newStr = sb.toString();
                            if(bankSet.contains(newStr)){
                                bankSet.remove(newStr);
                                queue.offer(newStr);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;

    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            map.put(c, (map.get(c) == null)? 1 : map.get(c) + 1);
        }
        for (char c: t.toCharArray()){
            if (map.get(c) != null && map.get(c) > 0){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);
            }else{
                return false;
            }
        }
        return map.size() == 0;
    }
}
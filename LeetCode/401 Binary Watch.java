class Solution {
    public List<String> readBinaryWatch(int num) {
        List<Set<Integer>> hCount = new LinkedList<Set<Integer>>();
        List<Set<Integer>> mCount = new LinkedList<Set<Integer>>();
        List<String> res = new LinkedList<>();

        for (int i = 0; i < 5; i++){
            hCount.add(new HashSet<Integer>());
        }
        for (int i = 0; i < 7; i++){
            mCount.add(new HashSet<Integer>());
        }

        for (int i = 0; i <= 11; i++){
            hCount.get(Integer.bitCount(i)).add(i);
        }

        for (int i = 0; i <= 59; i++){
            mCount.get(Integer.bitCount(i)).add(i);
        }

        for(int i = 0; i < hCount.size() && i <= num; i++){
            Set<Integer> hSet = hCount.get(i);
            if (num - i < mCount.size()){
                Set<Integer> mSet = mCount.get(num - i);
                for (int h: hSet){
                    for (int m: mSet){
                        res.add(String.format("%d:%02d", h, m));
                    }
                }
            }

        }

        return res;

    }


}
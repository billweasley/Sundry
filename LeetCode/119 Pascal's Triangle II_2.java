class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++){
            res = getNextRow(res);
        }
        return res;
    }


    private List<Integer> getNextRow(List<Integer> list){
        int newlength = list.size() + 1;
        list.add(0);
        for (int i = newlength - 1; i > 0; i--){
            list.set(i, list.get(i - 1) +  list.get(i));
        }
        return list;
    }
}
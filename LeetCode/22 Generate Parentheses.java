class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backingTrack(0, 0, n, "", res);
        return res;
    }


    private void backingTrack(int numOfLeft, int numOfRight, int n, String current, List<String> list){

        if (numOfRight == n) {
            list.add(current);
            return;
        }

        if (numOfLeft < n){
            backingTrack(numOfLeft + 1, numOfRight, n, current + "(", list);
        }

        if(numOfRight < numOfLeft){
            backingTrack(numOfLeft, numOfRight + 1, n, current + ")", list);
        }

    }


}
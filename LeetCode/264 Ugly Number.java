class Solution {
    public int nthUglyNumber(int n) {
        int res = 1;
        if (n == 1) return res;
        Queue<Integer> doubled = new LinkedList<>();
        Queue<Integer> tripled = new LinkedList<>();
        Queue<Integer> fivetimes = new LinkedList<>();
        for(int i = 2; i <= n; i++){
            doubled.add(res * 2);
            tripled.add(res * 3);
            fivetimes.add(res * 5);
            int tw = doubled.peek();
            int thr = tripled.peek();
            int fiv = fivetimes.peek();
            int max = Math.min(Math.min(tw, thr), fiv);
            if(max > res){
                res = max;
                if (tw == max) doubled.poll();
                if (thr == max) tripled.poll();
                if (fiv == max) fivetimes.poll();
            }
        }
        return res;
    }
}
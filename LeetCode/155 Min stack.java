class MinStack {

    private int top = 0;
    private int[] main;
    private int[] min;
    private int currentSize;

    /** initialize your data structure here. */
    public MinStack() {
        this(1024);
    }

    public MinStack(int n) {
        main = new int[n];
        min = new int[n];
        currentSize = n;
        min[0] = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (top == currentSize){
            int[] tempMain = new int[currentSize * 2];
            System.arraycopy(main, 0, tempMain, 0, currentSize);
            main = tempMain;
            int[] tempMin = new int[currentSize * 2];
            System.arraycopy(min, 0, tempMin, 0, currentSize);
            min = tempMin;
            currentSize *= 2;
        }
        if (top > 0) {
            min[top] = Math.min(min[top - 1], x);
        }else{
            min[top] = x;
        }
        main[top++] = x;
    }

    public void pop() {
        if (top == 0) return;
        min[top] = Integer.MAX_VALUE;
        main[top] = 0;
        top--;
    }

    public int top() {
        return (top >= 1)? main[top - 1] : -1;
    }

    public int getMin() {
        return (top >= 1)? min[top - 1] : -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
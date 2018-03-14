

public class Nqueue {
    public static void main(String[] args){
        long start =  System.currentTimeMillis();
      // System.out.println( new Nqueue().getRes(17,new int[17],0));
               System.out.println( new Nqueue().getResBit(8,0,0,0,0));
       System.out.println((System.currentTimeMillis() - start)/1000.0);

    }
    public int getRes(int n,int[] board,int index){
        //board[n] = m: 第 n + 1 行, 第 m 列 放置了皇后
        int count = 0;
        if (index == n) return 1;
        for (int i=1;i <= n;i++){
            if (canPut(index,i,board)){
                board[index] = i;
                count += getRes(n,board,index+1);
            }
        }
        return count;
    }


    private boolean canPut(int index, int value, int[] board){
        for (int i = 0; i< index ;i++){
            if (board[i] == value || index + value == i + board[i] || index - value == i  - board[i]) return false;
        }
        return true;
    }


    public int getResBit(int n, long l, long m, long r, int index){
        int count = 0;
        if (index == n) return 1;
        System.out.println("Mask: "+Integer.toBinaryString((1 << n) - 1));
        long available = ((1 << n) - 1) & ~(m | r | l);
        System.out.println("Temp: "+Long.toBinaryString(~(m | r | l)));
        System.out.println("Available: "+Long.toBinaryString(available));

        //for (int i = 0;i < n;i++){
        while (available != 0L){
            long possibleRow = available & -available;
            available ^= possibleRow;

           // long rowPosInLineI = 1 << i;
           // if ((rowPosInLineI & l) != 0|| (rowPosInLineI & m) != 0 || (rowPosInLineI & r) != 0) continue;
            count += getResBit(n,(possibleRow | l)<<1,possibleRow | m, (possibleRow | r)>>1,index+1);
        }
        return count;
    }

}



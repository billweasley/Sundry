public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //无符号右移动
        n = ((n & 0X0000FFFF) << 16) | ((n & 0XFFFF0000) >>> 16); //16
        n = ((n & 0X00FF00FF) << 8 ) | ((n & 0XFF00FF00) >>> 8 ); //8
        n = ((n & 0X0F0F0F0F) << 4 ) | ((n & 0XF0F0F0F0) >>> 4 ); //4
        n = ((n & 0X33333333) << 2 ) | ((n & 0XCCCCCCCC) >>> 2 ); //2
        n = ((n & 0X55555555) << 1 ) | ((n & 0XAAAAAAAA) >>> 1 ); //1
        return n;
    }
}
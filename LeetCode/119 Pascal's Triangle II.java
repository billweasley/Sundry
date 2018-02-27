/**
* Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
* **/


class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<Integer>();
        /**
         *  In place 版本
         *  1 -> 1 1 -> 1 2 1 -> 1 3 3 1 -> ......
         *  Transform:
         *  1. 首先在结尾append一个1 （1 -> 1 1 , 1 1 -> 1 1 1, 1 2 1 -> 1 2 1 1）
         *  2. 从倒数第二位开始，倒序相加，这样序列前面后相加的数不会使用后面相加先改变的值
         *  1 1 --(第一步)-> 1 1 1 --> 1 (1+1) 1
         *  1 2 1 --(第一步)-> 1 2 1 1 -> 1 (1+2) (2+1) 1
         * */
        for(int i = 0; i<= rowIndex; i++){
            list.add(1);
            for(int j = i - 1; j > 0;j--){
                list.set(j, list.get(j-1) + list.get(j));
            }

        }
        return list;
    }
}
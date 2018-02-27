/**
 Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 I - 1
 V - 5
 X - 10
 L - 50
 C - 100
 D - 500
 M - 1000
 Rules:
 * If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
 * If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
 * If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900

 * */
class Solution {
    public int romanToInt(String s) {

        char[] charArr = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = map.get(charArr[charArr.length - 1]);
        //倒序遍历
        for(int i=charArr.length-2; i>=0; i--){
            if(map.get(charArr[i]) >= map.get(charArr[i+1])){
                res += map.get(charArr[i]);
            }else{
                res -= map.get(charArr[i]);
            }
        }

        return res;

    }
}
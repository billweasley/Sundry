class Solution {
    public int myAtoi(String str) {

        boolean started = false;
        boolean isNagtive = false;
        boolean signalStarted = false;
        int value = 0;

        for(char c: str.toCharArray()){
            if(started){
                if(signalStarted){
                    if(Character.isDigit(c)){
                        value = (int)(c - '0');
                        signalStarted = false;
                    }else{
                        return 0;
                    }
                }else{
                    if (Character.isDigit(c)){
                        int ori = value;
                        value = value * 10 + (int)(c - '0');
                        if (value / 10 != ori) return isNagtive? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }else{
                        return isNagtive? 0 - value : value;
                    }
                }
            }else{
                if(c == ' ') continue;
                if(Character.isDigit(c)){
                    value = (int)(c - '0');
                    started = true;
                }else if(c == '+'){
                    started = true;
                    signalStarted = true;
                }else if(c == '-'){
                    started = true;
                    signalStarted = true;
                    isNagtive = true;
                }else{
                    return 0;
                }
            }

        }
        return isNagtive? 0 - value : value;




    }
}
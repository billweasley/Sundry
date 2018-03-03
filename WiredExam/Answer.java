import java.util.*;

public class Answer {

    public static void main(String[] args){
       System.out.println( new Answer().getAns());
    }
    char[] options = new char[]{'A','B','C','D'};
    public String getAns(){
        Queue<String> queue = new LinkedList<>();
        queue.offer("AAAAAAAAAA");
        Set<String> hasVisited = new HashSet<>();
        Set<String> res = new HashSet<>();
        int i = 0;
        while (!queue.isEmpty()){
            char[] cnt = queue.poll().toCharArray();
            if (isValidAns(cnt)) return String.valueOf(cnt);
            i = (i + 1) % 10;
            for (char opt: options){
                if (opt != cnt[i]){
                    cnt[i] = opt;
                    if (!hasVisited.contains(String.valueOf(cnt))){
                        queue.offer(String.valueOf(cnt));
                    }
                }
            }
            hasVisited.add(String.valueOf(cnt));
        }
        return null;
    }
    char[] q2 = new char[]{'C','D','A','B'};
    int[] q3 = new int[]{3, 6, 2, 4};
    char[] q7 = new char[]{'C','B','A','D'};

    private boolean isValidAns(char[] ans){
        String str = String.valueOf(ans);
        int[] count = new int[4];
        for (char c: ans){
            count[c - 'A']++;
        }
        //Q2
        if (q2[ans[1] - 'A'] != ans[4]){
            return false;
        }

        //Q3
        char toCheckQ3 = ans[q3[ans[2] - 'A']];
        char temp = '-';
        for(int i = 0; i<4; i++){
            for (int j= i;j<4;j++){
                if(i != (ans[2] - 'A') &&j != (ans[2] - 'A')){
                    if (ans[q3[i]-1] != ans[q3[j]-1]) {
                        return false;
                    }
                    if (ans[q3[i]] == ans[q3[j]]) temp = ans[q3[j]];
                }
            }
        }
        if (temp != '-' && toCheckQ3 == temp ) {
            return false;
        }
        //Q4
        switch (ans[3]){
            case 'A':
                if (ans[0] != ans[4]) {  return false;}
                break;
            case 'B':
                if (ans[1] != ans[6]) {  return false;}
                break;
            case 'C':
                if (ans[0] != ans[8]){  return false;}
                break;
            case 'D':
                if (ans[5] != ans[9]) {  return false;}
                break;
        }
        //Q5
        switch (ans[4]){
            case 'A':
                if (ans[7] != ans[4]) {  return false;}
                break;
            case 'B':
                if (ans[3] != ans[4]) {  return false;}
                break;
            case 'C':
                if (ans[8] != ans[4]) {  return false;}
                break;
            case 'D':


                if (ans[6] != ans[4]) {  return false;}
                break;
        }

        //Q6
        switch (ans[5]){
            case 'A':
                if (ans[1] != ans[7] || ans[3] != ans[7])  { return false;};
                break;
            case 'B':
                if (ans[0] != ans[7] || ans[5] != ans[7]) { return false;}
                break;
            case 'C':
                if (ans[2] != ans[7] || ans[9] != ans[7]) { return false;}
                break;
            case 'D':
                if (ans[4] != ans[7] || ans[8] != ans[7])  { return false;}
                break;
        }

        //Q7
        int max = 0;
        int min = 0;
        for (int i=0;i<count.length;i++){
            if (count[i] >= count[max]){  max = i; }

            if (count[i] <= count[min]) { min = i; }
        }
        
        if (q7[ans[6] - 'A'] != (char)('A' + min))  { return false;}

        //Q8
        switch (ans[7]){
            case 'A':
                if (Math.abs(ans[6] - ans[0])==1)  { return false;}
                break;
            case 'B':
                if (Math.abs(ans[4] - ans[0])==1) { return false;}
                break;
            case 'C':
                if (Math.abs(ans[1] - ans[0])==1)  { return false;}
                break;
            case 'D':
                if (Math.abs(ans[9] - ans[0])==1) { return false;}
                break;
        }

        //Q9
        switch (ans[8]){
            case 'A':
                if ((ans[0] == ans[5]) == (ans[4] == ans[4])) { return false;}
                break;
            case 'B':
                if ((ans[0] == ans[5]) == (ans[9] == ans[4])) { return false;}
                break;
            case 'C':
                if ((ans[0] == ans[5]) == (ans[1] == ans[4])){ return false;}
                break;
            case 'D':
                if ((ans[0] == ans[5]) == (ans[8] == ans[4])) { return false;}
                break;
        }

        //Q10
        int diff = count[max] - count[min];
        switch (ans[9]){
            case 'A':
                if (diff != 3) { return false;}
                break;
            case 'B':
                if (diff != 2) { return false;}
                break;
            case 'C':
                if (diff != 4) { return false;}
                break;
            case 'D':
                if (diff != 1) { return false;}
                break;
        }
        return true;
    }
}

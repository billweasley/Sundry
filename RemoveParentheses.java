import java.util.Stack;
/**
 链接：https://www.nowcoder.com/discuss/67319?toCommentId=1173383
 来源：牛客网

 在表达式值不变的情况下，将输入的表达式中的括号全去掉，并输出去掉括号后的表达式。
 输入 (a-(b+c))，输出 a-b-c;
 输入 ((a+b)-(c-d))-(e+f) ，输出 a+b-c+d-e-f;
 输入 a-(b-(c-(d-(e+f))))，输出a-b+c-d+e+f.
 * */
public class RemoveParentheses {
    public static void main(String[] args){
        String a = "(a-(b+c))";
        String b = "((a+b)-(c-d))-(e+f)";
        String c = "a-(b-(c-(d-(e+f))))";
        System.out.println(removeParentheses(a));
        System.out.println(removeParentheses(b));
        System.out.println(removeParentheses(c));

    }
    static String removeParentheses(String input){
        int length = input.length();
        char[] array = input.toCharArray();

        int count = 0;
        Stack<Integer> parenthesesStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i< length; i++){
            switch (array[i]){
                case '-':
                    sb.append(((count&1) == 1)?'+':'-');
                    if(i < length - 1 && array[i+1] == '('){
                        count ++;
                        parenthesesStack.push(i+1);
                        i++;
                    }
                    break;
                case ')':
                    int lastLeftIndex = parenthesesStack.pop();
                    if (lastLeftIndex > 0 && array[lastLeftIndex - 1] == '-') {
                        count--;
                    }
                    break;
                case '+':
                    sb.append(((count&1) == 1)?'-':'+');
                    break;
                case '(':
                    parenthesesStack.push(i);
                    break;
                default:
                    sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}

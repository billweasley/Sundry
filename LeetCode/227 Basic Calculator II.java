/**
 Implement a basic calculator to evaluate a simple expression string.

 The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

 You may assume that the given expression is always valid.

 Some examples:
 "3+2*2" = 7
 " 3/2 " = 1
 " 3+5 / 2 " = 5
 Note: Do not use the eval built-in library function.
 * */

class Solution {
    public int calculate(String s) {
        char[] ca = s.replaceAll(" ","").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        int currentNumber = 0;
        int index = 0;
        while(index < ca.length && Character.isDigit(ca[index])){
            currentNumber = currentNumber * 10 + (ca[index] - '0');
            index++;
        }
        stack.push(currentNumber);

        for(int i = index; i < ca.length; i++){  // i index for operator, j index for digit appednding to a operator

            currentNumber = 0;
            int j = i + 1;
            while(j<ca.length && Character.isDigit(ca[j])){
                currentNumber = currentNumber * 10 + (ca[j] - '0');
                j++;
            }
            switch(ca[i]){
                case '+':
                    stack.push(currentNumber);
                    //System.out.println(stack);
                    break;
                case '-':
                    stack.push(0 - currentNumber);
                    // System.out.println(stack);

                    break;
                case '*':
                    stack.push(stack.pop() * currentNumber);
                    // System.out.println(stack);

                    break;
                case '/':
                    stack.push(stack.pop() / currentNumber);
                    // System.out.println(stack);

                    break;
                default:;
            }
            i = j - 1;
            // System.out.println("INDEX" + i);

        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
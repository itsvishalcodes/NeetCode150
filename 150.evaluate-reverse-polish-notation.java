
import java.util.*;

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    private static Set<String> validTokens = new HashSet<>();
    public boolean isAnOperator(String token) {
        if (validTokens.isEmpty()) {
            validTokens.add("+");
            validTokens.add("-");
            validTokens.add("*");
            validTokens.add("/");
        }

        return validTokens.contains(token);
    }

    private int perform(int op1, int op2, String operator) {
        int val;
        switch(operator) {
            case "+" -> val = op1 + op2;
            case "-" -> val = op1 - op2;
            case "*" -> val = op1 * op2;
            case "/" -> val = op1 / op2;
            default -> throw new IllegalArgumentException("Unknown Operator");
        }

        return val;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++) {
            String currentToken = tokens[i];
            if (this.isAnOperator(currentToken)) {
                // Apply operator to top 2 elements and push result to stack.
                int top_most = st.pop();
                int second_top = st.pop();
                int result = this.perform(second_top, top_most, currentToken);
                st.push(result);
            } else {
                // push number to stack
                int valToPush = Integer.parseInt(currentToken);
                st.push(valToPush);
            }
        }

        return st.peek();
    }
}
// @lc code=end


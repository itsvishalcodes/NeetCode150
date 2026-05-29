
import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    Stack<Integer> st_original, st_min;
    public MinStack() {
        st_original = new Stack<>();
        st_min = new Stack<>();
    }
    
    public void push(int val) {
        st_original.push(val);
        // push the new val to min stack if the new val is smaller that min stack top.
        if(st_min.size() > 0) {
            int minValInMinStack = st_min.peek();
            if (minValInMinStack> val) {
                st_min.push(val);
            } else {
                st_min.push(minValInMinStack);
            }
        } else {
            st_min.push(val);
        }
    }
    
    public void pop() {
        st_original.pop();
        st_min.pop();
    }
    
    public int top() {
        return st_original.peek();
    }
    
    public int getMin() {
        return st_min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end


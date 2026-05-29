import java.util.*;
/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> mono_st = new Stack<>();
        int[] res = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            if (mono_st.isEmpty()) {
                mono_st.push(i);
            }
            else {
                while(!mono_st.isEmpty()) {
                    int topElemIdx = mono_st.peek();
                    int topElem = temperatures[topElemIdx];
                    if (topElem < temperatures[i]) {
                        res[topElemIdx] = i - topElemIdx;
                        mono_st.pop();
                    } else {
                        break;
                    }
                }
                mono_st.push(i);
            }
        }

        while(!mono_st.isEmpty()) {
            int topElemIdx = mono_st.pop();
            res[topElemIdx] = 0;
        }

        return res;
    }
}
// @lc code=end


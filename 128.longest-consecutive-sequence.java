
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int longestCons = 0;

        for(int i:nums) {
            st.add(i);
        }

        for (int i:nums) {
            int numToCheckPos = i, numToCheckNeg = i-1, longestConsTemp = 0;
            while(st.contains(numToCheckPos)) {
                st.remove(numToCheckPos);
                numToCheckPos++;
                longestConsTemp++;
            }
            while(st.contains(numToCheckNeg)) {
                st.remove(numToCheckNeg);
                numToCheckNeg--;
                longestConsTemp++;
            }

            longestCons = Math.max(longestCons, longestConsTemp);
        }

        return longestCons;
    }
}
// @lc code=end


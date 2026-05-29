
import java.util.HashMap;
import java.util.Map;



/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start

/*
MADE MULTIPLE ERRORS IN THIS PROBLEM
I was clearing all the items to the left of leftPtr one by one
when moving the leftPtr which pushed the worst case time complexity
to O(n-squared) and also caused bugs where I ended up clearing 
characters that were already there in the sliding window.
It's better to check if the character occured after the leftPtr and update
if it did, otherwise ignore it.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 1;
        int ptrLeft = 0, ptrRight = 1;

        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        Map<Character, Integer> charToIdx = new HashMap<>();
        charToIdx.put(s.charAt(ptrLeft), 0);

        while(ptrRight < s.length()) {
            char currentChar = s.charAt(ptrRight);
            boolean mapContainsCharacter = charToIdx.containsKey(currentChar);
            boolean ptrsNotEqual = ptrLeft != ptrRight;
            boolean duplicateElemAfterLeftPtr = mapContainsCharacter && charToIdx.get(currentChar) >= ptrLeft;
            if (ptrsNotEqual && duplicateElemAfterLeftPtr) {
                ptrLeft = charToIdx.get(s.charAt(ptrRight)) + 1;
            }
            charToIdx.put(s.charAt(ptrRight), ptrRight);
            maxLen = Math.max(maxLen, ptrRight - ptrLeft + 1);
            ptrRight++;
        }


        return maxLen;
    }
}
// @lc code=end



import java.util.Arrays;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int[] freqCount1 = new int[26], freqCount2 = new int[26];
        int leftPtr = 0, rightPtr = s1.length()-1;

        Arrays.fill(freqCount1, 0);
        Arrays.fill(freqCount2, 0);

        // Initial Freq Count construction
        for(int i=0; i<s1.length(); i++) {
            char currentChar1 = s1.charAt(i);
            char currentChar2 = s2.charAt(i);
            freqCount1[currentChar1 - 'a']++;
            freqCount2[currentChar2 - 'a']++;
        }
        
        while (rightPtr < s2.length()) {
            boolean allSame = true;
            for(int i=0; i<26; i++) {
                if (freqCount1[i] != freqCount2[i]) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) return true;

            // Fix window freqCount
            freqCount2[s2.charAt(leftPtr)-'a']--;
            leftPtr++;
            rightPtr++;
            if (rightPtr < s2.length()) {
                freqCount2[s2.charAt(rightPtr) - 'a']++;
            } else {
                // reached end, never found permutation
                return false;
            }
        }

        return false;
    }
}
// @lc code=end


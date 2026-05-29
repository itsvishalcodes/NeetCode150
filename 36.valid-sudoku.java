
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> stR = new HashSet<Character>();
        Set<Character> stC = new HashSet<Character>();
        
        // Check Rows
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(stR.contains(board[i][j])) return false;
                    stR.add(board[i][j]);
                }
                
                if(board[j][i] != '.') {
                    if(stC.contains(board[j][i])) return false;
                    stC.add(board[j][i]);
                }
            }

            stR.clear(); stC.clear();
        }

        stR.clear();

        // Check squares
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                stR.clear();
                for (int r=0; r<3; r++) {
                    for (int c=0; c<3; c++) {
                        int row = i*3 + r;
                        int col = j*3 + c;

                        if (board[row][col] == '.') continue;

                        if(stR.contains(board[row][col])) {
                            return false;
                        }

                        stR.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end


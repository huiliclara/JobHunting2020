/*
 * @lc app=leetcode id=467 lang=java
 *
 * [467] Unique Substrings in Wraparound String
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        int curLength = 1;
        int[] chs = new int[26];
        chs[p.charAt(0) - 'a'] = 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == p.charAt(i - 1) + 1 || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z')) {
                curLength++;
            } else {
                curLength = 1;
            }
            chs[p.charAt(i) - 'a'] = Math.max(chs[p.charAt(i) - 'a'], curLength);
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += chs[i];
        }
        return sum;
    }
}
// @lc code=end


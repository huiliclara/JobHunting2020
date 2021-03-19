/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int ret = 0;
        while(ret < strs[0].length()) {
            for (int i = 1; i < strs.length; ++i) {
                if (ret >= strs[i].length() || strs[i].charAt(ret) != strs[0].charAt(ret)) {
                    return strs[0].substring(0, ret);
                }
            }
            ++ret;
        }

        return strs[0];
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=330 lang=java
 *
 * [330] Patching Array
 */

// @lc code=start
class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int i = 0;
        int patch = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patch++;
            }
        }
        return patch;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=1799 lang=java
 *
 * [1799] Maximize Score After N Operations
 */

// @lc code=start
class Solution {
    public int maxScore(int[] nums) {
        int[][] gcds = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                gcds[i][j] = gcd(nums[i], nums[j]);
            }
        }

        // helper(1, 0, 0, nums, gcds);
        int[][] memo = new int[nums.length / 2][1 << nums.length];
        return helper(0, 0, nums, gcds, memo);
    }

    public int helper(int index, int mask, int[] nums, int[][] gcds, int[][] memo) {
        if (index == nums.length / 2) {
            return 0;
        }
        if (memo[index][mask] != 0) return memo[index][mask];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curMask = (1 << i) + (1 << j);
                if ((mask & curMask) == 0) {
                    max = Math.max(max, (index + 1) * gcds[i][j] + helper(index + 1, mask ^ curMask, nums, gcds, memo));
                }
            }
        }
        memo[index][mask] = max;
        return max;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
// @lc code=end


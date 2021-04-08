/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<Integer> subret = new Stack<>();
        dfs(0, Integer.MIN_VALUE, nums, subret, ret);

        return ret;
    }

    public void dfs(int pos, int prev, int[] nums, Stack<Integer> subret, List<List<Integer>> ret) {
        if (subret.size() > 1) {
            ret.add(new ArrayList<>(subret));
        }

        Set<Integer> seen = new HashSet<>();
        for (int i = pos; i < nums.length; i++) {
            if (prev <= nums[i] && !seen.contains(nums[i])) {
                seen.add(nums[i]);
                subret.push(nums[i]);
                dfs(i + 1, nums[i], nums, subret, ret);
                subret.pop();
            }
        }
    }
}
// @lc code=end


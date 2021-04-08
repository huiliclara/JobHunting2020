/*
 * @lc app=leetcode id=1798 lang=java
 *
 * [1798] Maximum Number of Consecutive Values You Can Make
 */

// @lc code=start
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int res = 1;
        for (int coin: coins) {
            if (coin <= res){
                res += coin;
            } else {
                break;
            }
        }
        return res;
    }
}
// @lc code=end


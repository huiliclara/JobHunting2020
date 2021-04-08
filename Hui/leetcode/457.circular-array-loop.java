/*
 * @lc app=leetcode id=457 lang=java
 *
 * [457] Circular Array Loop
 */

// @lc code=start
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        // System.out.println(-2 % 3);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = move(i, nums);
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[move(fast, nums)] > 0) {
                if (slow == fast) {
                    if (slow == move(fast, nums)) {
                        break;
                    }

                    return true;
                }

                slow = move(slow, nums);
                fast = move(move(fast, nums), nums);
            }

            slow = i;
            int val = nums[i];
            while (nums[i] * val > 0) {
                int next = move(slow, nums);
                nums[slow] = 0;
                val = nums[next];
            }
        }

        return false;
    }

    public int move(int i, int[] nums) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }
}
// @lc code=end


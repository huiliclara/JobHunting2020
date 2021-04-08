/*
 * @lc app=leetcode id=1793 lang=java
 *
 * [1793] Maximum Score of a Good Subarray
 */

// @lc code=start
class Solution {
    public int maximumScore(int[] nums, int k) {
        int[] rightSmaller = new int[nums.length];        
        int[] leftSmaller = new int[nums.length];

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (stk.size() > 0 && nums[stk.peek()] > nums[i]) {
                int j = stk.pop();
                rightSmaller[j] = i;
            }
            if (stk.size() == 0) {
                leftSmaller[i] = -1;
            } else if (nums[stk.peek()] == nums[i]) {
                leftSmaller[i] = leftSmaller[stk.peek()];
            } else {
                leftSmaller[i] = stk.peek();
            }
            stk.push(i);
        }

        while (stk.size() > 0) {
            int j = stk.pop();
            rightSmaller[j] = nums.length;
        }

        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (leftSmaller[i] < k && k < rightSmaller[i]) {
                ret = Math.max(ret, nums[i] * (rightSmaller[i] - leftSmaller[i] - 1));
            }
        }

        return ret;

    /*
        int ret = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (stk.size() > 0 && nums[stk.peek()] > nums[i]) {
                int j = stk.pop();
                int right = rightSmaller[j];
                int left = i;
                // System.out.println(left + "-" + right);
                if (left < k && k < right) {
                    ret = Math.max(ret, nums[j] * (right - left - 1));
                }
            }
            stk.push(i);
        }

        while (stk.size() > 0) {
            int j = stk.pop();
            int right = rightSmaller[j];
            int left = -1;
            // System.out.println(left + "-" + right);
            if (left < k && k < right) {
                ret = Math.max(ret, nums[j] * (right - left - 1));
            }
        }

        return ret;
        */
    }
}
// @lc code=end


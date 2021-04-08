/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return countWhileMerge(sums, lower, upper, 0, n + 1);
    }

    public int countWhileMerge(long[] sums, int lower, int upper, int start, int end) {
        if (end - start <= 1) return 0;
        int mid = start + (end - start) / 2;
        int count = countWhileMerge(sums, lower, upper, start, mid)
                  + countWhileMerge(sums, lower, upper, mid, end);
        int k = mid, j = mid, r = 0, t = mid;
        long[] temp = new long[end - start];
        for (int i = start; i < mid; i++) {
            while(k < end && sums[k] - sums[i] < lower) k++;
            while(j < end && sums[j] - sums[i] <= upper) j++;
            while(t < end && sums[t] < sums[i]) temp[r++] = sums[t++];
            temp[r++] = sums[i];
            count += j - k;
        }
        for (int i = 0; i < t - start; i++) {
            sums[start + i] = temp[i];
        }
        return count;
    }
}
// [0,-1,-2,-3,0,2]\n3\n5
// @lc code=end


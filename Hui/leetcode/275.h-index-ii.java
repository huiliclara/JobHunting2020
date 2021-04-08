/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int s = 0, e = n;
        while (s <= e) {
            int h = s + (e - s) / 2;
            int hi = n - h;
            if ((hi == n || citations[hi] >= h) && (hi == 0 || citations[hi - 1] <= h)) {
                return h;
            }

            if (hi < n && citations[hi] < h) {
                e = h - 1;
            } else {
                s = h + 1;
            }
        }

        return -1;
    }
}
// @lc code=end


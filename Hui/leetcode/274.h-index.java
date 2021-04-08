/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int c: citations) {
            if (c > n) {
                counts[n]++;
            } else {
                counts[c]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += counts[i];
            if (count >= i) {
                return i;
            }
        }
        return -1;
        // Arrays.sort(citations);
        // int s = 0, e = citations.length - 1;
        // while (s < e) {
        //     int mid = s + (e - s) / 2;
        //     int h = citations.length - mid - 1;
        //     // System.out.println(h);
        //     if (citations[mid + 1] >= h && citations[mid] <= h) {
        //         return h;
        //     }
        //     if (citations[mid + 1] <= h) {
        //         s = mid;
        //     } else {
        //         e = mid;
        //     }
        // }

        // return citations.length - s;
    }
}
// @lc code=end


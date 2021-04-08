/*
 * @lc app=leetcode id=1766 lang=java
 *
 * [1766] Tree of Coprimes
 */

// @lc code=start
class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int[][] coprimes = new int[51][51];
        for (int i = 1; i <= 50; i++) {
            for (int j = i; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    coprimes[i][j] = 1;
                    coprimes[j][i] = 1;
                }
            }
        }    

        int n = nums.length;
        List<Integer>[] child = new List[n];
        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }

        for (int[] e: edges) {
            child[e[0]].add(e[1]);
            child[e[1]].add(e[0]);
        }


        Map<Integer, int[]> visited = new HashMap<>();
        int[] ret = new int[n];
        dfs(0, 0, -1, child, visited, ret, coprimes, nums);

        return ret;
    }

    public void dfs(int d, int cur, int prev, List<Integer>[] child, Map<Integer, int[]> visited, int[] ret, int[][] coprimes, int[] nums) {
        ret[cur] = -1;
        int distance = Integer.MAX_VALUE;
        for (int cand = 1; cand <= 50; cand++) {
            if (coprimes[nums[cur]][cand] == 1 && visited.containsKey(cand)) {
                if (d - visited.get(cand)[0] < distance) {
                    distance = d - visited.get(cand)[0];
                    ret[cur] = visited.get(cand)[1];
                }
            }
        }
        int[] old = visited.getOrDefault(nums[cur], null);
        visited.put(nums[cur], new int[]{d, cur});
        for (int next: child[cur]) {
            if (next == prev) continue;
            dfs(d + 1, next, cur, child, visited, ret, coprimes, nums);
        }
        visited.remove(nums[cur]);
        if (old != null) {
            visited.put(nums[cur], old);
        }
    }
}
// @lc code=end


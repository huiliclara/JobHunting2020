/*
 * @lc app=leetcode id=391 lang=java
 *
 * [391] Perfect Rectangle
 */

// @lc code=start
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Integer> xs = new HashSet<>();
        Set<Integer> ys = new HashSet<>();
        List<Integer> xval = new ArrayList<>();
        List<Integer> yval = new ArrayList<>();

        for (int[] r: rectangles) {
            if (!xs.contains(r[0])) {
                xs.add(r[0]);
                xval.add(r[0]);
            }
            if (!ys.contains(r[1])) {
                ys.add(r[1]);
                yval.add(r[1]);
            }
            if (!xs.contains(r[2])) {
                xs.add(r[2]);
                xval.add(r[2]);
            }
            if (!ys.contains(r[3])) {
                ys.add(r[3]);
                yval.add(r[3]);
            }
        }

        Collections.sort(xval);
        Collections.sort(yval);

        Map<Integer, Integer> xi = new HashMap<>();
        Map<Integer, Integer> yi = new HashMap<>();

        for (int i = 0; i < xval.size(); i++) {
            xi.put(xval.get(i), i);
        }

        for (int i = 0; i < yval.size(); i++) {
            yi.put(yval.get(i), i);
        }
        
        boolean[][] area = new boolean[xi.size()][yi.size()];
        int count = 0;
        for (int[] r: rectangles) {
            for (int i = xi.get(r[0]); i < xi.get(r[2]); i++) {
                for (int j = yi.get(r[1]); j < yi.get(r[3]); j++) {
                    if (area[i][j]) {
                        return false;
                    }
                    area[i][j] = true;
                    count++;
                }
            }
        }

        return count == (xi.size() - 1) * (yi.size() - 1);
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> vals = new ArrayList<>();
    int maxFreq = 0;
    Map<Integer, Integer> valFreq = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        calcSubtreeSum(root);
        int[] ret = new int[vals.size()];
        for (int i = 0; i < vals.size(); i++) {
            ret[i] = vals.get(i);
        }

        return ret;
    }

    public int calcSubtreeSum(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        sum += root.val;
        sum += calcSubtreeSum(root.left);
        sum += calcSubtreeSum(root.right);
        int freq = valFreq.getOrDefault(sum, 0) + 1;
        valFreq.put(sum, freq);
        if (freq == maxFreq) {
            vals.add(sum);
        } else if (freq > maxFreq) {
            vals.clear();
            vals.add(sum);
            maxFreq = freq;
        }
        return sum;
    }
}
// @lc code=end


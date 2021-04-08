/*
 * @lc app=leetcode id=1803 lang=java
 *
 * [1803] Count Pairs With XOR in a Range
 */

// @lc code=start
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Node root = new Node();
        int ret = 0;
        for (int num: nums) {
            ret += countSmaller(root, num, high + 1) - countSmaller(root, num, low);
            insert(root, num);
        }

        return ret;
    }

    public int countSmaller(Node root, int num, int k) {
        Node cur = root;
        int countPairs = 0;
        for (int i = 14; i >= 0 && cur != null; i--) {
            int xn = (num >> i) & 1;
            int xk = (k >> i) & 1;

            if (xk == 0) {
                cur = cur.child[xn];
            } else {
                if (cur.child[xn] != null) {
                    countPairs += cur.child[xn].count;
                }
                cur = cur.child[1 - xn];
            }
        }
        return countPairs;
    }

    public void insert(Node root, int num) {
        Node cur = root;
        for (int i = 14; i >= 0; i--) {
            int x = (num >> i) & 1;
            if (cur.child[x] == null) {
                cur.child[x] = new Node();
            }
            cur = cur.child[x];
            cur.count += 1;
        }
    }

    class Node {
        Node[] child;
        int count;
        public Node() {
            child = new Node[2];
            count = 0;
        }
    }
}
// @lc code=end


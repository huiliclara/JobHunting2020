/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int n = s.length(), len = words[0].length();
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n - words.length * len + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String w = s.substring(i + len * j, i + len * (j + 1));
                if (map.containsKey(w) && seen.getOrDefault(w, 0) < map.get(w)) {
                    seen.put(w, seen.getOrDefault(w, 0) + 1);
                } else {
                    break;
                }
                j++;
            }

            if (j == words.length) {
                ret.add(i);
            }
        }

        return ret;
    }
}
// @lc code=end


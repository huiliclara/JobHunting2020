/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */

// @lc code=start
class SummaryRanges {
    TreeSet<Interval> ts;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        ts = new TreeSet<>((a, b) -> a.s - b.s);
    }
    
    public void addNum(int val) {
        Interval cur = new Interval(val, val);
        Interval hi = ts.ceiling(cur);
        if (hi != null && hi.s == val) return;
        Interval lo = ts.lower(cur);
        if (lo != null && val <= lo.e) return;

        if (hi != null && hi.s - 1 == val) {
            ts.remove(hi);
            cur.e = hi.e;
        }

        if (lo != null && lo.e + 1 == val) {
            ts.remove(lo);
            cur.s = lo.s;
        }

        ts.add(cur);
    }
    
    public int[][] getIntervals() {
        int[][] ret = new int[ts.size()][2];
        Iterator iterator = ts.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Interval cur = (Interval) iterator.next();
            ret[i++] = new int[]{cur.s, cur.e};
        }

        return ret;
    } 

    class Interval {
        int s;
        int e;
        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
// @lc code=end


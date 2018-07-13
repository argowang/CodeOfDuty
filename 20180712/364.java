/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        Queue<NestedInteger> q = new LinkedList<NestedInteger>();
        int prevsum = 0;
        int totalsum = 0;
        for (NestedInteger ni: nestedList) {
            q.offer(ni);
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            int levelsum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger curr = q.poll();
                if (curr.isInteger()) {
                    levelsum += curr.getInteger();
                } else {
                    for (NestedInteger ni: curr.getList()) {
                        q.offer(ni);
                    }
                }
            }
            prevsum += levelsum;
            totalsum += prevsum;
        }
        return totalsum;
    }
}

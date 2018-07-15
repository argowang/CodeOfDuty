class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int[] edge: edges) {
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);
            // union operation
            if (root1 != root2) {
                roots[root1] = root2;
                n--;    
            }
        }
        return n;
    }
    
    public int find(int[] roots, int id) {
        // the path hasn't been compressed
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}

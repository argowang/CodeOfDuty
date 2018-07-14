class Solution {
    private HashSet<Integer> set = new HashSet<Integer>();
    private Queue<Integer> q = new LinkedList<Integer>();
    public int findCircleNum(int[][] M) {
        int m = M.length, n = M[0].length;
        int counter = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(i)) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    if (i != j && !set.contains(j)) {
                        q.offer(j);
                    }
                    set.add(j);
                }
            }
            while (!q.isEmpty()) {
                int temp = q.poll();
                for (int j = 0; j < n; j++) {
                    if (M[temp][j] == 1) {
                        if(temp != j && !set.contains(j)) {
                            q.offer(j);
                        }
                        set.add(j);
                    }
                }
            }
            counter++;
        }
        return counter;
    }
}

class Solution2 {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                exploreAllRelatedFriend(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void exploreAllRelatedFriend(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                exploreAllRelatedFriend(M, visited, j);
            }
        }
    }
}

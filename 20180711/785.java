class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null) {
            return false;
        }

        int[] groupMark = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i]) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.offer(i);
            visited[i] = true;
            groupMark[i] = 0;
            while (!queue.isEmpty()){
                int curNode = queue.poll();
                int currentGroup = groupMark[curNode];
                int nextGroup = currentGroup == 0 ? 1 : 0;
                for (int neighbor : graph[curNode]) {
                    if (visited[neighbor]) {
                        if (groupMark[neighbor] == currentGroup) {
                            return false;
                        }
                    } else {
                        groupMark[neighbor] = nextGroup;
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }

        return true;
    }

}

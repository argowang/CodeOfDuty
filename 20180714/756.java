class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> m = new HashMap<>();
        for (String s: allowed) {
            String pre = s.substring(0, 2);
            m.putIfAbsent(pre, new HashSet<>());
            m.get(pre).add(s.charAt(2));
        }
        return bfs(bottom, "", m, 1);
    }
    
    public boolean bfs(String row, String nextRow, Map<String, Set<Character>> m, int currPos) {
        // top of pyramid
        if (row.length() == 1) {
            return true;
        }
        // nextRow is ready for explore
        if (nextRow.length() + 1 == row.length()) {
            return bfs(nextRow, "", m, 1);
        }
        
        for (Character c: m.getOrDefault(row.substring(currPos-1, currPos+1), new HashSet<>())) {
            if (bfs(row, nextRow + c, m, currPos + 1)) {
                return true;
            }
        }
        return false;
    }
}

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution1 {
    // map from employeeID to employee object
    private HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
    
    public int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees) {
            map.put(e.id, e);
        }
        Employee e = map.get(id);
        Queue<Employee> q = new LinkedList<>();
        q.offer(e);
        int importance = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                Employee tempEmployee = q.poll();
                importance += tempEmployee.importance;
                for (int subordinate: tempEmployee.subordinates) {
                    q.offer(map.get(subordinate));
                }
            }
        }
        return importance;
    }
}

class Solution2 {
    // DFS solution

    private HashMap<Integer, List<Integer>> subordinatesMap = new HashMap<Integer, List<Integer>>();
    private HashMap<Integer, Integer> importanceMap = new HashMap<Integer, Integer>();
    private int result = 0;
    public int getImportance(List<Employee> employees, int id) {

        // create map for O(1) lookup
        for (Employee e: employees) {
            subordinatesMap.put(e.id, e.subordinates);
            importanceMap.put(e.id, e.importance);
        }
        dfs(id);
        return result;
    }

    public void dfs(int id) {
        result += importanceMap.get(id);

        // run dfs on its subordinates
        if (subordinatesMap.containsKey(id)) {
            for (int sub: subordinatesMap.get(id)) {
                dfs(sub);
            }
        }
    }
}

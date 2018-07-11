class Solution {
    public HashSet<Integer> visited = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        enterRooms(0, rooms);
        return visited.size() == rooms.size();
    }
    
    public void enterRooms(int room, List<List<Integer>> rooms) {
        visited.add(room);
        for (int nextRoom: rooms.get(room)) {
            if (!visited.contains(nextRoom)) {
                enterRooms(nextRoom, rooms);
            }
        }
    }
}


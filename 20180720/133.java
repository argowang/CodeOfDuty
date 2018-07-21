/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(cloneNode.label, cloneNode);
        for (UndirectedGraphNode n: node.neighbors) {
            cloneNode.neighbors.add(clone(n, map));
        }
        return cloneNode;
    }
}

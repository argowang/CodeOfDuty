# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []
# DFS solution
class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node:
            return node
        future = [node]
        root = UndirectedGraphNode(node.label)
        # Use visit to store the node in the graph
        visit = {node.label: root} 
        while future:
            cur = future.pop()
            for neighbor in cur.neighbors:
                if neighbor.label not in visit:
                    future.append(neighbor)
                    # Rememeber to add to visit
                    visit[neighbor.label] = UndirectedGraphNode(neighbor.label)
                visit[cur.label].neighbors.append(visit[neighbor.label])
        return root
            
 
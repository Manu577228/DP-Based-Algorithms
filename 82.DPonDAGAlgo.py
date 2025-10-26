# DP on DAG is a technique that combines Dynamic Programming and Topological Sorting 
# to efficiently find the longest (or shortest) path in a Directed Acyclic Graph.
# Since DAGs have no cycles, we can process nodes in topological order to compute DP values in one pass.

# Explanation

# Dynamic Programming on DAGs is based on these key ideas:

# No cycles mean we can order vertices so that all edges go from earlier to later in that order (topological order).

# For each node u, we compute a DP value that depends on the DP values of all its predecessors.

# This allows us to propagate optimal substructure results efficiently across the graph.

# The typical recurrence for the longest path is:

# dp[v]=max(dp[v],dp[u]+weight(u,v)) for every edge (u → v).

# Example Problem:

# Find the longest path in a Directed Acyclic Graph (DAG).

# 6 vertices (0 to 5)

# Edges:
# 0 → 1
# 0 → 2
# 1 → 3
# 2 → 3
# 2 → 4
# 3 → 5
# 4 → 5

from collections import defaultdict, deque

graph = defaultdict(list)
edges = [(0, 1), (0, 2), (1, 3), (2, 3), (2, 4), (3, 5), (4, 5)]
for u, v in edges:
    graph[u].append(v)

in_degree = [0] * 6
for u, v in edges:
    in_degree[v] += 1

q = deque()
for i in range(6):
    if in_degree[i] == 0:
        q.append(i)

topo_order = []
while q:
    node = q.popleft()
    topo_order.append(node)
    for nei in graph[node]:
        in_degree[nei] -= 1
        if in_degree[nei] == 0:
            q.append(nei)

dp = [-1e9] * 6
for start in topo_order:
    if dp[start] == -1e9:
        dp[start] = 0
    for nei in graph[start]:
        dp[nei] = max(dp[nei], dp[start] + 1)

print("Topological order:", topo_order)
print("Longest Path Length from each node:", dp)
print("Overall Longest path Lengths:", max(dp))



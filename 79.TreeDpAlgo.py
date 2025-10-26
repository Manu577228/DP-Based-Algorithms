# Tree DP (dynamic programming on trees) is a technique that computes answers for tree problems
# by combining solutions of children to form the parent's solution. It commonly uses DFS (post-order) 
# to compute state values (e.g., include / exclude a node) for each node. This avoids recomputation 
# and exploits tree structure.

# Explanation

# A common pattern in Tree DP is to maintain multiple DP states per node that represent different
# constraints (for example: whether the node is chosen or not). We process the tree in 
# post-order (children first), compute DP states for every child, and then combine them to c
# ompute the parent’s states. This is especially useful for problems like the Maximum Weight Independent 
# Set on a tree, tree vertex cover, subtree sums, or longest path computations.

import sys
sys.setrecursionlimit(10**6)

values = [3, 2, 1, 1, 5, 4, 6]
n = len(values)

adj = [[] for _ in range(n)]
edges = [(0, 1), (0, 2), (1, 3), (1, 4), (2, 5), (2, 6)]
for u, v in edges:
    adj[u].append(v)
    adj[v].append(u)

dp_include = [0] * n
dp_exclude = [0] * n

def dfs(u, parent):
    include_sum = values[u]
    exclude_sum = 0

    for v in adj[u]:
        if v == parent:
            continue
        dfs(v, u)
        include_sum += dp_exclude[v]
        exclude_sum += max(dp_include[v], dp_exclude[v])

    dp_include[u] = include_sum
    dp_exclude[u] = exclude_sum

dfs(0, -1)

answer = max(dp_include[0], dp_exclude[0])

print("Node : weight | dp_include | dp_exclude")
for i in range(n):
    print(f"{i:4d} : {values[i]:6d} | {dp_include[i]:10d} | {dp_exclude[i]:10d}")

print("\nMaximum Weight of independent set on this tree:", answer)



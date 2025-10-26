# Bitmask DP is useful when the number of elements 
# 𝑛 is small (typically ≤ 20), because we can represent every subset as a binary number of 
# n bits. Each bit in the mask represents whether a particular element is 
# included in the subset (1) or not (0).

# For example:

# For n = 3, the subset {1, 3} can be represented as 101 in binary, which is 5 in decimal.

# This allows us to store DP states efficiently: dp[mask] can store the answer for subset mask.

# Typical problems solved with Bitmask DP:

# Traveling Salesman Problem (TSP)

# Assignment problems (e.g., assigning tasks to workers)

# Subset sum with extra conditions

# The key is transitioning from one mask to another by adding an element and updating the DP state.

# Example Problem

# Problem: Assign n tasks to n people with minimum cost. Each person can do each task 
# at a certain cost. Find the minimum total cost.

n = 3
cost = [
    [9, 2, 7],
    [6, 4, 3],
    [5, 8, 1]
]

dp = [float('inf')] * (1 << n)
dp[0] = 0

for mask in range(1 << n):
    x = bin(mask).count('1')

    for j in range(n):
        if not (mask & (1 << j)): 
            dp[mask | (1 << j)] = min(dp[mask | (1 << j)], dp[mask] + cost[x][j])

print(dp[(1 << n) - 1])


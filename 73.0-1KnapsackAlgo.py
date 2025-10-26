# The 0/1 Knapsack problem is a classic dynamic programming problem 
# where we are given a set of items, each with a weight and value, and a 
# knapsack with a maximum weight capacity. The goal is to maximize the total 
# value of items placed in the knapsack without exceeding its weight. 
# Each item can be either taken or left (0 or 1).

# Explanation

# We have n items, each with a value[i] and weight[i].

# The knapsack can carry a maximum weight W.

# The key idea is to decide for each item: include it or exclude it.

# We use dynamic programming to avoid recalculating the same subproblems.

# We define a 2D DP table dp[i][w] where:

# i represents the first i items

# w represents the current weight capacity

# dp[i][w] stores the maximum value achievable with i items and weight w.

# The recurrence relation:

# If weight of current item weight[i-1] <= w:
# dp[i][w] = max(dp[i-1][w], value[i-1] + dp[i-1][w - weight[i-1]])

# Otherwise:
# dp[i][w] = dp[i-1][w]

values = [60, 100, 120]
weights = [10, 20, 30]

W = 50

n = len(values)

dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]

for i in range(1, n + 1):
    for w in range(1, W + 1):
        if weights[i - 1] <= w:
            dp[i][w] = max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]])
        else:
            dp[i][w] = dp[i - 1][w]

print("Maximum value in the Knapsack =", dp[n][W])


# The Subset Sum Problem is a classic Dynamic Programming problem.
# It asks whether there exists a subset of a given set of integers that adds up to a specific target sum.
# It forms the foundation of the Partition Problem, where we check if an array can be 
# divided into two subsets with equal sums.

# Explanation

# We are given an array arr[] of size n and a sum target.

# Our goal is to determine if any subset of the array sums to target.

# It can be solved using Dynamic Programming (DP) where:

# We use a 2D boolean table dp[n+1][target+1].

# dp[i][j] = True means we can form sum j using the first i elements.

# Transition logic:

# If current element arr[i-1] > j: we can’t include it → dp[i][j] = dp[i-1][j]

# Otherwise → dp[i][j] = dp[i-1][j] or dp[i-1][j-arr[i-1]]

# Base conditions:

# dp[0][0] = True → empty subset can make sum 0

# dp[i][0] = True for all i → sum 0 is always possible

# dp[0][j] = False for j > 0 → can’t form positive sum with 0 elements

def isSubsetSum(arr, target):
    n = len(arr)

    dp = [[False] * (target + 1) for _ in range(n + 1)]
    for i in range(n + 1):
        dp[i][0] = True

    for i in range(1, n + 1):
        for j in range(1, target + 1):
            if arr[i - 1] <= j:
                dp[i][j] = dp[i - 1][j - arr[i - 1]] or dp[i - 1][j]
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[n][target]

arr = [3, 34, 4, 12, 5, 2]
target = 9

result = isSubsetSum(arr, target)
print("Is Subset with given sum possible:", result)




# When multiplying multiple matrices, the order of multiplication affects the total computations. 
# For matrices A, B, C, (A*B)*C may require fewer operations than A*(B*C). 
# MCM uses dynamic programming to explore all parenthesizations efficiently without recalculating 
# overlapping subproblems.

# Steps:

# Let matrices be A1, A2, ..., An with dimensions stored in array dims where 
# dims[i-1] x dims[i] is the dimension of Ai.

# Define dp[i][j] as the minimum number of multiplications needed to 
# compute the product of matrices from i to j.

# Recurrence relation:

# dp[i][j] = min(dp[i][k] + dp[k+1][j] + dims[i-1]*dims[k]*dims[j]) 
#            for all i ≤ k < j


# Base case: dp[i][i] = 0 (single matrix needs no multiplication).

# Fill the table bottom-up and return dp[1][n].

def matrix_chain_order(dims):
    n = len(dims)
    dp = [[0] * n for _ in range(n)]

    for l in range(2, n):
        for i in range(1, n - l + 1):
            j = i + l - 1
            dp[i][j] = float('inf')
            for k in range(i, j):
                q = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j]
                if q < dp[i][j]:
                    dp[i][j] = q

    return dp[1][n - 1]

dims = [10, 20, 30, 40, 30] 
min_cost = matrix_chain_order(dims)
print("Minimum number of multiplications:", min_cost)
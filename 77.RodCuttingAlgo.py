# The Rod Cutting Algorithm is a classic Dynamic Programming problem 
# that aims to determine the maximum profit obtainable by cutting a rod into smaller pieces 
# and selling them based on given prices for each length.
# It’s similar to the Unbounded Knapsack Problem, where we can take multiple instances of 
# the same piece length.

# Explanation

# You are given:

# A rod of length n.

# A price list price[i] which gives the price of a rod of length i + 1.

# You can cut the rod into smaller parts or leave it uncut.
# The goal is to maximize total value.

def rod_cutting(prices, n):
    dp = [0] * (n + 1)

    for i in range(1, n + 1):
        max_val = float('-inf')

        for j in range(i):
           max_val = max(max_val, prices[j] + dp[i - j - 1])

        dp[i] = max_val

    return dp[n]

prices = [2, 5, 7, 8] 
n = 4  

max_profit = rod_cutting(prices, n)

print("Maximum Obtainable Profit:", max_profit)
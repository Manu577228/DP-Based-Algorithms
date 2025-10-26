# Unbounded Knapsack: Given n item types each with a weight and value, 
# and a knapsack capacity W, choose items (each item may be chosen unlimited times) 
# so the total weight ≤ W and total value is maximized.
# This is typically solved with dynamic programming (bottom-up) in O(n * W) time.

# Explanation

# Unlike 0/1 Knapsack where each item can be taken at most once, in Unbounded Knapsack 
# you can take any item multiple times.

# Let dp[w] be the maximum value achievable with capacity exactly w. Base: dp[0] = 0.

# For each capacity w from 1 to W, try every item i with weight wt[i]. If wt[i] <= w, 
# candidate value = dp[w - wt[i]] + val[i]. Set dp[w] = max(dp[w], candidate).

# This 1D bottom-up DP naturally allows reusing items because when computing dp[w] you may use 
# dp[w - wt] which itself may include item i already.

# Optionally store a keep[w] array to reconstruct which item was chosen last for capacity w.

weights = [2, 3, 4]
values = [15, 20, 30]
W = 7;
n = len(weights)

dp = [0] * (W + 1)

keep = [-1] * (W + 1)

for w in range(1, W + 1):
    for i in range(n):
        wt = weights[i]
        val = values[i]
        if wt <= w:
            candidate = dp[w - wt] + val
            if candidate > dp[w]:
                dp[w] = candidate
                keep[w] = i

print("maximum Value:", dp[W])

res_items = []
cap = W
while cap > 0 and keep[cap] != -1:
    idx = keep[cap]
    res_items.append(idx)
    cap -= weights[idx]

res_pairs = [(weights[i], values[i]) for i in res_items]
print("chosen items (weight, value) in selection order:", res_pairs)

print("DP table (capacity -> max value):")
for i in range(W + 1):
    print(i, "->", dp[i])


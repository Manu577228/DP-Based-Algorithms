# Digit DP (Digit Dynamic Programming) is a dynamic programming technique used to count or 
# calculate values 
# over numbers within a range by processing their digits.
# It helps solve problems like "count numbers less than N that satisfy a certain property" — 
# efficiently, without iterating through every number.

# Explanation

# When you deal with problems like:

# “Count how many numbers between 1 and N have a certain property (like having no repeated digits, having a sum of digits less than K, etc.)”

# — you could naïvely check every number up to N. But that’s too slow for large N (up to 10^18)

# Digit DP works by breaking the number into digits and using DP to remember results based on:

# Position (current digit we’re processing),

# Tight Constraint (whether the current prefix is still equal to the prefix of N),

# Other State Parameters (like sum of digits, previous digit, etc.).

# Example Problem

# Count how many numbers from 0 to N have the sum of digits ≤ K.

# We’ll implement this with Digit DP.

def count_numbers_with_sum_limit(n, k):
    digits = list(map(int, str(n)))
    dp = {}

    def dfs(pos, tight, curr_sum):
        if pos == len(digits):
            return 1 if curr_sum <= k else 0
        
        key = (pos, tight, curr_sum)
        if key in dp:
            return dp[key]
        
        limit = digits[pos] if tight == 1 else 9
        total = 0

        for d in range(0, limit + 1):
            new_tight = 1 if (tight == 1 and d == limit) else 0
            total += dfs(pos + 1, new_tight, curr_sum + d)

        dp[key] = total
        return total
    
    return dfs(0, 1, 0)

N = 123
K = 5
print(count_numbers_with_sum_limit(N, K))

# [0, 1, 2, 3, 4, 5, 10, 11, 12, 13, 14, 20, 21, 22, 23, 30, 31, 32, 40, 41, 50, 100, 101, 102, 103, 104, 110, 111, 112, 113, 120, 121, 122]




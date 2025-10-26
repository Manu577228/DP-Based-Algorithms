# The Longest Common Subsequence (LCS) between two sequences is the longest sequence that 
# appears (not necessarily contiguously) in both.
# LCS is typically solved with dynamic programming in O(n*m) time 
# (where n and m are the lengths of the two strings) and O(n*m) space.

# Explanation

# We build a 2D DP table dp where dp[i][j] is the length of the LCS of the prefixes A[:i] and B[:j].
# Recurrence:

# If A[i-1] == B[j-1]: dp[i][j] = dp[i-1][j-1] + 1 (take that matched char)

# Else: dp[i][j] = max(dp[i-1][j], dp[i][j-1]) (skip one char from A or B)
# After filling the table, we can reconstruct one LCS by tracing back from dp[n][m] to dp[0][0].

def lcs(A, B):
    n = len(A)
    m = len(B)
    dp = [[0] * (m + 1) for _ in range(n + 1)]

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if A[i - 1] == B[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                if dp[i - 1][j] >= dp[i][j - 1]:
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i][j - 1]

    lcs_chars = []
    i, j = n, m
    while i > 0 and j > 0:
        if A[i - 1] == B[j - 1]:
            lcs_chars.append(A[i - 1])
            i -= 1
            j -= 1
        else:
            if dp[i - 1][j] >= dp[i][j - 1]:
                i -= 1
            else:
                j -= 1

    lcs_string = ''.join(reversed(lcs_chars))
    return dp[n][m], lcs_string

if __name__ == "__main__":
    A = "AGGTAB"                     
    B = "GXTXAYB"                    
    length, seq = lcs(A, B)         
    print("String A:", A)             
    print("String B:", B)            
    print("LCS length:", length)      
    print("An LCS:", seq)             

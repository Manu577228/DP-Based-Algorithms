# Bell Numbers represent the number of ways to partition a set of n elements into non-empty subsets.

# Catalan Numbers count the number of ways to correctly match parentheses, binary tree structures, 
# or non-crossing partitions.

# Explanation

# Bell Numbers (Bₙ)

# For example, B₃ = 5 because {1,2,3} can be partitioned as
# { {1,2,3}, {1,2},{3}, {1,3},{2}, {2,3},{1}, {1},{2},{3} } — total 5 partitions.

# They can be computed using Bell Triangle or Dynamic Programming:

# Bell(n+1, 0) = Bell(n, n)
# Bell(n+1, k) = Bell(n, k-1) + Bell(n, k)


# Catalan Numbers (Cₙ)

# They appear in combinatorics involving recursive structures:

# Number of valid parentheses expressions

# Number of full binary trees

# Number of ways to triangulate polygons

# Formula:

# C₀ = 1
# Cₙ₊₁ = Σ (Cᵢ * Cₙ₋ᵢ) for i = 0 to n


# Or using binomial coefficients:

# Cₙ = (1 / (n+1)) * (2n choose n)

def bell_number(n):
    bell = [[0 for i in range(n + 1)] for j in range(n + 1)]
    bell[0][0] = 1

    for i in range(1, n + 1):
        bell[i][0] = bell[i - 1][i - 1]
        for j in range(1, i + 1):
            bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1]

    return bell[n][0]

def catalan_number(n):
    catalan = [0] * (n + 1)
    catalan[0] = 1

    for i in range(1, n + 1):
        for j in range(i):
            catalan[i] += catalan[j] * catalan[i - j - 1]

    return catalan[n]

n = 5
print("Bell Number for n = ", n, "is:", bell_number(n))
print("Catalan Number for n = ", n, "is:", catalan_number(n))


/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JS/JAVA CodeBuff )
 ___ _                      _              _ 
 | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)
 | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |
 |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |
                                        |__/ 
 */
/* --------------------------------------------------------------------------   */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                        */
/*    Github : https://github.com/Manu577228                                  */
/* -----------------------------------------------------------------------  */

public class MatrixChainMultiplication {

    // Function to find minimum multiplication cost
    public static int matrixChainOrder(int[] dims) {
        int n = dims.length; // Number of matrices + 1
        int[][] dp = new int[n][n]; // DP table initialization with 0

        // l is the chain length
        for (int l = 2; l < n; l++) { // Start from length 2 (at least two matrices)
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE; // Initialize with infinity
                for (int k = i; k < j; k++) {
                    // Calculate cost of splitting at k
                    int q = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q; // Update with minimum cost
                    }
                }
            }
        }

        return dp[1][n - 1]; // Minimum cost to multiply matrices 1 to n-1
    }

    public static void main(String[] args) {
        int[] dims = {10, 20, 30, 40, 30}; // Matrices: 10x20, 20x30, 30x40, 40x30
        int minCost = matrixChainOrder(dims);
        System.out.println("Minimum number of multiplications: " + minCost);
    }
}

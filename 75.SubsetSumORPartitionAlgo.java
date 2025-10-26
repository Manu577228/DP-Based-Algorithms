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

public class SubsetSum {

    // Function to check if a subset with given sum exists
    public static boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;

        // Step 1: Create DP table
        boolean[][] dp = new boolean[n + 1][target + 1];

        // Step 2: Base Case - Sum 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Step 3: Fill the DP table
        for (int i = 1; i <= n; i++) { // loop through elements
            for (int j = 1; j <= target; j++) { // loop through target sums
                if (arr[i - 1] <= j) {
                    // Either include current element or exclude it
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    // Can't include current element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Step 4: Answer is in dp[n][target]
        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;

        boolean result = isSubsetSum(arr, target);
        System.out.println("Is Subset with given sum possible?: " + result);
    }
}

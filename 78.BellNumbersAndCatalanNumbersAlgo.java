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
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio        */
/* -----------------------------------------------------------------------  */
/*    Online Compiler (Java): https://onecompiler.com/java                     */
/*    Online Compiler (JS)  : https://onecompiler.com/javascript               */
/*    Code Formatter (TP)   : https://www.tutorialspoint.com/online_java_formatter.htm */
/* -----------------------------------------------------------------------  */

import java.util.*;

public class Main {

    // Function to compute Bell Numbers using Bell Triangle
    public static int bellNumber(int n) {
        int[][] bell = new int[n + 1][n + 1];
        bell[0][0] = 1;  // Base case: Bell(0) = 1

        for (int i = 1; i <= n; i++) {          // For each row
            bell[i][0] = bell[i - 1][i - 1];    // First value in the row
            for (int j = 1; j <= i; j++) {      // Fill remaining values
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
            }
        }

        return bell[n][0]; // First element in nth row = Bell number
    }

    // Function to compute Catalan Numbers using DP
    public static int catalanNumber(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = 1;  // Base case: C0 = 1

        for (int i = 1; i <= n; i++) {          // Compute each Catalan number
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan[n];  // Return nth Catalan number
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Bell Number for n = " + n + " is: " + bellNumber(n));
        System.out.println("Catalan Number for n = " + n + " is: " + catalanNumber(n));
    }
}
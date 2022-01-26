package AmazonOA;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class Diff_min_max_in_subarray {
    public static int sumSubarrayMaxs(int[] A) {

        int res = A[0], n = A.length, M = (int)(1e9 + 7);
        int[] dp = new int[n];
        dp[0] = A[0];
        for (int i = 1; i < n; ++i) {
            if (A[i] < A[i - 1]) dp[i] = dp[i - 1] + A[i];
            else {
                int j = i - 1;
                while (j >= 0 && A[i] >= A[j]) --j;
                dp[i] = (j < 0) ? (i + 1) * A[i] : (dp[j] + (i - j) * A[i]);
            }
            res = (res + dp[i]) % M;
        }
        return res;

    }

    public static int sumSubarrayMins(int[] A) {

        int res = A[0], n = A.length, M = (int)(1e9 + 7);
        int[] dp = new int[n];
        dp[0] = A[0];
        for (int i = 1; i < n; ++i) {
            if (A[i] >= A[i - 1]) dp[i] = dp[i - 1] + A[i];
            else {
                int j = i - 1;
                while (j >= 0 && A[i] < A[j]) --j;
                dp[i] = (j < 0) ? (i + 1) * A[i] : (dp[j] + (i - j) * A[i]);
            }
            res = (res + dp[i]) % M;
        }
        return res;
    }
    public static void main(String[] args) {
        // Example 1


        // Example 2
        int arr[] = new int[]{2,4,3,5};

        System.out.println(sumSubarrayMins(arr));
        System.out.println(sumSubarrayMaxs(arr));
    }
}

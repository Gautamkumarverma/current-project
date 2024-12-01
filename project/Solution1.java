import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public static int fibo(int n, int f[]) {
        if (n == 0 || n == 1) {
            return f[n] = n;
        }
        if (f[n] != -1) {
            return f[n];
        }
        return f[n] = fibo(n - 1, f) + fibo(n - 2, f);
    }

    public static int fibotabu(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int k(int capacity, int val[], int wt[], int i, int n) {
        if (i >= n || capacity == 0) {
            return 0;
        }
        int take = 0;
        int notTake = 0;
        if (capacity - wt[i] >= 0) {
            take = val[i] + k(capacity - wt[i], val, wt, i + 1, n);
        }
        notTake = k(capacity, val, wt, i + 1, n);
        System.out.println(Math.max(take, notTake));
        return Math.max(take, notTake);
    }

    public static int k1(int capacity, int val[], int wt[], int indx, int dp[][]) {
        if (indx <= 0 || capacity == 0) {
            return 0;
        }
        if (dp[indx - 1][capacity] != -1) {
            return dp[indx - 1][capacity];
        }
        int take = 0;
        int notTake = 0;
        if (capacity - wt[indx - 1] >= 0) {
            take = val[indx - 1] + k1(capacity - wt[indx - 1], val, wt, indx - 1, dp);
        }
        notTake = k1(capacity, val, wt, indx - 1, dp);
        dp[indx - 1][capacity] = Math.max(take, notTake);
        return Math.max(take, notTake);

    }

    static int ans = Integer.MIN_VALUE;

    public static int lCommonSubString(String s1, int i, String s2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2) {
            int p = 1 + lCommonSubString(s1, i - 1, s2, j - 1);
            ans = Math.max(ans, p);
            return p;

        } else {
            int left = lCommonSubString(s1, i - 1, s2, j);
            int right = lCommonSubString(s1, i, s2, j - 1);
            ans = Math.max(ans, Math.max(left, right));
            return 0;
        }
    }

    public static int catalansNumber(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += catalansNumber(i, dp) * catalansNumber(n - i - 1, dp);
        }
        return dp[n] = ans;

    }

    static int mod = 1000000007;

    public static int mountainRanges(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (mountainRanges(i) * mountainRanges(n - i - 1)) % mod) % mod;
        }
        return ans;
    }

    // TC ->O(n*n)
    public static int mountainRanges_tabu(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];

                dp[i] = (dp[i] + (inside * outside) % mod) % mod;
            }

        }
        return dp[n];
    }

    public static int miniumPartition(int nums[], int i, int sum) {
        if (i == 1) {
            return nums[i - 1];
        }
        int take = 0;
        if (sum >= nums[i - 1]) {
            take = nums[i - 1] + miniumPartition(nums, i - 1, sum - nums[i - 1]);
        }
        int notTake = miniumPartition(nums, i - 1, sum);
        return Math.max(take, notTake);
    }

    public static int minimumJump(int nums[], int i, int steps) {
        if (i == nums.length - 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= steps; j++) {
            if (j + i < nums.length) {
                int p = 1 + minimumJump(nums, i + j, nums[i + j]);
                ans = Math.min(ans, p);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int n = 5;
        // int f[] = new int[n + 1];
        // Arrays.fill(f, -1);
        // System.out.println(fibotabu(6));

        // code here
        // int val[] = { 1, 2, 3 };
        // int wt[] = { 4, 5, 1 };
        // int n = val.length;
        // int capacity = 3;
        // int dp[][] = new int[n][capacity + 1];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j <= capacity; j++) {
        // dp[i][j] = -1;
        // }
        // }

        // System.out.println(k1(capacity, val, wt, n, dp));
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j <= capacity; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        // String s1 = "ABCDGH";
        // String s2 = "ACDGHR";
        // lCommonSubString(s1, s1.length()-1, s2, s2.length()-1);
        // System.out.println(ans);

        // catalan number
        // System.out.println(catalansNumber(5));

        // cat memo
        // int n = 5;
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(catalansNumber(n, dp));

        // mountainRanges
        // System.out.println(mountainRanges_tabu(3));

        // int nums[] = { 1 };
        // int sum = 0;
        // for (int el : nums) {
        // sum += el;
        // }
        // int left = 0;
        // int right = 0;
        // System.out.println(sum);
        // if (sum % 2 == 0) {
        // left = sum / 2;
        // right = sum / 2;
        // } else {
        // left = sum / 2 + 1;
        // right = sum / 2;
        // }
        // System.out.println("left" + left);
        // int res = miniumPartition(nums, nums.length, left);
        // System.out.println("res ->" + res);
        // right += (left - res);
        // System.out.println(Math.abs(right - res));

        // minimum jump
        int nums[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println(minimumJump(nums, 0, nums[0]));

    }
}
import java.util.Arrays;

public class LcsType {
    public static int LCSubsequence(String s1, String s2, int indx1, int indx2) {
        if (indx1 == s1.length() || indx2 == s2.length()) {
            return 0;
        }
        char ch1 = s1.charAt(indx1);
        char ch2 = s2.charAt(indx2);
        if (ch1 == ch2) {
            return 1 + LCSubsequence(s1, s2, indx1 + 1, indx2 + 1);
        } else {
            int left = LCSubsequence(s1, s2, indx1 + 1, indx2);
            int right = LCSubsequence(s1, s2, indx1, indx2 + 1);
            return Math.max(left, right);
        }

    }

    static int ans = Integer.MAX_VALUE;

    public static int coin_memo(int coins[], int indx, int amount, int dp[][]) {
        if (amount == 0) {
            return 0;
        }
        if (indx < 0) {
            return 0;
        }
        if (dp[indx][amount] != -1) {
            return dp[indx][amount];
        }
        int take = 0;
        int nottake = 0;
        if (amount - coins[indx] >= 0) {
            take = 1 + coin_memo(coins, indx, amount - coins[indx], dp);
        }
        nottake = coin_memo(coins, indx - 1, amount, dp);
        if (nottake == 0 || take == 0) {
            return dp[indx][amount] = Math.max(take, nottake);
        } else {

            return dp[indx][amount] = Math.min(take, nottake);
        }

    }

    public static void main(String[] args) {
        // String s1 = "abca";
        // String s2 = "acba";

        // System.out.println(LCSubsequence(s1, s2, 0, 0));
        int coins[] = { 1, 2, 5 }, amount = 11;
        int n = coins.length;
        // if (coins.length == 1) {
        // if (amount / coins[0] == 0) {
        // System.out.println(amount / coins[0]);
        // } else {
        // System.out.println(-1);
        // }
        // }
        int dp[][] = new int[n][amount + 1];
        for (int d1[] : dp) {
            Arrays.fill(d1, -1);
        }

        System.out.println(coin(coins, coins.length - 1, amount, dp));
        System.out.println();
        for (int d1[] : dp) {
            for (int el : d1) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}

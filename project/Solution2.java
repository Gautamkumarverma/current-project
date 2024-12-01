import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static List<String> validparan(int n) {
        if (n == 1) {
            List<String> list = new LinkedList<String>();
            list.add("()");
            return list;
        }
        List<String> prev = validparan(n - 1);
        List<String> list = new LinkedList<String>();
        System.out.println(prev.size() + " " + n);
        for (String s : prev) {

            if (list.contains("()" + s) == false) {
                list.add("()" + s);
            }
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {

                    sb.insert(i + 1, "()");
                    String result = sb.toString();
                    if (list.contains(result) == false) {
                        list.add(result);
                    }
                    sb = new StringBuilder(s);
                }
            }

        }

        return list;
    }

    public static List<String> validparan(int n, List<String>[] dp) {
        if (n == 1) {
            List<String> list = new LinkedList<String>();
            list.add("()");
            return list;
        }
        if (dp[n].size() != 0) {
            return dp[n];
        }
        List<String> prev = validparan(n - 1, dp);
        List<String> list = new LinkedList<String>();
        System.out.println(prev.size() + " " + n);
        for (String s : prev) {

            if (list.contains("()" + s) == false) {
                list.add("()" + s);
            }
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {

                    sb.insert(i + 1, "()");
                    String result = sb.toString();
                    if (list.contains(result) == false) {
                        list.add(result);
                    }
                    sb = new StringBuilder(s);
                }
            }

        }

        return dp[n] = list;
    }

    public static void stockSell(int cost[]) {
        int n = cost.length;
        int mini = cost[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (mini < cost[i]) {
                profit = Math.max(profit, cost[i] - mini);
            } else {
                mini = cost[i];
            }
        }
        System.out.println(profit);
    }

    public static void stockSellProblem(int cost[]) {
        int n = cost.length;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int mini = 0;
        int profit = 0;
        for (int i = 1; i < n; i++) {

            if (cost[mini] < cost[i]) {
                ArrayList<Integer> t = new ArrayList<>();
                t.add(mini);
                t.add(i);
                for (int j = 0; j < ans.size(); j++) {
                    if (ans.get(j).get(0) == mini) {
                        ans.remove(j);
                    }
                }
                ans.add(t);

            } else {
                mini = i;
            }

        }

        for (ArrayList<Integer> p : ans) {
            System.out.println(p);
        }

    }

    public static boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();

        k = n / k;
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0, j = i + k; i <= n - k;) {
            String subSt = s.substring(i, j);
            list.add(subSt);
            System.out.println(subSt);
            i = i + k;
            j = i + k;
        }
        return false;
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int fre = 0;
        for (int i = 0; i < n - 1;) {
            if (numOperations > 0 && nums[i + 1] - nums[i] <= k) {
                fre++;
                numOperations--;
                i++;
            } else if (numOperations > 0 && nums[i + 1] - nums[i] > k) {

                for (int j = 1; j <= numOperations; j++) {
                    int t = nums[i] + k * j;
                    if (nums[i + 1] - t <= k) {
                        numOperations -= j;
                        fre++;
                        break;
                    }
                }
                i++;

            } else {
                if (i < n - 1 && numOperations == 0 && nums[i + 1] == nums[i]) {
                    fre++;

                }
                i++;
            }
            System.out.println("ppp");
        }
        return fre + 1;
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    list.add(i * m + j);
                    System.out.print(i * m + j + " ");
                }
            }
        }
        System.out.println();
        int p = list.size();
        for (int i = 0; i < p; i++) {
            int num = list.get(i);
            int row = num / m;
            int col = num % m;
            for (int k = 0; k < m; k++) {
                matrix[k][col] = 0;
            }
            for (int k = 0; k < n; k++) {
                matrix[row][k] = 0;
            }
            break;

        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int n = 4;
        // List<String> ans = validparan(n);
        // System.out.println(ans.size());
        // for (String s : ans) {
        // System.out.println(s);
        // }
        // @SuppressWarnings("unchecked")
        // List<String>[] dp = new LinkedList[n + 1];
        // for (int i = 0; i <= n; i++) {
        // dp[i] = new LinkedList<String>();
        // }
        // List<String> ans = validparan(n, dp);
        // System.out.println(ans.size());
        // for (String s : ans) {
        // System.out.println(s);
        // }

        // stock ans sell

        // int cost[] = { 100, 180, 260, 310, 40, 535, 695 };
        // // stockSell(cost);
        // stockSellProblem(cost);

        // String s = "aabbcc", t = "bbaacc";
        // int k = 3;
        // isPossibleToRearrange(s, t, k);
        // int nums[] = { 1, 4, 5 };
        // int k = 1;
        // int op = 2;
        // System.out.println(maxFrequency(nums, k, op));

        // fill 0
        int nums[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroes(nums);
        System.out.println(0 % 3);
    }
}
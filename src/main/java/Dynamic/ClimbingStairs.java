package Dynamic;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    /**
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

package Dynamic;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

//        int[] coins = {9, 9};
//        int amount = 0;

        int[] coins = {5, 2, 1};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }

    /**
     * @param coins:  a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

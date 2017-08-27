package org.vamsu.interview.solutions.dp;

import java.util.*;

public class MakeChange {
    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0);
    }

    public static long makeChange(int[] coins, int money, int index) {
        if (money < 0) {
            return 0;
        }
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        return makeChange(coins, money - coins[index], index) +
                makeChange(coins, money, index + 1);
    }

    public static long makeChangeDP(int[] coins, int money) {
        int[] ways = new int[money + 1];
        ways[0] = 1;

        for (int coin : coins) {
            for (int amount = 0; amount <= money; amount++) {
                if (amount >= coin) {
                    ways[amount] += ways[amount - coin];
                }
            }
        }
        return ways[money];
    }

    public static void main(String[] args) {
        int coins[] = {6, 5, 3, 2};
        System.out.println(makeChange(coins, 10));
        System.out.println(makeChangeDP(coins, 10));
    }
}

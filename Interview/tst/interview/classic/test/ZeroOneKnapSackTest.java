package interview.classic.test;

import interview.classic.ZeroOneKnapSack;

import org.junit.Test;

public class ZeroOneKnapSackTest
{

	@Test
	public void test()
	{
		int N = 5;
		int W = 10;

		int[] profit = new int[N];
		int[] weight = new int[N];

		// generate random instance, items 1..N
		for (int n = 0; n < N; n++)
		{
			profit[n] = (int) (Math.random() * 100);
			weight[n] = (int) (Math.random() * W);
			System.out.println("profit[" + n+1 + "]: " + profit[n] + "\t"
					+ "weight[" + n + "]: " + weight[n]);
		}

		System.out.println("\nMy solution: ");
		ZeroOneKnapSack.showBestComb(profit, weight, W);
		System.out.println("Standard solution: ");
		Knapsack.zeroOneKnapsack(profit, weight, W);
	}
	
	@Test
	public void test2()
	{
		int W = 10;
		int N = 5;

		int[] profit = {60, 23, 91, 16, 58};
		int[] weight = {3, 4, 0, 6, 5};
		
		for (int n = 0; n < N; n++)
		{
			System.out.println("profit[" + n+1 + "]: " + profit[n] + "\t"
					+ "weight[" + n + "]: " + weight[n]);
		}
		System.out.println("\nMy solution: ");

		ZeroOneKnapSack.showBestComb(profit, weight, W);
	}
}

class Knapsack {

    public static void zeroOneKnapsack(int[] profit, int[] weight, int W) {
        int N = profit.length;   // number of items

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n-1] <= w) option2 = profit[n-1] + opt[n-1][w-weight[n-1]];

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w]) { take[n-1] = true;  w = w - weight[n-1]; }
            else           { take[n-1] = false;                    }
        }

        // print results
        System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= N; n++) {
            System.out.println(n + "\t" + profit[n-1] + "\t" + weight[n-1] + "\t" + take[n-1]);
        }
    }
}
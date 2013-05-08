package interview.classic.test;

import interview.classic.UnlimitedKnapSack;
import interview.classic.UnlimitedKnapSack.Item;

import org.junit.Test;

public class UnlimitedKnapSackTest
{

	@Test
	public void test()
	{
		int N = 3;
		int W = 20;

		int[] profit = new int[N];
		int[] weight = new int[N];
		Item[] item = new Item[N];

		// generate random instance, items 1..N
		for (int n = 0; n < N; n++)
		{
			profit[n] = (int) (Math.random() * 100);
			weight[n] = (int) (Math.random() * W + 1);
			item[n] = new Item(profit[n], weight[n]);
			System.out.println(item[n]);
		}

		System.out.println("\nMy solution: ");
		UnlimitedKnapSack.bestSolution(item, W);
	}

	@Test
	public void test2()
	{
		int N = 3;
		int W = 11;

		int[] profit = { 60, 75, 90 };
		int[] weight = { 2, 3, 4 };
		Item[] item = new Item[N];

		// generate random instance, items 1..N
		for (int n = 0; n < N; n++)
		{
			item[n] = new Item(profit[n], weight[n]);
			System.out.println(item[n]);
		}

		System.out.println("\nMy solution: ");
		UnlimitedKnapSack.bestSolution(item, W);
	}
}

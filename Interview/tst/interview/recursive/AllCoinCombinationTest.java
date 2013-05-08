package interview.recursive;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class AllCoinCombinationTest
{
	@Test
	public void test_12510Form100()
	{
		int[] coins = { 1, 2, 5, 10 };
		int sum = 100;
		List<Map<Integer, Integer>> set = AllCoinCombination.findAll(coins, 0,
				sum);
		System.out.println("#solution: " + set.size());
		AllCoinCombination.printSolution(set);

		System.out.println("#solution: " + set.size());
	}

	@Test
	public void test_10521Form100()
	{
		int[] coins = { 10, 5, 2, 1 };

		int sum = 100;
		List<Map<Integer, Integer>> set = AllCoinCombination.findAll(coins, 0,
				sum);
		System.out.println("#solution: " + set.size());
		AllCoinCombination.printSolution(set);

		System.out.println("#solution: " + set.size());
	}

	@Test
	public void test_1210Form100()
	{
		int[] coins = { 1, 2, 10 };

		int sum = 100;
		List<Map<Integer, Integer>> set = AllCoinCombination.findAll(coins, 0,
				sum);
		System.out.println("#solution: " + set.size());
		AllCoinCombination.printSolution(set);

		System.out.println("#solution: " + set.size());
	}
	
	@Test
	public void test_1021Form100()
	{
		int[] coins = { 10, 2, 1 };

		int sum = 100;
		List<Map<Integer, Integer>> set = AllCoinCombination.findAll(coins, 0,
				sum);
		System.out.println("#solution: " + set.size());
		AllCoinCombination.printSolution(set);

		System.out.println("#solution: " + set.size());
	}
}

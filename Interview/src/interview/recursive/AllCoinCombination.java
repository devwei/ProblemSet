package interview.recursive;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class AllCoinCombination
{
	public static List<Map<Integer, Integer>> findAll(int[] coins, int start,
			int sum)
	{
		List<Map<Integer, Integer>> result = Lists.newArrayList();

		if (start == coins.length - 1)
		{
			if (sum > 0 && sum / coins[start] > 0 && sum % coins[start] == 0)
			{
				Map<Integer, Integer> sol = Maps.newTreeMap();
				sol.put(coins[start], sum / coins[start]);
				result.add(sol);
			}
			return result;
		}
		
		if ( sum == 0)
		{
			return result;
		}

		for (int i = 0; coins[start] * i <= sum; i++)
		{
			List<Map<Integer, Integer>> set = findAll(coins, start + 1, sum - i
					* coins[start]);
			for (Map<Integer, Integer> sol : set)
			{
				sol.put(coins[start], i);
				result.add(sol);
			}
		}
		if ( sum % coins[start] == 0)
		{
			Map<Integer, Integer> newSol = Maps.newTreeMap();
			newSol.put(coins[start], sum / coins[start]);
			result.add(newSol);
		}

		return result;
	}

	public static void printSolution(List<Map<Integer, Integer>> sol)
	{
		for (Map<Integer, Integer> map : sol)
		{
			System.out.println("######");
			for (Entry<Integer, Integer> entry : map.entrySet())
			{
				System.out.print(String.format("[%s] : %s\n", entry.getKey(),
						entry.getValue()));
			}
			System.out.println("######");
		}
	}
}

/* what went wrong?
 * 1. Edge case. When no solution/sum is zero.
 */

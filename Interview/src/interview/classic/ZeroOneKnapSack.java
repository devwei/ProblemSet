package interview.classic;

import java.util.List;

import com.google.common.collect.Lists;

public class ZeroOneKnapSack
{
	public static void showBestComb(int[] profit, int[] weight, int maxWt)
	{
		Item[] items = new Item[weight.length];
		for (int i = 0; i < weight.length; i++)
		{
			items[i] = new Item(profit[i], weight[i]);
		}

		int numItem = items.length;
		Cell[][] mtx = new Cell[numItem][maxWt + 1];
		for (int i = 0; i <= maxWt; i++)
		{
			if (i >= items[numItem - 1].weight)
			{
				mtx[numItem - 1][i] = new Cell(items[numItem - 1].value, true);
			} else
			{
				mtx[numItem - 1][i] = new Cell(0, false);
			}
		}
		for (int row = numItem - 2; row >= 0; row--)
		{
			for (int col = 0; col <= maxWt; col++)
			{
				int takenValue = 0;
				if (col >= items[row].weight)
				{
					takenValue = mtx[row + 1][col - items[row].weight].maxValue
							+ items[row].value;
				}
				int notTakenValue = mtx[row + 1][col].maxValue;
				if (takenValue > notTakenValue)
				{
					mtx[row][col] = new Cell(takenValue, true);
				} else
				{
					mtx[row][col] = new Cell(notTakenValue, false);
				}
			}
		}

		int row = 0, wt = maxWt;
		List<Integer> takenItemIdx = Lists.newArrayList();
		do
		{
			Cell c = mtx[row][wt];
			if (c.taken)
			{
				takenItemIdx.add(row);
				System.out.println(row + " : value[" + items[row].value
						+ "], weight[" + items[row].weight + "]");
				wt = wt - items[row].weight;
			}
			row++;
		} while (row <= numItem - 1 && wt >= 0);

	}

	static class Item
	{
		int value;
		int weight;

		public Item(int value, int weight)
		{
			this.value = value;
			this.weight = weight;
		}

		@Override
		public String toString()
		{
			return "[" + value + ", " + weight + "]";
		}
	}

	static class Cell
	{
		int maxValue;
		boolean taken;

		public Cell(int maxValue, boolean taken)
		{
			this.maxValue = maxValue;
			this.taken = taken;
		}

		@Override
		public String toString()
		{
			return "[" + maxValue + ", " + taken + "]";
		}
	}

}

/**
 * what went wrong? 1. Type inconsistency: what's stored in the matrix is an
 * cell object, not the maxValue or boolean 'taken' 2. Forget to update the row
 * when printing out the solution
 */

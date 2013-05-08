package interview.classic;

public class UnlimitedKnapSack
{
	static class Cell
	{
		int value;
		int itemIdx;

		public Cell(int value, int itemIdx)
		{
			this.value = value;
			this.itemIdx = itemIdx;
		}

		@Override
		public String toString()
		{
			return "[" + value + ", " + itemIdx + "]";
		}
	}

	public static class Item
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

	public static void bestSolution(Item[] item, int maxWt)
	{
		Cell[] ary = new Cell[maxWt + 1];
		ary[0] = new Cell(0, -1);

		for (int i = 1; i <= maxWt; i++)
		{
			int maxVal = Integer.MIN_VALUE;
			int idx = -1;
			for (int j = 0; j < item.length; j++)
			{
				if (i >= item[j].weight)
				{
					if (maxVal < ary[i - item[j].weight].value + item[j].value)
					{
						maxVal = ary[i - item[j].weight].value + item[j].value;
						idx = j;
					}
				}
			}
			if (ary[i - 1].value >= maxVal)
			{
				maxVal = ary[i - 1].value;
				idx = -1;
			}
			ary[i] = new Cell(maxVal, idx);
		}

		int pos = maxWt;
		do
		{
			Cell c = ary[pos];
			if (c.itemIdx != -1)
			{
				System.out.println("[" + c.itemIdx + "] " + item[c.itemIdx]);
				pos = pos - item[c.itemIdx].weight;
			} else
			{
				pos--;
			}
		} while (pos >= 0);
	}
}

package interview.classic;

public class BinarySearchShiftStep
{
	public static int findFirstMinIdx(int[] ary)
	{
		return findFirstMinIdx(ary, 0, ary.length - 1);
	}

	private static int findFirstMinIdx(int[] ary, int start, int end)
	{
		if (start == end)
		{
			return start;
		}

		int mid = (start + end) / 2;
		if (ary[mid] > ary[start])
		{
			int minIdx = findFirstMinIdx(ary, mid + 1, end);
			if (ary[start] < ary[minIdx])
			{
				return start;
			} else
			{
				return minIdx;
			}
		} else if (ary[mid] < ary[start])
		{
			return findFirstMinIdx(ary, start, mid);
		} else
		{
			if (ary[mid] < ary[end])
				return start;
			else if (ary[mid] > ary[end])
			{
				return findFirstMinIdx(ary, mid + 1, end);
			} else
			{
				int lfIdx, rtIdx;
				lfIdx = findFirstMinIdx(ary, start, mid);
				rtIdx = findFirstMinIdx(ary, mid+1, end);
				if (ary[lfIdx] > ary[rtIdx])
				{
					return rtIdx;
				} else
				{
					return lfIdx;
				}
			}
		}
	}
}

package interview.classic;

public class KthElementInTwoSortedArrays
{
	public static int findKthWithBinaryProbing(int[] A, int[] B, int k)
	{
		return findKthWithBinaryProbing(A, B, 0, A.length - 1, 0, B.length - 1,
				k);
	}

	public static int findKthWithBinaryProbing(int[] A, int[] B, int l1,
			int r1, int l2, int r2, int k)
	{
		if (l1 > r1)
		{
			return B[l2+k-1];
		}
		
		if (l2 > r2)
		{
			return A[l1+k-1];
		}

		if (l1 == r1)
		{
			int pos = findPivortInArray(A[l1], B, l2, r2);
			if (pos - l2 + 1 == k)
			{
				return A[l1];
			} else if (pos - l2 + 1 < k)
			{
				return B[l2 + k - 2];
			} else
			{
				return B[l2 + k - 1];
			}
		}

		if (l2 == r2)
		{
			int pos = findPivortInArray(B[l2], A, l1, r1);
			if (pos - l1 + 1 == k)
			{
				return B[l2];
			} else if (pos - l1 + 1 < k)
			{
				return A[l1 + k - 2];
			} else
			{
				return A[l1 + k - 1];
			}

		}

		int pivotIndex = (l1 + r1) / 2;
		int pivot = A[pivotIndex];
		int pos = findPivortInArray(pivot, B, l2, r2);

		if (pivotIndex - l1 + 1 + pos - l2 == k)
		{
			return pivot;
		} else if (pivotIndex - l1 + 1 + pos - l2 < k)
		{
			return findKthWithBinaryProbing(B, A, pos, r2, pivotIndex+1, r1,
					k - (pivotIndex - l1 + 1 + pos - l2));
		} else
		{
			
			return findKthWithBinaryProbing(B, A, l2, pos - 1, l1,
					pivotIndex - 1, k);
		}
	}

	private static int findPivortInArray(int x, int[] array, int head, int tail)
	{
		int result = tail+1;
		while (head <= tail)
		{
			int mid = (head + tail) / 2;
			if (x <= array[mid])
			{
				result = mid;
				tail = mid - 1;
			} else
			{
				head = mid + 1;
			}
		}
		return result;
	}

	public static int findKth(int[] A, int[] B, int k)
	{
		if (k > A.length + B.length)
		{
			throw new RuntimeException();
		}
		int i = 0, j = 0;
		int cur = 0;
		while (i + j < k && i < A.length && j < B.length)
		{
			int x = A[i], y = B[j];
			cur = x > y ? y : x;
			if (x <= y)
			{
				i++;
			} else
			{
				j++;
			}
		}
		if (i + j < k && i < A.length)
		{
			return A[k - B.length - 1];
		} else if (i + j < k && j < B.length)
		{
			return B[k - A.length - 1];
		} else
		{
			return cur;
		}
	}
}

/**
 * What went wrong?
 * 1. Typo: variable names are too sort, hard to recogonize on whiteboard.
 * Also could use the wrong variable.
 * 2. Edge case: when left border is greater than the right border, how to recurse?
 */

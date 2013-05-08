package interview.classic.test;

import static org.junit.Assert.assertEquals;
import static interview.classic.KthElementInTwoSortedArrays.findKthWithBinaryProbing;
import static interview.classic.KthElementInTwoSortedArrays.findKth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

public class KthElementInTwoSortedArraysTest
{
	@Before
	public void setup()
	{

	}

	@Test
	public void test_twoSinglesAndKIsOne()
	{
		int[] A = { 1 };
		int[] B = { 2 };
		int k = 1;
		assertEquals(findKth(A, B, k), findKthWithBinaryProbing(A, B, k));
		assertEquals(findKth(A, B, k), findKthWithBinaryProbing(B, A, k));
	}

	@Test
	public void test_twoSinglesAndKIsTwo()
	{
		int[] A = { 1 };
		int[] B = { 2 };
		int k = 2;
		assertEquals(findKth(A, B, k), findKthWithBinaryProbing(A, B, k));
		assertEquals(findKth(B, A, k), findKthWithBinaryProbing(B, A, k));
	}

	@Test
	public void test_oneSingleOneLong()
	{
		int[] A = { 7 };
		int[] B = { 2, 4, 6, 8, 10 };
		int k = 1;
		int ans = 2;
		assertEquals(ans, findKth(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(B, A, k));

		k = 2;
		ans = 4;
		assertEquals(ans, findKth(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(B, A, k));

		k = 3;
		ans = 6;
		assertEquals(ans, findKth(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(B, A, k));

		k = 4;
		ans = 7;
		assertEquals(ans, findKth(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(B, A, k));

		k = 5;
		ans = 8;
		assertEquals(ans, findKth(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(B, A, k));

		k = 6;
		ans = 10;
		assertEquals(ans, findKth(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(A, B, k));
		assertEquals(ans, findKthWithBinaryProbing(B, A, k));
	}

	@Test
	public void test_twoLongs()
	{
		int[] A = { 1, 3, 5, 7, 9 };
		int[] B = { 2, 4, 6, 8, 10 };

		int i = 1;
		for (i = 1; i < 10; i++)
		{
			assertEquals(i, findKth(A, B, i));
			assertEquals(i, findKthWithBinaryProbing(A, B, i));
			assertEquals(i, findKthWithBinaryProbing(B, A, i));
		}
	}

	@Test
	public void test_twoLongsWithDifferentLength()
	{
		int[] A = { 1, 3, 5, 7, 9 };
		int[] B = { 2, 4, 6, 8, 10, 11, 12, 13, 14, 15 };

		int i = 1;
		for (i = 1; i < 15; i++)
		{
			assertEquals(i, findKth(A, B, i));
			assertEquals(i, findKthWithBinaryProbing(A, B, i));
			assertEquals(i, findKthWithBinaryProbing(B, A, i));
		}
	}

	@Test
	public void test_twoLongsArbitrary()
	{
		Random r = new Random();

		List<Integer> first = new ArrayList<Integer>();
		List<Integer> second = new ArrayList<Integer>();
		List<Integer> all = new ArrayList<Integer>();

		int n = 20;
		int m = 10;
		for (int i = 0; i < n; i++)
		{
			first.add(r.nextInt(1000));
		}
		for (int j = 0; j < m; j++)
		{
			second.add(r.nextInt(1000));
		}
		all.addAll(first);
		all.addAll(second);
		Collections.sort(first);
		Collections.sort(second);
		Collections.sort(all);

		int k;
		int[] A = ArrayUtils
				.toPrimitive(first.toArray(new Integer[first.size()]));
		int[] B = ArrayUtils.toPrimitive(second.toArray(new Integer[second
				.size()]));
		for (k = 0; k < n + m; k++)
		{
			assertEquals(all.get(k).intValue(),
					findKthWithBinaryProbing(A, B, k+1));
			assertEquals(all.get(k).intValue(),
					findKthWithBinaryProbing(B, A, k+1));
		}
	}
}

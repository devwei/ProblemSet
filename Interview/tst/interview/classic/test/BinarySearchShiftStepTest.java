package interview.classic.test;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import static interview.classic.BinarySearchShiftStep.findFirstMinIdx;
import static org.junit.Assert.assertEquals;

public class BinarySearchShiftStepTest
{
	@Test
	public void oneInt()
	{
		int[] ary = getInts(1, 1);
		print(ary);
		assertEquals(0, findFirstMinIdx(ary));
	}

	@Test
	public void twoInts()
	{
		int[] ary = getInts(2, 2);
		print(ary);
		assertEquals(getSmallestIdx(ary), findFirstMinIdx(ary));
	}

	@Test
	public void oddInts()
	{
		int[] ary = getInts(19, 12);
		print(ary);
		assertEquals(getSmallestIdx(ary), findFirstMinIdx(ary));
	}

	@Test
	public void evenInts()
	{
		int[] ary = getInts(16, 11);
		print(ary);
		assertEquals(getSmallestIdx(ary), findFirstMinIdx(ary));
	}

	@Test
	public void anyInts()
	{
		int size = (int) (Math.random() * 30 + 1);
		int step = (int) (Math.random() * size);
		
		int[] ary = getInts(size, step);
		print(ary);
		assertEquals(getSmallestIdx(ary), findFirstMinIdx(ary));
	}

	private int getRandom()
	{
		return (int) (Math.random() * 100);
	}

	private int getSmallestIdx(int[] ary)
	{
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < ary.length; i++)
		{
			if (ary[i] < min)
			{
				min = ary[i];
				minIdx = i;
			}
		}
		return minIdx;
	}

	private int[] getInts(int size, int step)
	{
		List<Integer> list = Lists.newArrayList();
		for (int i = 0; i < size; i++)
		{
			list.add(getRandom());
		}
		Collections.sort(list);
		
		int[] ary = Ints.toArray(list);
		
		rightShift(ary, step);
		
		return ary;
		 
	}

	private void rightShift(int[] ary, int num)
	{
		reverse(ary, 0, ary.length - 1);
		reverse(ary, 0, num - 1);
		reverse(ary, num, ary.length - 1);
	}

	private void reverse(int[] ary, int start, int end)
	{
		int temp;

		int left = start;
		int right = end;
		while (left < right)
		{
			temp = ary[left];
			ary[left] = ary[right];
			ary[right] = temp;
			left++;
			right--;
		}
	}
	
	private void print(int[] ary)
	{
		for(int i=0; i<ary.length; i++)
		{
			System.out.print(ary[i] + "\t");
		}
		System.out.println("\t SmallestIdx: " + getSmallestIdx(ary));
	}
}

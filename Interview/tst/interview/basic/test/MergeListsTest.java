package interview.basic.test;

import static org.junit.Assert.assertEquals;
import interview.basic.MergeLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MergeListsTest
{

	@Before
	public void setup()
	{

	}

	@Test
	public void test_mergeTwoListsWithDifferentLength()
	{
		Random r = new Random();

		List<Integer> first = new ArrayList<Integer>();
		List<Integer> second = new ArrayList<Integer>();
		List<Integer> all = new ArrayList<Integer>();

		int n = 20;
		int m = 35;
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

		@SuppressWarnings("unchecked")
		List<Integer>[] lists = new List[2];
		lists[0] = first;
		lists[1] = second;
		assertEquals(all, MergeLists.mergeLists(lists));

	}
}

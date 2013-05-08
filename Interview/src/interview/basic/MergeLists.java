package interview.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeLists
{
	public static List<Integer> mergeLists(List<Integer>[] lists)
	{
		List<Integer> result = new ArrayList<Integer>();
		Queue<Rec> que = new PriorityQueue<Rec>();
		int[] cur = new int[lists.length];

		for (int i = 0; i < lists.length; i++)
		{
			que.offer(new Rec(lists[i].get(0), i));
		}

		while (!que.isEmpty())
		{
			Rec r = que.poll();
			result.add(r.value);
			cur[r.listIdx]++;
			if (cur[r.listIdx] != lists[r.listIdx].size())
			{
				que.offer(new Rec(lists[r.listIdx].get(cur[r.listIdx]),
						r.listIdx));
			}
		}
		return result;
	}
}

class Rec implements Comparable<Rec>
{
	Integer value;
	int listIdx;

	public Rec(Integer value, int listIdx)
	{
		this.value = value;
		this.listIdx = listIdx;
	}

	public int compareTo(Rec r)
	{
		if (value < r.value)
		{
			return -1;
		} else if (value == r.value)
		{
			return 0;
		} else
		{
			return 1;
		}
	}
}

/**
 * What went wrong? 
 * 1. Type inconsistency: the queue stores an object of Rec,
 * not the value list element or the list index
 * 
 */

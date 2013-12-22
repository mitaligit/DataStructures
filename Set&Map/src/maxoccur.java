import java.util.*;
public class maxoccur {
public static void main(String[] args)
{
	int[] a = {1,1,1,1,3,3,3,5,5,5,5,6};
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	for(int n: a)
	{
		list1.add(n);
	}
	System.out.print(maxOccurrences(list1));
}
public static int maxOccurrences(ArrayList<Integer> list1)
{
	int count = 0;
	int mincount = 0;
	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	for(int i=0; i<list1.size(); i++)
	{
		if(!mp.containsKey(list1.get(i)))
		{
			mp.put(list1.get(i), 1);
		}
		else
		{
			int oldval = mp.get(list1.get(i));
			mp.put(list1.get(i), oldval+1);
		}
	}
	for(int num: mp.keySet())
	{
		count = mp.get(num);
		if(mincount<count)
		{
			mincount = count;
		}
	}
	return mincount;
}
}

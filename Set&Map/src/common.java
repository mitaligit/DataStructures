import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class common {
	public static void main(String[] args)
	{
		int[] a = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
		int[] b = {-5, 15, 2, -1, 7, 15, 36};
		
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		for(int n : a)
		{
			s1.add(n);
		}
		
		for(int n1 : b)
		{
			s2.add(n1);
		}
		int count = 0;
		Iterator<Integer> iter = s1.iterator();
		while(iter.hasNext())
		{
			int num = iter.next();
			boolean res = s2.contains(num);
			
			if(res == true)
			{
				count++;
			}
			
		}
		System.out.print(count);
		
	}
}

/*Write a method hasOdd that takes a Set of integers as a parameter and that returns true if the set contains at least one odd integer, and false otherwise. If passed the empty set, your method should return false. 
*/
import java.util.*;
public class odd {
public static void main(String[] args)
{
	int[] num = {2,4,6,8};
	Set<Integer> n1 = new HashSet<Integer>();
	for(int n2: num)
	{
		n1.add(n2);
	}
	hasOdd(n1);
	System.out.print(hasOdd(n1));
}
public static boolean hasOdd(Set<Integer> n1)
{
	if(n1.isEmpty())
	{
		return false;
	}
	Iterator<Integer> it = n1.iterator();
	while(it.hasNext())
	{
		int n3 = it.next();
		if(n3%2 != 0)
		{
			return true;
		}
	}
	return false;
}
}

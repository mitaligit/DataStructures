import java.util.*;
public class uniq {
public static void main(String[] args)
{
	int[] a = {3, 7, 3, -1, 2, 3, 7, 2, 15, 15};
	Set<Integer> num = new HashSet<Integer>();
	for(int n : a)
	{
		num.add(n);
	}
	System.out.print(num.size());
}
}



/*Write a method counts that accepts a List of integers and a Set of integers as parameters, and returns a map from each value in the set to the number of occurrences of that value in the list. For example, if your method is passed the following list and set as parameters:

    list: [4, -2, 3, 9, 4, 17, 5, 29, 14, 87, 4, -2, 100]
    set: [-2, 4, 29]

Then your method should return the map {-2=2, 4=3, 29=1}, because there are two occurrences of -2, three occurrences of 4, and one occurrence of 29.
*/
import java.util.*;
public class coun {
public static void main(String[] args)
{
	int[] a = {4, -2, 3, 9, 4, 17, 5, 29, 14, 87, 4, -2, 100};
	int[] b = {-2, 4, 29};
	ArrayList<Integer> num = new ArrayList<Integer>();
	Set<Integer> s = new HashSet<Integer>();
	for(int n: a)
	{
		num.add(n);
	}
	for(int n1: b)
	{
		s.add(n1);
	}

	System.out.print(counts(num, s));
}
public static Map<Integer, Integer> counts(ArrayList<Integer> num, Set<Integer> s)
{
	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	for(int word: s)
	{
		
		for(int j = 0; j<num.size(); j++)
		{
			if(word == num.get(j))
			{
				if(!mp.containsKey(word))
				{
					mp.put(word, 1);
				}
				else
				{
					int oldvalue = mp.get(word);
					mp.put(word, oldvalue+1);
				}
				
			}
		}
	}
	return mp;
}

}

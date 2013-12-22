import java.util.*;
public class mareverse {
public static void main(String[] args)
{
	Map<Integer, String> mp = new HashMap<Integer, String>();
	mp.put(42, "Marty");
	mp.put(81, "Sue");
	mp.put(17, "Ed");
	mp.put(31, "Dave");
	mp.put(56, "Ed");
	mp.put(3, "Marty");
	mp.put(29, "Ed");
	System.out.print(reverse(mp));
}
public static Map<String, Integer> reverse(Map<Integer, String> mp)
{
	Map<String, Integer> mp1 = new HashMap<String, Integer>();
	//Set<Integer> s1 = new HashSet<Integer>();
	//Set<String> s2 = new HashSet<String>();
	for(Integer s: mp.keySet())
	{
		mp1.put(mp.get(s), s);
		//s1.add(s);
		//s2.add(mp.get(s));
		
	}
	return mp1;
	
}
}

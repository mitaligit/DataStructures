import java.util.*;
public class intersec {
public static void main(String[] args)
{
	Map<String, Integer> mp = new HashMap<String, Integer>();
	Map<String, Integer> mp1 = new HashMap<String, Integer>();
	mp.put("Janet", 87);
	mp.put("Logan", 62);
	mp.put("Whitaker", 46);
	mp.put("Alyssa", 100);
	mp.put("Stefanie", 80);
	mp.put("Jeff", 88);
	mp.put("Kim", 52);
	mp.put("Sylvia", 95);
	mp1.put("Logan", 62);
	mp1.put("Kim", 52);
	mp1.put("Whitaker", 52);
	mp1.put("Jeff", 88);
	mp1.put("Stefanie", 80);
	mp1.put("Brian", 60);
	mp1.put("Lisa", 83);
	mp1.put("Sylvia", 87);
	System.out.print(intersect(mp, mp1));
}
public static Map<String, Integer> intersect(Map<String, Integer> mp, Map<String, Integer> mp1)
{
	Map<String, Integer> mp2 = new HashMap<String, Integer>();
	Integer n1;
	String s4;
	for(String s : mp.keySet())
	{
		s4 = s;
		n1 = mp.get(s);
		for(String s1: mp1.keySet())
		{
			if(s4 == s1 && n1 == mp1.get(s1))
			{
				mp2.put(s4, n1);
			}
		}
	}
	return mp2;
}
}

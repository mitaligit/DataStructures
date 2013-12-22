import java.util.*;
public class mauniq {
public static void main(String[] args)
{
	Map<String, String> mp = new HashMap<String, String>();
	mp.put("Marty", "Stepp");
	mp.put("Stuart", "Reges");
	mp.put("Jessica", "Miller");
	mp.put("Amanda", "Camp");
	mp.put("Hal", "Perkins");
	System.out.print(isUnique(mp));
}
public static boolean isUnique(Map<String, String> mp)
{

	Set<String> s2 = new HashSet<String>();
	//ArrayList<String> list = new ArrayList<String>();
	for(String s: mp.keySet())
	{
		String s1 = mp.get(s);
		boolean flag = s2.add(s1);
		if(flag == false)
		{
			return false;
		}
		//list.add(s1);
	}
	/*for(int i= 0; i<list.size(); i++)
	{
		for(int j = i+1; j<list.size(); j++)
		{
			if(list.get(i)==list.get(j))
					{
						return false;
					}
			
		}
	}*/
	return true;
}
}

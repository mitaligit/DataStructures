import java.util.*;
public class contain {
public static void main(String[] args)
{
	String[] list1 = {"how", "how", "how", "are", "you?"};
	ArrayList<String> list = new ArrayList<String>();
	for(String str: list1)
	{
		list.add(str);
	}
	contains3(list);
	System.out.print(contains3(list));
}
public static boolean contains3(ArrayList<String> list)
{
	Map<String, Integer> mp = new HashMap<String, Integer>();
	for(int i=0; i<list.size(); i++)
	{
	if(!mp.containsKey(list.get(i)))
	{
		mp.put(list.get(i), 1);
	}
	else
	{
		int oldvalue = mp.get(list.get(i));
		mp.put(list.get(i), oldvalue+1);
	}
	}
	for(String word: mp.keySet())
	{
		int count = mp.get(word);
		if(count>=3)
		{
			return true;
		}
	}
	return false;
}
}

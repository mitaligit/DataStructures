import java.util.*;
public class removeven {
public static void main(String[] args)
{
	String[] str = {"foo", "buzz", "bar", "fork", "bort", "spoon", "!", "dude"};
	Set<String> s1 = new HashSet<String>();
	for(String s2: str)
	{
		s1.add(s2);
	}
	removeEvenLength(s1);
}
public static void removeEvenLength(Set<String> s1)
{
	Iterator<String> it = s1.iterator();
	Set<String> s4 = new HashSet<String>();
	while(it.hasNext())
	{
		String s3 = it.next();
		if(s3.length()%2 ==0)
		{
			s4.add(s3);
			//s1.remove(it.next());
		}
	}
	s1.removeAll(s4);
	System.out.print(s1);
}
}

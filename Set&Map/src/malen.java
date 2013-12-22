/*Write a method maxLength that takes a Set of strings as a parameter and that returns the length of the longest string in the set. If your method is passed an empty set, it should return 0.*/ 

import java.util.*;
public class malen {
	public static void main(String[] args)
	{
		String[] str = {"be", "be", "is", "not", "or", "question", "that", "the", "to", "to"};
		Set<String> s = new HashSet<String>();
		for(String s1: str)
		{
			s.add(s1);
		}
		Iterator<String> it = s.iterator();
		String s2 = it.next();
		int maxlen = s2.length();
		while(it.hasNext())
		{
			String s3 = it.next();
			if(maxlen<s3.length())
			{
			maxlen = s3.length();	
			}
		}
		System.out.print(maxlen);
	}

}

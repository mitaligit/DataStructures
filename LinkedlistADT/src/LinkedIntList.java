import java.util.NoSuchElementException;
import java.util.Stack;


public class LinkedIntList {
private ListNode front;
	
	// Constructs an empty list.
	public LinkedIntList() {
		front = null;
	}

	// Add the given value to the end of the list.	
	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		} else {
			// list wasn't empty; find the back
			// (note: this is inefficient.  We could keep a reference to the last node)		
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}
	
	
	// Returns the value at a given index
	// pre: 0 <= index < number of nodes; front != null
	// throws NullPointerException if index > size.
	public int get(int index) {
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}
	
	// Adds a value at a given index.
	// pre: 0 <= index <= size
	// Throws a NullPointerException if index > size.
	public void add(int index, int value) {
		if (index == 0) {
			front = new ListNode(value, front);
		} else {
			ListNode current = front;
			for (int i = 0; i < index - 1 ; i++) {
				current = current.next;
			}
			ListNode temp = new ListNode(value, current.next);
			current.next = temp;
			// also ok:	current.next = new ListNode(value, current.next);
		}
	}
	public void set(int index, int value)
	{
		
			ListNode current = front;
			for(int i=0; i<=index; i++)
			{
				if(i==index)
				{
					current.data = value;
				}
				current = current.next;
			}
		
	}
	public int indexOf(int value) {
		ListNode current = front;
		int count =0;
		while(current!= null) {
			if(current.data==value)
			{
				return count;
			}
			current = current.next;
			count++;
			
		}
		return -1;
	}
	
	public int min()
	{
		if(front == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
		ListNode current = front;
		int min = current.data;
		while(current != null)
		{
			if(min > current.data)
			{
				min = current.data;
			}
			current = current.next;
		}
		return min;
		}
	}
	public boolean isSorted()
	{
		ListNode current = front;
		while (current.next != null)
		{
			if(current.data <= current.next.data)
			{
				current = current.next;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public int lastIndexOf(int value)
	{
		ListNode current = front;
		int point = -1;
		int count = 0;
		while(current != null)
		{
			if(current.data == value)
			{
				point = count;
			}
			current = current.next;
			count++;
		}
		return point;
	}
	public int countDuplicates()
	{
		ListNode current = front;
		int count = 0;
		int totalcount = 0;
		while(current.next != null)
		{
			if(current.data == current.next.data)
			{
				count++;
				totalcount += count;
				count =0;
			}
			else if(current.data != current.next.data)
			{
				count = 0;
			}
			current = current.next;
		}
		return totalcount;
	}
	
	public boolean hasTwoConsecutive()
	{
		ListNode current = front;
		while(current.next != null)
		{
			if(current.next.data - current.data == 1)
			{
				return true;
			}
			current = current.next;
		}
		return false;
		
	}
	public int deleteBack()
	{
		ListNode current = front;
		int num = 0;
		while(current != null)
		{
			if(current.next.next == null)
			{
				num = current.next.data;
				current.next = null;
			}
			current = current.next;
		}
		return num;
	}
	public void stutter()
	{
		ListNode current = front;
		int num;
		//ListNode tmp = new ListNode();
		while(current != null)
		{
			num = current.data;
			ListNode temp = new ListNode(num, current.next);
			current.next = temp;
			current = current.next.next;
			
		}
	}
	
	public void split()
	{
		ListNode current = front;
	
		int num;
		while(current.next != null)
		{
			num = current.next.data;
			if(num<0)
			{
				ListNode tmp = current.next;
				current.next = current.next.next;
			    tmp.next = front;
			    front = tmp;
				
			}
			else
			{
			current = current.next;
			}
			
		}
	}
	
	public LinkedIntList transferFrom( LinkedIntList list2) {
		ListNode current = front;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = list2.front;
		
		
		list2.front = null;
		return list2;
	}
	
	public boolean equals2(LinkedIntList list2) {
		ListNode current = front;
		ListNode current2 = list2.front;
		while(current != null && current2 != null)
		{
			if(current.data == current2.data)
			{
				current = current.next;
				current2 = current2.next;
			}
			else
			{
				return false;
			}
		}
		if ( current == null && current2 == null){
		    return true;
		}
		return false;
	}
	public LinkedIntList mergeSortedLists(LinkedIntList list2)
	{
		ListNode current = front;
		ListNode current2 = list2.front;
		LinkedIntList l3 = new LinkedIntList();
		while(current !=null || current2 != null)
		{
			if(current2 == null || (current != null && current.data<=current2.data))
			{
				l3.add(current.data);
				current = current.next;
			}
			else
			{
				l3.add(current2.data);
				current2 = current2.next;
			}
		}
		return l3;
	}
	
	public LinkedIntList removeEvens()
	{
		ListNode current = front;
		LinkedIntList tmp = new LinkedIntList();
		int num;
		while(current != null)
		{
			num = current.data;
			tmp.add(num);
			if(current.next != null)
			{
			current = current.next.next;
			}
			else if(current.next == null)
			{
				return tmp;
			}
		}
		return tmp;
	}
	
	public void removeAll(int value)
	{
		while (front.data == value && front != null) {
			if(front.next == null)
			{
				front = null;
				return;
			}
			else
			{
			front = front.next;
			}
		}
		ListNode current = front;
		while (current != null && current.next != null) {
			if (  current.next.data == value) {
				current.next = current.next.next;
			}
			else
			{
				current = current.next;
			}
		}
	}
	public void removeRange(int pos1, int pos2)
	{
			ListNode current = front;
			int num = (pos2 - pos1) + 1;
			while(current != null && pos1 != 1)
			{
				current = current.next;
				pos1--;
			}
			while(  current != null  && current.next != null && num != 0 ) 
			{
				current.next = current.next.next;
				num--;
			}
	}
	public void doubleList()
	{
		ListNode current = front;
		ListNode tmp = front;
		int count = 1;
		while(current.next != null)
		{
			current = current.next;
			count++;
		}
		while(count != 0)
		{
			current.next = new ListNode(tmp.data, current.next);
			current = current.next;
			
			tmp = tmp.next;
			
			count--;
			
		}
		
	}
	public void rotate()
	{
		ListNode current = front;
		
		while(current.next!= null)
		{
			current = current.next;
		}
		ListNode tmp = front.next;
		current.next = front;
		current = current.next;
		current.next = null;
		front = tmp;
	}
	
	public void reverse()
	{
		ListNode current = front;
		Stack<Integer> s1 = new Stack<Integer>();
		int num;
		while(current!= null)
		{
			num = current.data;
			s1.push(num);
			current = current.next;	
		}
		front = null;
		while (!s1.isEmpty())
		{
			num = s1.pop();
			if (front == null)
			{
				front = new ListNode(num);
			}
			else
			{
				ListNode current1 = front;
				while (current1.next != null) {
					current1 = current1.next;
				}
				current1.next = new ListNode(num);
			}
		}
	}
	public void swap()
	{
		if(front == null)
		{
			return;
		}
		else if(front.next == null)
		{
			return;
		}
		else
		{
			ListNode current = front;
			
			while(current!=null && current.next != null)
			{
				ListNode tmp = current.next;
				current.next = current.next.next;
				tmp.next = current;
				current = tmp;
				current = current.next.next;
			}
		}
	}
	// Returns a comma-separated String representation of this list.
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
}

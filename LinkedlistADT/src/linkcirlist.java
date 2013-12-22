import java.util.*;
public class linkcirlist {
	private ListNode front;
	public linkcirlist()
	{
		front = null;
	}
	public void circadd(int value) {
		if (front == null) {
			front = new ListNode(value);
			front.next = front;
		} else {
			// list wasn't empty; find the back
			// (note: this is inefficient.  We could keep a reference to the last node)		
			ListNode current = front;
			while (current.next != front && current.next !=null) {
				current = current.next;
			}
		
			
			current.next = new ListNode(value, front);
		}
	}
	public void setUpTest() {
		front = new ListNode(10);
		front.next = new ListNode(11);
		front.next.next = new ListNode(12);
		front.next.next.next = new ListNode(13);
		front.next.next.next.next = new ListNode(14, front.next.next);
	}
	public ListNode detectlas()
	{
		if(front == null)
		{
			return null;
		}
		else
		{
			ListNode curr = front;
			Map<ListNode, Integer> mp = new HashMap<ListNode, Integer>();
			mp.put(curr, 1);
			while(!mp.containsKey(curr.next))
			{
				mp.put(curr.next, 1);
				curr = curr.next;
			}
			return curr;
			
		}
	}
	public void findlas()
	{
		ListNode curr = front;
		while(curr.next != front)
		{
			curr = curr.next;
		}
		if(curr.next == front)
		{
			System.out.println(curr.data);
		}
	}
	public boolean findloop()
	{
		if(front == null)
		{
			System.out.println("false");
		}
		ListNode curr1 = front;
		ListNode curr2 = front;
		do{
			curr1 = curr1.next;
			if(curr2.next != null)
			{
			curr2 = curr2.next.next;
			}
		}while(curr1 != curr2 && curr1 != null && curr2!= null);
		
		if(curr1 == curr2 && curr1!= null && curr2 != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String toString() {
		if (front == null) {
			return "[]";
		} else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != front) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
}

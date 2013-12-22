public class ListNodeClient {
	public static void main(String[] args) {
		// for jGRASP debugger (so we can see other lists' names)
		ListNode dummy = new ListNode();
		
		ListNode list = new ListNode(42, new ListNode(-3, 
				new ListNode(17, new ListNode(9))));
		
		// printing the list the long way:
		System.out.println(list.data);
		System.out.println(list.next.data);
		System.out.println(list.next.next.data);
		System.out.println(list.next.next.next.data);
		
		// printing the list the short way:
		// as long as I have nodes (haven't reached null)
		// 	print current node
		// 	go to the next node
		
		ListNode current = list;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}


public class circclient {
	public static void main(String[] args) {		
		linkcirlist list1 = new linkcirlist();
		System.out.println(list1);
		list1.circadd(1);
		list1.circadd(1);
		list1.circadd(3);
		list1.circadd(3);
		list1.circadd(6);
		list1.circadd(9);
		list1.circadd(-15);
		list1.circadd(-15);
		list1.circadd(-23);
		list1.circadd(23);
		list1.circadd(23);
		list1.circadd(40);
		list1.circadd(41);
		System.out.println(list1);
		//list1.findlas();
		System.out.println(list1.findloop());
		//list1.setUpTest();
		//ListNode n = list1.detectlas();
		//System.out.println(n.data);
		
	}
}

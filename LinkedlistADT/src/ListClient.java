
public class ListClient {
	public static void main(String[] args) {		
		LinkedIntList list = new LinkedIntList();
		System.out.println(list);
		list.add(1);
		list.add(1);
		list.add(3);
		list.add(3);
		list.add(6);
		list.add(9);
		list.add(-15);
		list.add(-15);
		list.add(-23);
		list.add(23);
		list.add(23);
		list.add(40);
		list.add(41);
		System.out.println(list);		
		
		LinkedIntList list2 = new LinkedIntList();
		System.out.println("list2: " + list2);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(1);
		list2.add(6);
		list2.add(9);
		list2.add(-15);
		list2.add(-15);
		list2.add(-23);
		list2.add(23);
		list2.add(23);
		list2.add(40);
		list2.add(41);
		System.out.println("list2: " + list2);		
		//LinkedIntList l3 = list.merge(list2);
		//System.out.print("merge:" + l3.toString());
		/*System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		list.add(2, 1);
		System.out.println(list);	
		list.set(3,3);
		System.out.println(list);
		System.out.println("first index: " + list.indexOf(18));
		System.out.println("min: " + list.min());
		System.out.println("sorted: " + list.isSorted());
		System.out.println("last index:" + list.lastIndexOf(18));
		System.out.println("duplicates: " + list.countDuplicates());
		System.out.println("adjacent or not: " + list.hasTwoConsecutive());
		System.out.println("last num: " + list.deleteBack());
		System.out.println(list);
		list.stutter();
		System.out.println(list);*/
		//list.removeAll(1);
		//System.out.println("removed: " + list);
		//list.split();
		//System.out.println("split: " + list);
		//list.transferFrom(list2);
		//System.out.println("transfer: " + list);
		//System.out.println("transfer: " + list2);
		//list.equals2(list2);
		//System.out.println(list.equals2(list2));
		//System.out.println("even list: " + list.removeEvens());
		//list.removeRange(10, 14);
		//System.out.println("remove range: " + list);
		//list.doubleList();
		//System.out.println("double list: " + list);
		//list.rotate();
		//System.out.println("rotate list: " + list);
		list.reverse();
		System.out.println("reverse list: " + list);
		list.swap();
		System.out.println("swap list: " + list);
	}                   
}

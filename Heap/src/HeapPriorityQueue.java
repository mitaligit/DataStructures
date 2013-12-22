
import java.util.*;
public class HeapPriorityQueue<E extends Comparable<E>>   {
	private E[] elements;
	private int size;

	
	public HeapPriorityQueue() {
		elements = (E[]) new Comparable[14];
		size = 0;
	}

	public void add(E value) {
		elements[size + 1] = value;
		int index = size + 1;
		boolean found = false;
		while (!found && hasParent(index)) {
			int parent = parent(index);
			if (elements[index].compareTo(
					elements[parent]) < 0) {
				swap(elements, index, parent(index));
				index = parent(index);
			} else {
				found = true; // found proper location; stop
			}
		}
		size++;}
	public boolean isEmpty() {
		if(elements.length == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public E peek() {
		return elements[1];
	}
	public E find(int index)throws Exception
	{
		if(index > size)
		{
			throw new Exception("no element");
		}
		return elements[index];
	}
	public E remove() {E result = elements[1]; // last leaf -> root
	elements[1] = elements[size];
	size--;
	int index = 1; // "bubble down" to fix ordering
	boolean found = false;
	while (!found && hasLeftChild(index)) {
		int left = leftChild(index);
		int right = rightChild(index);
		int child = left;
		if (hasRightChild(index) &&
				elements[right].compareTo(elements[left]) < 0) {
			child = right;
		}
		if (elements[index].compareTo(elements[child]) > 0) {
			swap(elements, index, child);
			index = child;
		} else {
			found = true; // found proper location; stop
		}
	}
	return result;
	}
	public void replace(E value1, E value2)
	{
		for(int i =1; i<=elements.length; i++)
		{
			if(elements[i] == value1)
			{
				elements[i] = value2;
				if (hasParent(i) && elements[i].compareTo(elements[parent(i)]) < 0) {
					swap(elements, i, parent(i));
					i = parent(i);
					//bubbleUp(i);
				} else {
					while (hasLeftChild(i)) {
						int left = leftChild(i);
						int right = rightChild(i);
						int child = left;
						if (hasRightChild(i) &&
								elements[right].compareTo(elements[left]) < 0) {
							child = right;
						}
						if (elements[i].compareTo(elements[child]) > 0) {
							swap(elements, i, child);
							i = child;
						}
						//bubbleDown(i);
					}

				}
				return;	
			}
		}

	}
	public int size() {
		return size;}
	public String toString() {
		String s = "";
		for(int i =1; i<=size; i++)
		{
			s = s+ " " + elements[i];	
		}
		return s;
	}

	private void bubbleUp(int i) {
		swap(elements, i, parent(i));
		i = parent(i);
	}
	private void bubbleDown(int i) 
	{
		while (hasLeftChild(i)) {
			int left = leftChild(i);
			int right = rightChild(i);
			int child = left;
			if (hasRightChild(i) &&
					elements[right].compareTo(elements[left]) < 0) {
				child = right;
			}
			if (elements[i].compareTo(elements[child]) > 0) {
				swap(elements, i, child);
				i = child;
			}
		}
	}
	private int parent(int index) {return index/2;}
	private int leftChild(int index) {return index*2;}
	private int rightChild(int index) {return index*2 + 1;}
	private boolean hasParent(int index) {return index > 1;}
	private boolean hasLeftChild(int index) {return leftChild(index) <= size;}
	//private boolean hasLeftRightChild(int index) {...}
	private boolean hasRightChild(int index) {
		return rightChild(index) <= size;}
	private void swap(E[] array, int index1, int index2) {E temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
	}

	public static void main(String args[]) throws Exception{
		HeapPriorityQueue<Integer> h1 = new HeapPriorityQueue<Integer>();
		//fill data in both sets
		
		h1.add(12);
		h1.add(41);
		h1.add(35);
		h1.add(56);
		h1.add(71);
		h1.add(52);
		h1.add(40);
		h1.add(84);
		h1.add(60);
		h1.add(78);
		h1.add(99);
		h1.add(66);
		h1.replace(56, 30);
		int el = h1.find(3);
		System.out.println(el);
		//print and verify 
		//System.out.println(h1.equals2(h2));
		System.out.println(h1.size());
		System.out.println(h1.toString());
		
	}
}

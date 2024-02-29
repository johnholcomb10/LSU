
public class LinkedList <LLType> {
	
	
	private Node <LLType> head;
	private Node <LLType> tail;
	private int numElements;
	/*
	 * Constructor for the linked list.
	 * Initializes the head & tail nodes and the number of elements
	 */
	public LinkedList() {
		head = null;
		tail = null;
		numElements = 0;
	}
	/*
	 * AddFirst - Internal method used to initialize the list when the first item is added
	 */
	private void AddFirst(LLType val) {
		Node<LLType> n = new Node<LLType>(val);
		head = n;
		tail = n;
		numElements++;
	}
	/*
	 * AddAtEnd - Adds a value to the end of the linked list
	 * @param val - The value to stick at the end
	 */
	public void AddAtEnd(LLType val) {
		if(numElements == 0) {
			AddFirst(val);
		}
		else {
			Node<LLType> n = new Node<LLType>(val);
			tail.next = n;
			tail = n;
			numElements++;
		}
		
	}
	/*
	 * AddAtBeginning - Adds a value to the beginning of the linked list
	 * @param val - The value to stick at the beginning
	 */
	public void AddAtBeginning(LLType val) {
		if(numElements == 0) {
			AddFirst(val);
		}
		else {
			Node<LLType> n = new Node<LLType>(val);
			head.prev = n;
			head = n;
			numElements++;
		}
	}
	/*
	 * RemoveFromBeginning - Remvoes an item from the beginning of the list
	 * @return - the item that was removed
	 */
	public LLType RemoveFromBeginning() {
		Node <LLType> n = head;
		head = n.next;
		if(head !=null) {
			head.prev = null;
		}
		//if head == null then we just removed the last element
		else {
			tail = null;
		}
		numElements--;
		return n.getVal();
		
	}
	/*
	 * RemoveFromEnd - Remvoes an item from the end of the list
	 * @return - the item that was removed
	 */
	public LLType RemoveFromEnd() {
		Node<LLType> n = tail;
		tail = n.prev;
		if(tail!=null) {
			tail.next = null;
		}
		//If tail == null then we just removed the last element
		else {
			head = null;
		}
		numElements--;
		return n.getVal();
	}
	/*
	 * toString - returns a string representation of the list of the form "[Item1<-->Item2<-->...<-->.ItemN]"
	 * @return - string representation of the list
	 */
	public String toString() {
		Node <LLType> n = head;
		if(head == null) {
			return "[ ]";
		}
		String retVal = "[";
		while(n.next != null) {
			retVal += n.getVal().toString();
			retVal += "<-->";
			n = n.next;
		}
		retVal += n.getVal().toString();
		retVal +="]";
		return retVal;
					
	}
	/*
	 * ValueAt - Gets the value of an item at a certain position
	 * @param pos - the position to grab the item from
	 * @return - The value of the item at pos
	 */
	public LLType ValueAt(int pos) {
		if(pos > numElements-1) {
			return null;
		}
		Node<LLType> n = head;
		for(; pos > 0; pos--) {
			n = n.next;
		}
		return n.getVal();
	}
	/*
	 * getSize - Returns the number of elements in the list
	 * @return - the number of elements
	 */
	public int getSize() {
		return numElements;
	}
	/*
	 * Peek - Gets the first element of the list
	 * @return - the first element of the list
	 */
	public LLType Peek() {
		return head.getVal();
	}
	/*
	 * IndexOf - searches the list for an item and returns its position
	 * @return - the position of the item, or -1 if the item is not in the list
	 */
	public int IndexOf(LLType item) {
		Node<LLType> n = head;
		for(int i = 0; n != null; i++, n=n.next) {
			if(n.getVal().equals(item)) {
				return i;
			}		
		}
		return -1;
	}
	
	private class Node<Ntype>{
		Ntype data;
		Node<Ntype> next;
		Node<Ntype> prev;
		
		public Node(Ntype val){
			data = val;
			next = null;
			prev = null;
		}
		
		public Node(Ntype val, Node<Ntype> n, Node<Ntype> p){
			data = val;
			next = n;
			prev = p;
		}
		
		public Ntype getVal() {
			return this.data;
		}
	}
}
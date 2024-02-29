
public class Queue  {
	
	
	LinkedList <String> List;
	
	public Queue() {
		List = new LinkedList<String>();
	}
	
	public void Add(String name) {
		List.AddAtEnd(name);
	}
	
	public String Process() {
		String firstPerson = List.Peek();
		List.RemoveFromBeginning();
		return firstPerson;
	}
	
	public int NumInFront(String name) {
		return List.IndexOf(name);
	}
	
	public void printQueue() {
		System.out.printf("Queue: %s\n", List.toString());
	}
	public int getSize() {
		return List.getSize();
	}
	
	public String nextUp() {
		return List.Peek();
	}
}
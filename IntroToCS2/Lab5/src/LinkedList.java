public class LinkedList<t> {

    Node<t> head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(t value){
		Node<t> node = new Node<>(value);
        node.next = null;

        if(head == null) {
            head = node;
        } else {
            Node<t> n = head;
            while(n.next != null){
                n = n.next;
            }
            n.next = node;
        }

	}
	
	public void print() {
        Node<t> newNode = head;
        int position = 1;
		System.out.println("------ begins ----");
        while(newNode.next != null){
            System.out.printf("Position:%d Data:%s\n", position, newNode.data);
            position++;
            newNode = newNode.next;
        }
        System.out.printf("Position:%d Data:%s\n", position, newNode.data);
        System.out.println("------ ends ----\n");
	}
	
}

class Node <t>{
    t data;
    Node<t> next;

    public Node(t data){
        this.data = data;
        this.next = null;
    }
}

public class Driver {

	public static void main(String[] args) {
		Queue TicketQueue = new Queue();
		
		
	TicketQueue.Add("Jenny");
	TicketQueue.Add("Jason");
	TicketQueue.Add("Joe");
	TicketQueue.Add("Jeremy");
	TicketQueue.Add("Leo");
	TicketQueue.Add("Pimal");
	TicketQueue.Add("Weston");
	TicketQueue.Add("Karen");
	TicketQueue.Add("Gertrude");
	TicketQueue.Add("Maya");
	TicketQueue.Add("Jimmy");
	System.out.printf("[*]There are %d people in the Queue.\n", TicketQueue.getSize());
	TicketQueue.printQueue();
	
	for(int i = 0; i < 5; i++) {
		System.out.printf("[*]Next to get a ticket is: %s.\n", TicketQueue.nextUp());
		System.out.printf("[*]Karen, you have %d people in front of you, please wait!\n",TicketQueue.NumInFront("Karen") );
		System.out.printf("[*]%s, You just got your ticket!\n", TicketQueue.Process());
	}

	
	System.out.printf("[*]There are %d people in the Queue.\n", TicketQueue.getSize());
	TicketQueue.printQueue();
	System.out.println("[*]Sorry, the ticket Queue is now closed\n");
	}

}
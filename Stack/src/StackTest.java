
public class StackTest {

	public static void main(String[] args) {
		Stack theStack = new Stack();
		
		System.out.println("The original list");
		theStack.printList();
		
		for(int i=1;i<=10;i++)
		theStack.push(i);
		
		theStack.printList();
		System.out.println();
		
		System.out.println("Popped: "+theStack.pop());
		theStack.printList();	
		System.out.println();
		
		System.out.println("Peeked: "+theStack.peek());
		theStack.printList();
		System.out.println();
		
		System.out.println("Searched: 5");
		System.out.println("Index: "+theStack.search(5));
		theStack.printList();
		System.out.println();
		
		System.out.println("Moved: 5");
		theStack.move(5);
		theStack.printList();
		System.out.println();
		
		System.out.println("Moved: 666");
		theStack.move(666);
		theStack.printList();
		System.out.println();	
		
	}

}

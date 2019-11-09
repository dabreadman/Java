import java.util.*;

public class Stack {
	
	private static ArrayList<Integer> list=new ArrayList<Integer>();

	public static void main(String[] args) {
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		push(7);
		push(8);
		System.out.println(pop());
		System.out.println(peek());
		System.out.println(search(4));
		move(6);
		list.forEach(number->System.out.print(number+", "));

	}

	public static void push(int obj){
		list.add(obj);
	}

	public static int pop(){
		int obj = list.get(list.size()-1);
		list.remove(list.size()-1);
		return obj;
	}

	public static int peek(){
		if(list.size()>0)
			return list.get(list.size()-1);
		else
			return -1;
	}

	public static int search(int obj){
		int target = obj;
		
		for(int i =0;i<list.size()-1;i++)
		{
			if (list.get(i).equals(target))
				return i;
		}
		return -1;
	}

	public static void move(int obj){
		int index = search(obj);
		if(index!=-1)
		{
			//	String theString = list.get(index);
			list.remove(index);
			list.add(0,obj);
		}
	}
	
	public static void printList(){
		list.forEach(number->System.out.print(number+ " "));
		
	}
}

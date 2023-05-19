package csw2_ch6;
import java.util.*;
public class linkedlist {

	public static void main(String[] args) {
		LinkedList<Integer> l=new LinkedList();
		l.add(2);
		l.add(3);
		l.addFirst(1);
		System.out.println(l);
		l.removeLast();
		System.out.println(l);
		l.removeFirst();
		System.out.println(l);
		
	}

}

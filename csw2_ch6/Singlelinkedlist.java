package csw2_ch6;
import java.util.*;
public class Singlelinkedlist {
	 static Node head;
 class Node{
	 int data;
	 Node next;
	public Node(int data ) {	
		this.data=data;
		this.next=null;
	}
}
public void AddLast(int data) {
   Node	newNode = new Node(data);
	if(head==null) {
		head=newNode;
	}
	else {
		Node curr=head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=newNode;
	}
}
public void AddFirst(int data) {
	Node newNode=new Node(data);
	if(head==null) {
		head=newNode;
	}
	else {
		newNode.next=head;
		head=newNode;
	}
}

public  void Print() {
	Node curr=head;
	if(curr==null) {
		System.out.println("List is empty"); 
		return;
	}
	while(curr!=null){
		System.out.print(curr.data+" ");
		curr=curr.next;
	}
	System.out.println();
}
public  void DeleteFirst() {
	if (head == null){
        System.out.println("List is empty");
        return;
    }
    head = head.next;
}
public  void DeleteLast() {
	if(head.next.next!=null) {
		Node curr=head;
		while(curr.next.next!=null) {
			curr=curr.next;
		}
		curr.next=null;
	}
	else {
	head=null;
	}
}
public boolean DeleteNode(int data) {
	if(head==null) {
		return false;
	}
	Node curr=head;
	if(head.data==data) {
		head=head.next;
		return true;
	}
	while (curr.next != null) {
		if (curr.next.data == data) {
		curr.next = curr.next.next;
		return true;
		}
		curr = curr.next;
		}
		return false;
}
public void reverse() {
	Node curr=head;
	Node prev=null;
	Node next=null;
	while(curr!=null) {
		next=curr.next;
		curr.next=prev;
		prev=curr;
		curr=next;
	}
	head=prev;
}
public int size() {
	int count=0;
	Node curr=head;
	while(curr!=null) {
		count++;
		curr=curr.next;
	}
	return count;
}
public void sort() {
	if(head==null) {
		return;
	}
	Node curr=head;
	Node curr2=curr.next;
	if(curr!=null) {
	while(curr.next!=null) {
		if(curr.data>curr2.data) {
			int temp=curr.data;
			curr.data=curr2.data;
			curr2.data=temp;					
		}
		curr=curr.next;
		curr2=curr2.next;
	 }
	}
	
}
public void sortedinsert(int data) {
	Node newNode=new Node(data);
	Node curr=head;
	Node prev=null;
	if(curr.next==null||curr.data>data) {
		newNode.next=head;
		head=newNode;
		return;
	}
	while(curr!=null && curr.data<data) {
		prev=curr;
		curr=curr.next;
	}
	if(prev!=null) {
		prev.next=newNode;
		newNode.next=curr;
	}else {
		newNode.next=curr;
		head=newNode;
	}
	
}
public void deleteNodes(int data) {
	Node curr=head;
	Node prev=null;
	while (curr!= null && curr.data ==data){
	   head=curr.next;
       curr= head;
	}
	while (curr!= null) {
		while(curr!=null && curr.data!=data) {
			prev=curr;
			curr=curr.next;
		}
		if(curr==null) {
			return;
		}
		prev.next=curr.next;
		curr=prev.next;
	}
	
}
public boolean Search(int data) {
	Node curr=head;
	while(curr!=null){
		if(curr.data==data) 
			return true;
			curr=curr.next;		
	}
	return false;
}
public void removeDuplicates() {
	Node curr=head;
	while(curr.next!=null) {
		if(curr.data==curr.next.data) {
			curr.next=curr.next.next;
		}
		curr=curr.next;
	}
}
public Singlelinkedlist reverseCopy() {
	Singlelinkedlist reversedList = new Singlelinkedlist();
    Node curr = head;
    while (curr != null) {
        Node newNode = new Node(curr.data);
        newNode.next = reversedList.head;
        reversedList.head = newNode;
        curr= curr.next;
    }
    return reversedList;
  }
public Singlelinkedlist copyList() {
  Node headNode = null;
  Node tailNode = null;
  Node tempNode = null;
  Node curr = head;
  if (curr == null)
     return null;
  headNode = new Node(curr.data);
  tailNode = headNode;
  curr = curr.next;
  while (curr != null) {
      tempNode = new Node(curr.data);
      tailNode.next = tempNode;
      tailNode = tempNode;
      curr = curr.next;
  }
 Singlelinkedlist ll2 = new Singlelinkedlist();
 ll2.head = headNode;
 return ll2;
}
public boolean loopDetect() {
   Node slowPtr;
   Node fastPtr;
   slowPtr = fastPtr = head;
   while (fastPtr.next != null && fastPtr.next.next != null) {
     slowPtr = slowPtr.next;
     fastPtr = fastPtr.next.next;
     if (slowPtr == fastPtr) {
         System.out.println("loop found");
         return true;
     }
   }
System.out.println("loop not found");
return false;
}
	public static void main(String[] args) {
		Singlelinkedlist l=new Singlelinkedlist();
		l.AddLast(2);
		l.AddFirst(1);
		l.Print();
		l.AddLast(3);
		l.AddLast(4);
		l.Print();
		l.DeleteLast();
		l.Print();
		l.DeleteFirst();
		l.Print();
		System.out.print("After reversing the list elements are : ");
		l.reverse();
		l.Print();
		System.out.println("Size of the array: "+l.size());
		l.AddLast(6);
		l.AddLast(4);
		l.sort();
		System.out.print("After sorting the list elements are:");
		l.Print();
		l.sortedinsert(5);
		l.sortedinsert(2);
		l.sortedinsert(4);
		System.out.print("After insert the element in a sorted list is :");
		l.Print();	
		l.deleteNodes(4);
		System.out.print("After delete all the accurances of an element in a sorted list is :");
		l.Print();	
		l.removeDuplicates();
		System.out.print("After removing the duplicate elements list is : ");
		l.Print();
		System.out.println(l.Search(3));
		System.out.print("After deleting a node the linkedlist is: ");
		l.DeleteNode(3);
		l.Print();
		l.copyList();
		System.out.print("After copying the elments into an another linked list is:");
		l.Print();
	    Singlelinkedlist reversedList = l.reverseCopy();
	        System.out.print("Reversed List: ");
	        reversedList.Print();
	    System.out.println("Loop is present or not?");
	    System.out.print( l.loopDetect());
		
	}

}

package csw2_ch6;
import java.util.*;
import java.util.ArrayList;

class Node {
    public int data;
    public Node next;
}
 
class NodeOperation {
 
    public void pushNode(Node[] headRef, int dataVal) {
    
        Node newNode = new Node();
    
        newNode.data = dataVal;
     
        newNode.next = headRef[0];
      
        headRef[0] = newNode;
    }
}

public class doubleLinkedlist {
    public static void main(String[] args) {
        Node[] head = new Node[1];
        NodeOperation temp = new NodeOperation();
        for (int i = 5; i > 0; i--) {
            temp.pushNode(head, i);
        }
        ArrayList<Integer> v = new ArrayList<Integer>();
        Node curr = head[0];
        while (curr != null) {
            v.add(curr.data);
            curr = curr.next;
        }
        System.out.print("Middle Value Of Linked List is : ");
        System.out.println(v.get(v.size() / 2));
    }
}

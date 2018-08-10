package ImplementedDemo;
import java.io.IOException;
import java.util.HashMap;

public class LinkedListDemo {
	ListNode head;
	LinkedListDemo(){
		head=null;
	}
	public ListNode getHead(){
		return head;
	}
	
	public void insertAtBegin(ListNode node){
		node.next=head;
		head=node;
	}
	
	public void insertAtEnd(ListNode node){
		if(head==null){
			head=node;
		}
		else{
			ListNode p=head;
			while(p.next!=null){
				p=p.next;
			}
			
			p.next=node;
		}
	}
	public void insertAfterVal(ListNode node, int  val){
		if(containsCheck(val)){
			ListNode p=head;
			while(p.data!=val){
				p=p.next;
			}
			
			node.next=p.next;
			p.next=node;
			System.out.println("Value inserted after "+ val);
		}
		else{
			System.out.println("Value not present");
		}
	}
	public void removeAtBegin(){
		if(head==null)
			System.out.println("No node preset");
		else{
			head=head.next;
			System.out.println("Removed the first one");
			
		}
	}
	public void removeAtEnd(){
		if(head==null)
			System.out.println("No node present");
		else{
			ListNode p=head;
			if(p.next==null)
				head=null;
			else{
				while(p.next.next!=null){
					p=p.next;
				}
				p.next=null;
				System.out.println("Removed the last one");
			}
			
			
		}
		
	}
	public void removeWithVal(int val){
		if(containsCheck(val)){
			ListNode p=head;
			if(p.data==val){
				p=p.next;
				head=p;
			}
			else{
				while(p.next.data!=val)
					p=p.next;
				p.next=p.next.next;
			}
			System.out.println("Value removed "+ val);
		}
		else{
			System.out.println("Value not present");
		}
	}
	public boolean containsCheck(int  val){
		if(head==null){
			return false;
		}
		else{
			ListNode p=head;
			while(p.data!=val && p.next!=null){
				p=p.next;
			}
			if(p.data==val)
				return true;
			else
				return false;
		}
	}
	public void displayLL2(){
		ListNode p=head;
		while(p.next!=null){
			System.out.println(p.data);
			p=p.next;
		}
		System.out.println(p.data);
	}
	public void displayLL(){
		ListNode p=head;
		while(p.next!=null){
			System.out.print(p.data + "->");
			p=p.next;
		}
		System.out.println(p.data);
	}

	public int listLength(){
		if(head==null)
			return 0;
		ListNode p=head;
		int i=1;
		while(p.next!=null){
			p=p.next;
			i++;
		}
		return i;
	}
	public static boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> hm=new HashMap<ListNode, Integer>();
        hm.put(head,1);
        while(head!=null){
                head=head.next;
            if(hm.containsKey(head))
                return true;
            else{
                hm.put(head,1);
            }
        }
        if(head==null)
            return false;
        return true;
    }
	public int ElementAtk(int k){
		int data=0;
		int total=listLength();
		data=total-k;
		ListNode p=head;
		for(int i=1;i<=data;i++){
			p=p.next;
		}
		return p.data;
	}
	public int ElementAtkRunnerTechnique(int k){
		ListNode q, p;
		q = head;
		p = head;
		for(int i=1;i<k;i++){
			p=p.next;
		}
		while(p.next!=null){
			p = p.next;
			q = q.next;
		}
		return q.data;
	}
	public static void main(String[] args) throws IOException {
		LinkedListDemo lld=new LinkedListDemo();
	    System.out.println(lld.listLength());
		ListNode node=new ListNode(2);
		node.next=new ListNode(5);
		ListNode node1=new ListNode(1);
		node1.next=new ListNode(6);
		ListNode node2=new ListNode(11);
		ListNode node3=new ListNode(14);
		ListNode node4=new ListNode(18);
		ListNode node5=new ListNode(20);
		for(int i=20;i<30;i++)
		{
			lld.insertAtEnd(new ListNode(i));
		}
		lld.insertAtBegin(node);
		lld.insertAtBegin(node1);
		lld.insertAtBegin(node2);
		lld.insertAtBegin(node);
		hasCycle(node);
		lld.displayLL();
		int value=lld.ElementAtk(7);
		System.out.println("Element at kth position from end: "+ value);
		int value1=lld.ElementAtkRunnerTechnique(7);
		System.out.println("Element at kth position from end: "+ value1);
		lld.containsCheck(11);
		lld.displayLL();
		lld.insertAtEnd(node3);
		lld.insertAtEnd(node4);
		lld.insertAfterVal(node5,14);
		lld.displayLL();
		lld.removeAtBegin();
		lld.removeAtEnd();
		lld.displayLL();
		lld.removeWithVal(10);
		lld.displayLL();
		System.out.println(lld.listLength());
		
	}
	
	
}
class ListNode{
	int data;
	ListNode next;
	ListNode(int data){
		this.data=data;
	}
	public ListNode getNext(ListNode node){
		return node.next;
	}
	public void display(){
		System.out.println(data);
	}
}

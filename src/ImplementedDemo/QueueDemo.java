package ImplementedDemo;

import java.io.IOException;
import java.util.Stack;

public class QueueDemo {
	public static void main(String[] args) throws IOException {
		Queue q=new Queue();
		q.Enque(5);
		q.Enque(7);
		q.Deque();
		q.Enque(10);
		q.Enque(11);
		q.Deque();
		q.Deque();
		q.Deque();
		q.Deque();
	}
}
class Queue{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();;
	public void Push(int data){
		stack1.push(data);
	}
	public void Enque(int data){
		Push(data);
	}
	public void Deque(){
		if(stack1.isEmpty()){
			System.out.println("empty queue");
			return;
		}
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				int x=stack1.pop();
				stack2.push(x);
			}
			
			System.out.println("Popped element: "+ stack2.pop());
			while(!stack2.isEmpty()){
				int x=stack2.pop();
				stack1.push(x);
			}
		}
	}
	
}

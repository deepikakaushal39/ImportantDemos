package ImplementedDemo;

import java.io.IOException;

public class StackDemo {
	public static void main(String[] args) throws IOException {
		Stack stack=new Stack();
		for(int i=10;i<=200;i+=10)
			stack.push(i);
		stack.push(30);
		stack.peek();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.isEmpty();
		stack.pop();
		stack.peek();
		stack.pop();
		stack.pop();
		stack.isEmpty();
	}
}
class  Stack{
	int max_size=5;
	int a[];
	int top;
	public Stack() {
		a=new int[max_size];
		top=-1;
	}
	public void push(int val){
		top++;
		if(top>=max_size){
			System.out.println("Stack overload");
			top--;
		}
		else{
			a[top]=val;
		}
	}
	public int pop(){
		if(top<0){
			System.out.println("Stack empty");
			return -1;
		}
		else{
			int val=a[top];
			top--;
			//System.out.println("Popped value: "+ val);
			return val;
		}
	}
	public boolean isEmpty(){
		if(top==-1){
			System.out.println("Stack empty");
			return true;
		}
		else{
			//System.out.println("Stack isn't empty");
			return false;
		}
	}
	public int peek(){
		if(top==-1){
			//System.out.println("Stack empty");
			return -1;
		}
			
		else
			//System.out.println("Top element: "+ a[top]);
		return a[top];
	}
	
}




package day2;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack st=new Stack(5);
		st.push(0);
		st.push(3);
		st.push(3);
		st.push(3);
		st.push(3);
//		st.push(3);
		System.out.println("Peeked element "+st.peek());
		System.out.println("Popped element "+st.pop());
		
		
	}

}
class Stack{
	int[] st;
	int top;
	int size;
	Stack(int size)
	{
		this.size=size;
		top=-1;
		st=new int[size];
	}
	boolean isEmpty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	boolean isFull()
	{
		if(top==size-1)
			return true;
		else
			return false;
	}
	void push(int val)
	{
		if(!isFull())
		{
			st[++top]=val;
		}
		else
		{
			System.out.println("The Stack is Full..");
		}
	}
	int pop()
	{
		if(!isEmpty())
			return st[top--];
		else
			return st[top--];
	}
	int peek()
	{
		if(!isEmpty())
			return st[top];
		else 
			return -1;
	}
}
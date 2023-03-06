package day3;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedStack obj=new FixedStack();
		DynamicStack obj2=new DynamicStack(5);
		System.out.println("Fixed");
		obj.push(10);
		obj.push(11);
		obj.push(12);
		obj.push(13);
		System.out.println("popped...");
		obj.pop();
		System.out.println();
		obj.pop();
//		System.out.println("Dynamic");
//		obj2.push(3);
//		obj2.pop();
//		System.out.println(obj2.pop());
		
	}

}

interface Stack{
	abstract public  void push(int number);
	abstract public int pop();
}

class EdgeCases{
	public boolean isFull(int size,int top) {
		return (top==size-1)?true:false;
	}
	public boolean isEmpty(int top) {
		return (top==-1)?true:false;
	}
}

class FixedStack extends EdgeCases implements Stack{
	int[] st=new int[100];
	int top;
	FixedStack()
	{
		top=-1;
		
	}
	public void push(int number) {
		String status=!isFull(100,top)?(st[++top]=number)+"":"error";	
		if(status.equals("error"))
		{
			System.out.println("The Stack is Full");
		}
		else
		{
			display(top);
			System.out.println("After Pushing");
			
		}
		
		
	}
	public int pop()
	{
		display(top-1);
		return !isEmpty(top)?st[top--]:-1;
	}
	public void display(int t)
	{
		for(int i=0;i<=t;i++)
		{
			System.out.print(st[i]+" ");
		}
	}
}

class DynamicStack extends EdgeCases implements Stack{
	int[] st;
	int size;
	int top;
	DynamicStack(int size)
	{
		st=new int[size];
		top=-1;
		this.size=size;
	}
	public void push(int number) {
		String status=!isFull(size,top)?(st[++top]=number)+"":"error";
		if(status.equals("error"))
		{
			System.out.println("The Stack is Full");
		}
		else
		{
			System.out.println("Pushed");
		}
	}
	public int pop()
	{
		return !isEmpty(top)?st[top--]:-1;
	}
	
}
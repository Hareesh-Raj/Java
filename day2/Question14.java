package day2;

public class Question14 {

	public static void main(String[] args) {
		String name="Hareesh";
		int rollno=49;
		int sub1=90;
		int sub2=98;
		int sub3=89;
		Result obj=new Result(name,rollno,sub1,sub2,sub3);
		obj.calculateTotal();
		obj.printResult();
	}

}

class Student{
	private String name;
	private int rollno;
	Student(String name,int rollno)
	{
		setname(name);
		setrollnumber(rollno);
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public void setrollnumber(int rollno)
	{
		this.rollno=rollno;
	}
	public String getname()
	{
		return name;
	}
	public int getrollno()
	{
		return rollno;
	}
	public void printResult()
	{
		System.out.print(name+" "+rollno+" ");
	}
	
}

class Exam extends Student{
	private int sub1;
	private int sub2;
	private int sub3;
	Exam(String name,int rollno,int sub1,int sub2,int sub3)
	{
		super(name,rollno);
		setsub1(sub1);
		setsub2(sub2);
		setsub3(sub3);
	}
	public void setsub1(int mark1)
	{
		sub1=mark1;
	}
	public void setsub2(int mark2)
	{
		sub2=mark2;
	}
	public void setsub3(int mark3)
	{
		sub3=mark3;
	}
	public int getsub1()
	{
		return sub1;
	}
	public int getsub2()
	{
		return sub2;
	}
	public int getsub3()
	{
		return sub3;
	}
	@Override
	public void printResult()
	{
		super.printResult();
		System.out.print(sub1+" "+sub2+" "+sub3+" ");
	}
	
}

class Result extends Exam{
	private int totalmark;
	Result(String name,int rollno,int sub1,int sub2,int sub3)
	{
		super(name,rollno,sub1,sub2,sub3);
		totalmark=0;
	}
	public void calculateTotal()
	{
		totalmark=getsub1()+getsub2()+getsub3();
	}
	@Override
	public void printResult()
	{
		super.printResult();
		System.out.println(this.totalmark);
	}
}
package day2;

public class Question2 {

	public static void main(String[] args) {
		
		ComplexNumbers obj1=new ComplexNumbers(12,34);
		ComplexNumbers obj2=new ComplexNumbers(10,30);
		obj1.sum(obj2);;
	}

}

class ComplexNumbers{
	int num;
	int con;
	ComplexNumbers(int num,int con){
		this.num=num;
		this.con=con;
	}
	public void sum(ComplexNumbers obj1)
	{
		num=this.num+obj1.num;
		con=this.con+obj1.con;
		System.out.println(num+"+"+con+"i");
	}
}
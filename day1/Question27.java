package day1;

public class Question27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d=14000;
		System.out.println("Initial Amount.. "+d);
		double first_yr=14000+(d*0.4);
		System.out.println("First Year Amount.. "+first_yr);
		double sec_yr=first_yr-1500;
		System.out.println("Amount after second year.. "+sec_yr);
		double third_yr= (sec_yr*0.12)+sec_yr;
		System.out.println("Amount After third year.. "+third_yr);
	}

}

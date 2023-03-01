package Exercise4;

import java.util.Scanner;

interface ShoeSeller{
	abstract public Shoe sellShoe(Customer customer);
}

interface ShoeFactory{
	abstract public Shoe makeShoe(); 
}


abstract class ShoeShop implements ShoeSeller{
	ShoeFactory factory;
	abstract public  void setFactory();
	
	public ShoeFactory getFactory()
	{
		if(factory==null)
			setFactory();
		return factory;
	}
	abstract public Shoe sellShoe(Customer customer);
}

class AbdulShoeShop extends ShoeShop{
	public AbdulShoeShop() {
		
	}
	@Override
	public Shoe sellShoe(Customer customer) {
		
		return getFactory().makeShoe();
	}
	
	@Override
	public void setFactory() {
		factory=new BataShoeFactory();
	}
	
}

class NavinShoeShop extends ShoeShop{
	public NavinShoeShop() {
		
	}
	@Override
	public Shoe sellShoe(Customer customer) {
		return getFactory().makeShoe();
	}
	
	@Override
	public void setFactory() {
		factory=new LakhaniShoeFactory();
	}
	
}

class BataShoeFactory implements ShoeFactory{

	@Override
	public Shoe makeShoe() {
		
		return new LeatherShoe();
	}
	
}
class LakhaniShoeFactory implements ShoeFactory{

	@Override
	public Shoe makeShoe() {
		
		return new SportsShoe();
	}
	
	
}

class Customer{
	public void buyShoe() 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Shop name needed to buy..");
		String str=sc.next();
		try {
			ShoeShop shop=(ShoeShop)Class.forName(str).getConstructor().newInstance();
			System.out.println(shop.sellShoe(this));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

class Shoe{
	
}
class LeatherShoe extends Shoe{
	@Override
	public String toString() {
		
		return "Leather Shoe bought";
	}
}
class SportsShoe extends Shoe{
	@Override
	public String toString() {
		
		return "Sports Shoe bought";
	}
}

class ShoeImpl{
	public  void doProcess(Customer customer)
	{
		customer.buyShoe();
	}
}

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		ShoeImpl showRoom =new ShoeImpl();
		while(true) {			
			showRoom.doProcess(new Customer());	
		}
	}
}

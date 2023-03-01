package Exercise4;

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		
		ShoeShop shoe=ShoeImpl.doProcess();
		System.out.println(shoe.sellShoe(new Customer()));
	
	}
}

class ShoeImpl{
	public static ShoeShop doProcess() throws Exception
	{
		ShoeShop shop=(ShoeShop)Class.forName("Exercise4.AbdulShoeShop").newInstance();
		shop.setFactory((ShoeFactory)Class.forName("Exercise4.LakhaniShoeFactory").newInstance());
		return shop;
	}
}

interface ShoeSeller{
	abstract public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller{
	ShoeFactory factory;
	public  void setFactory(ShoeFactory factory)
	{
		this.factory=factory;
	}
	public ShoeFactory getFactory()
	{
		return factory;
	}
	abstract public Shoe sellShoe(Customer customer);
}


interface ShoeFactory{
	abstract public Shoe makeShoe(); 
}

class AbdulShoeShop extends ShoeShop{

	@Override
	public Shoe sellShoe(Customer customer) {
		
		return getFactory().makeShoe();
	}
	
}

class NavinShoeShop extends ShoeShop{

	@Override
	public Shoe sellShoe(Customer customer) {
		
		return getFactory().makeShoe();
	}
	
}

class BataShoeFactory implements ShoeFactory{

	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return new LeatherShoe();
	}
	
}
class LakhaniShoeFactory implements ShoeFactory{

	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return new SportsShoe();
	}
	
}
class Shoe{
	
}
class LeatherShoe extends Shoe{
	
}
class SportsShoe extends Shoe{
	
}
class Customer {
	
}
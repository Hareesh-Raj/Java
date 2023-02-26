package Exercise4;

public class DecoratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Icecream ibaco=new Vannila(new Chocolate(new Badam(new Chocolate())));
		System.out.println(ibaco.cost());
	}

}

abstract class Icecream {
	abstract public int cost();
}
abstract class Cream extends Icecream{

}
abstract class Toppings extends Icecream{
	
}

class Vannila extends Cream{
	Vannila()
	{
		
	}
	Icecream ip;
	Vannila(Icecream ip)
	{
		this.ip=ip; 
	}
	@Override
	public int cost() {
		if(ip==null)
			return 10;
		else
		return 10+ip.cost();
	}
	
}

class Chocolate extends Cream{
	Icecream ip;
	public Chocolate() {
		// TODO Auto-generated constructor stub
	}
	Chocolate(Icecream ip)
	{
		this.ip=ip; 
	}
	@Override
	public int cost() {
		if(ip==null)
			return 30;
		else
		return 30+ip.cost();
	}
	
}
class Badam extends Toppings{

	Icecream ip;
	public Badam() {
		// TODO Auto-generated constructor stub
	}
	Badam (Icecream ip)
	{
		this.ip=ip; 
	}
	@Override
	public int cost() {
		if(ip==null)
			return 5;
		else
		return 5+ip.cost();
	}
	
}
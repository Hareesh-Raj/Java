package Exercise5;
/*
 *@author Hareesh Raj Ramanathan
 *---BridgePattern---
 *We will go to this pattern when the subclass structure grows exponentially.
 *This will be used to create two different hierarchies.
 *This will create abstraction and implementation.
 *This will be used to develop the structures independent of each other.
 * In this Pizza and Restraunt are independent to each other.
 * */
public class BridgePattern {

	public static void main(String[] args) {
		Resturant customer=new AmericanResturant(new VeggiePizza());
		customer.deliver();
	}

}
/*
 * In this we are making a hierarchy of pizza in that we can create a hierarchy of many pizzas.
 * In that we need to implement the assemble method and quality check in it.
 */
abstract class Pizza{
	protected String sauce;
    protected String toppings;
    protected String crust;

    public abstract void assemble();
    public abstract void qualityCheck();
	
}
/*
 * In this we are making a hierarchy of resturant in that we can create a hierarchy of many restruant.
 * In that we need to implement the deliver.
 */
abstract class Resturant{
	protected Pizza pizza;
	protected Resturant(Pizza pizza)
	{
		this.pizza=pizza;
	}
	abstract void addSauce();
	abstract void makeCrust();
	abstract void addToppings();
	
	public void deliver()
	{
		
		makeCrust();
		addSauce();
		addToppings();
		pizza.assemble();
		pizza.qualityCheck();
	}
}

class AmericanResturant extends Resturant{

	protected AmericanResturant(Pizza pizza) {
		super(pizza);
		
	}

	@Override
	void addSauce() {
		
		pizza.sauce="chilly";
	}

	@Override
	void makeCrust() {
		
		pizza.crust="crispy";
	}

	@Override
	void addToppings() {
		pizza.toppings="pepporoni";
		
	}
	
}

class VeggiePizza extends Pizza{

	@Override
	public void assemble() {
		System.out.println("Adding Sauce: " + sauce);
        System.out.println("Adding Toppings: " + toppings);
        System.out.println("Adding Pepperoni");
	}

	@Override
	public void qualityCheck() {
		System.out.println("Crust is: " + crust);
	}
	
}
package Exercise4;

public class TemplatePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dominos dealer=new Sirius();
		dealer.execute();
	}

}

abstract class Dominos{
	private final void Uniform()
	{
		System.out.println("The Uniform with Blue shirt and red pant..");
	}
	private final void Wheat()
	{
		System.out.println("The Wheat type is declared..");
	}
	private final void tomatoes()
	{
		System.out.println("The tomato type is defined...");
	}
	protected final void packing() {
		System.out.println("The package size is fixed..");
	}
	public void execute()
	{
		Uniform();
		Wheat();
		tomatoes();
		packing();
		collectMoney();
		deliverPizza();
	}
	abstract public void collectMoney();
	abstract public void deliverPizza();
}

class Sirius extends Dominos{
	
	@Override
	public void collectMoney() {
		System.out.println("The money is collected in Ruoees");
		
	}

	@Override
	public void deliverPizza() {
		System.out.println("Deiver the pizza using car...");
		
	}
	
}
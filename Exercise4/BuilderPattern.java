package Exercise4;

public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone ph=new Phone.BuildPhone().setScreenSize("16").setProcessor("snapdragon").buildPhone();
		System.out.println(ph);
		
		Computer lap=new Computer.BuildComputer().setGraphicsCard("500 GB..").setNo_of_ports("5").setProcessor("M1 pro").setScreenSize("16").build();
		System.out.println(lap); 
	}

}

class Phone{
	
	class Cabinet{
		String screenSize;
		String processor;
		String battery;
		String os;
		public Cabinet(String screenSize , String processor,String battery,String os) {
			// TODO Auto-generated constructor stub
			this.screenSize=screenSize;
			this.processor=processor;
			this.battery=battery;
			this.os=os;
		}
	
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Cabinet=["+screenSize+","+processor+","+battery+","+os+"], ";
		}
		
	}
	Cabinet c;
	String brand;
	public Phone(BuildPhone ph)
	{
		brand="Apple";
		c=new Cabinet(ph.screenSize,ph.processor,ph.battery,ph.os);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return c+"brand :"+brand;
	}
	static class BuildPhone{
		String screenSize;
		String processor;
		String battery;
		String os;
		public BuildPhone setScreenSize(String screenSize) {
			this.screenSize = screenSize;
			return this;
		}
		public BuildPhone setProcessor(String processor) {
			this.processor = processor;
			return this;
		}
		public BuildPhone setBattery(String battery) {
			this.battery = battery;
			return this;
		}
		public BuildPhone setOs(String os) {
			this.os = os;
			return this;
		}
		public Phone buildPhone()
		{
			return new Phone(this);
		}
		
	}
}




class Computer{
	String screenSize;
	String processor;
	String graphicsCard;
	String no_of_ports;
	String brand;
	public Computer(BuildComputer bc)
	{
		this.screenSize=bc.screenSize;
		this.processor=bc.processor;
		this.graphicsCard=bc.graphicsCard;
		this.no_of_ports=bc.no_of_ports;
		brand="Apple";
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Computer=["+screenSize+","+processor+","+graphicsCard+","+no_of_ports+","+brand+" ]";
	}
	
	static class  BuildComputer{
		String screenSize;
		String processor;
		String graphicsCard;
		String no_of_ports;
		public BuildComputer setScreenSize(String screenSize) {
			this.screenSize = screenSize;
			return this;
		}
		public BuildComputer setProcessor(String processor) {
			this.processor = processor;
			return this;
		}
		public BuildComputer setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}
		public BuildComputer setNo_of_ports(String no_of_ports) {
			this.no_of_ports = no_of_ports;
			return this;
		}
		public Computer build()
		{
			return new Computer(this);
		}
	}
}
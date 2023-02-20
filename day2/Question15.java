package day2;

public class Question15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House house=new House(3000,250,350);
		System.out.println("Estimated Amount "+house.HouseAmount());
	}

}
class House{
	int area;
	Door door;
	Window window;
	int windowArea;
	int amount_per_sq_ft;
	House(int area,int doorArea,int windowArea)
	{
		door=new Door(doorArea);
		window=new Window(windowArea);
		this.area=area;
		amount_per_sq_ft=2000;
	}
	public int HouseAmount()
	{
		return (area*amount_per_sq_ft)+(window.windowAmount())+(door.doorAmount());
	}
}
class Door{
	int amount_per_sq_ft=20;
	int doorArea;
	Door(int area)
	{
		doorArea=area;
	}
	public int doorAmount()
	{
		return doorArea*amount_per_sq_ft;
	}
}
class Window{
	int amount_per_sq_ft=40;
	int windowArea;
	Window(int area)
	{
		windowArea=area;
	}
	public int windowAmount()
	{
		return windowArea*amount_per_sq_ft;
	}

}

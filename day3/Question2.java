package day3;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle obj=new Circle();
		System.out.println(obj.area(5));
		
		Cuboid obj2=new Cuboid();
		System.out.println(obj2.volume(5));
	}

}
interface calcArea{
	public float area(int ...dimension);
}
interface calcVolume{
	public float volume(int ...dimension);
}


class Circle implements calcArea {
	final float pi=3.14f;
	public float area(int ...dimension)
	{
		return pi*dimension[0]*dimension[0];
	}
}

class Square implements calcArea{
	public float area(int ...dimension)
	{
		return dimension[0]*dimension[0];
	}
}

class Triangle implements calcArea{
	public float area(int ...dimension)
	{
		return 0.5f*dimension[0]*dimension[1];
	}
}

class Sphere implements calcArea,calcVolume{
	final float pi=3.14f;
	public float area(int ...dimension)
	{
		return pi*dimension[0]*dimension[0];
	}
	public float volume(int ...dimension)
	{
		return (4/3)*pi*dimension[0]*dimension[0]*dimension[0];
	}
}

class Cuboid implements calcArea,calcVolume{
	public float area(int ...dimension)
	{
		return dimension[0]*dimension[0];
	}
	public float volume(int ...dimension)
	{
		return dimension[0]*dimension[0]*dimension[0];
	}
}
package Exercise5;

import java.util.ArrayList;
import java.util.List;
/*
 *@author Hareesh Raj Ramanathan
 *main method creating the object of Store
 *first we are storing the various state of the object the originator is used to store the object.
 *then caretaker manages various states of the memento object.
 * */
public class MementoPattern {

	public static void main(String[] args) {
		Store obj=new Store();
		CareTaker caretaker=new CareTaker();
		obj.name="Hareesh";
		Originator originator=new Originator();
		originator.setState(obj.name);
		
		caretaker.add(originator.saveStateToMemento());

		
		obj.name="Poorna";
		originator.setState(obj.name);
		
		caretaker.add(originator.saveStateToMemento());
		
		obj.name="Raj";
		originator.setState(obj.name);
		System.out.println(originator.getState());
		
		originator.getStateFromMemento(caretaker.get(1));
		System.out.println(originator.getState());
	}

}
/**
 * In Memento class we are creating a new data structure that can store a string. 
 * */
class Memento {
	private String state;
	/**
	 * Constructor 
	 * @param s of type String we are setting the value to the variable state.
	 * */
	public Memento(String s)
	{
		state=s;
	}
	/*
	 * @return String it will return the state.
	 */
	public String getState()
	{
		return state;
	}
	
}
/*
 * saveStateToMemento is used to create and return a memento object and assigned the state value to it.
 * getStateFromMemento will get the previous state and stores it in the current state.  
 * **/
class Originator{
	private String state;
	
	public void setState(String state)
	{
		this.state=state;
	}
	public String getState()
	{
		return state;
	}
	public Memento saveStateToMemento() 
	{
		return new Memento(state);
	}
	public void getStateFromMemento(Memento memento)
	{
		state=memento.getState();
	}
}
/*
 * mementoList is a arrayList object that stores the memento object in it.
 * */
class CareTaker
{
	private List<Memento> mementoList=new ArrayList<Memento>();
	
	public void add(Memento state) 
	{
		mementoList.add(state);
	}
	public Memento get(int index) 
	{
		return mementoList.get(index);
	}
}


class Store {
	String name;
}

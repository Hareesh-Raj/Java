package Exercise5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *@author Hareesh Raj Ramanathan
 *---FlyWeightPattern---
 *we will go for this pattern when we need to minimize the usage of internal storage.
 *and also to reduce the creation of object for the same unchanged values for the all objects (i.e intrinsic objects)
 *in that situation we need to create a  seperate class for storing the intrinsic and extrinsic variables.
 * */
public class FlyWeightPattern {
	
	public static void main(String[] args) {
		Store st=new Store();
		
		st.storeBook("bookname1",1200,"novel","ar","adventorous");
		st.storeBook("bookname2",1400,"novel","ar","adventorous");
		st.storeBook("bookname3",1600,"novel","ar","adventorous");
		
		st.storeBook("bookname5",1600,"book","arc","crime");
	}

}
/*
 * We are using the flyweight pattern because the type of the book will be 2 and that will be repeated for all the books instead of creating
 *  individual variable storage for all the objects we are creating a single storage.
 * */
class Book{
	private final String name;
    private final double price;
    private final BookType type;
    public Book(String name,double price,BookType type) {
		this.name=name;
		this.price=price;
		this.type=type;
	}
}
class BookType {
	private final String type;
    private final String distributor;
    private final String otherData;
	
    public BookType(String type,String distributor,String otherData) {
		this.type=type;
		this.distributor=distributor;
		this.otherData=otherData;
	}
  
}
class BookFactory{
	private static final Map<String,BookType> booktypes=new HashMap<>();
	public static BookType getBookType(String type,String distributor,String otherData)
	{
		if(booktypes.get(type)==null)
			{
			booktypes.put(type, new BookType(type,distributor,otherData));
			}
		
		return booktypes.get(type);
	}
}

/*
 *In the store book method we are checking whether a single object is created for the object of same type...
 *For type "novel" there is a single object created 
 *And there is three book same object is shared.
 *For type "book" there is a single object created 
 * */

class Store{
	private final List<Book> book=new ArrayList<>();
	public void storeBook(String name,double price,String type,String distributor,String otherData)
	{
		BookType booktype=BookFactory.getBookType(type, distributor, otherData);
		System.out.println(booktype);
		book.add(new Book(name,price,booktype));
	}
	
}
package Exercise2;

public class Question4 {

	public static void main(String[] args) {
		try {
			throw new OwnException("This the own Exception");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

class OwnException extends Exception{
	String msg;
	OwnException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}
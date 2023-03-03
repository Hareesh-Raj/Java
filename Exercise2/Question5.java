package Exercise2;

public class Question5 {

	public static void main(String[] args) throws OwnWithExceptionImpl {
		throw new OwnWithExceptionImpl("OwnException");
	}

}
class OwnWithExceptionImpl extends Exception{
	String msg;
	public OwnWithExceptionImpl(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}


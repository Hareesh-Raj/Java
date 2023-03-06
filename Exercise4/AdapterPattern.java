 package Exercise4;

public class AdapterPattern {

	public static void main(String[] args) {
//		LenovoPlug lp=new LenovoPlug();
//		IndianAdapter ip=new IndianAdapter();
//		ip.accept(lp);
//		SakthiSocket ss=new SakthiSocket();
//		
//		ss.roundPinHole(ip);//		ip.roundPin();
		
		
		
		KamatachiPlug kp=new KamatachiPlug();
		AmericanAdapter ap=new AmericanAdapter();
		ap.accept(kp);
		DaniSocket ds=new DaniSocket();
		ds.slabPinHole(ap);
		
	}

}

class IndianAdapter extends IndianPlug{

	AmericanPlug ap;
	public void accept(AmericanPlug pin)
	{
		ap=pin;
	}
	@Override
	public void roundPin() {
		// TODO Auto-generated method stub
		ap.slabPin();
	}
	
}

class AmericanAdapter extends AmericanPlug{

	IndianPlug ip;
	public void accept(IndianPlug ip)
	{
		this.ip=ip;
	}
	@Override
	public void slabPin() {
		ip.roundPin();
	}
	
}

abstract class IndianSocket{
	abstract public void roundPinHole(IndianPlug ip);
}

abstract class IndianPlug{
	abstract public void roundPin();
}

abstract class AmericanSocket{
	abstract public void slabPinHole(AmericanPlug ap);
}

abstract class AmericanPlug{
	abstract public void slabPin();
}


class KamatachiPlug extends IndianPlug{

	@Override
	public void roundPin() {
		System.out.println("Round Pin works");
	}
}

class DaniSocket extends AmericanSocket{

	@Override
	public void slabPinHole(AmericanPlug ap) {
		ap.slabPin();
		
	}
	
}


class SakthiSocket extends IndianSocket{

	@Override
	public void roundPinHole(IndianPlug ap) {
		ap.roundPin();
	}
	
}
class LenovoPlug extends AmericanPlug{

	@Override
	public void slabPin() {
		System.out.println("Charged Using slabpin");
		
	}
	
}
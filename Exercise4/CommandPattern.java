package Exercise4;

public class CommandPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv tv=new Tv();
		SoundSystem ss=new SoundSystem();
		Xbox xb=new Xbox();
		UniversalRemote remote=new UniversalRemote(5);
		remote.asignCommand(0, new NewsChannelCommand(tv, ss, xb));
		remote.asignCommand(1, new SerialCommand(tv, ss, xb));
		remote.asignCommand(2, new TTGameCommand(tv, ss, xb));
		
		remote.doCommand(4);
	}

}

class UniversalRemote {
	Tv tv;
	SoundSystem ss;
	Xbox xb;
	Command[] command;
	public UniversalRemote(int numberOfButtons) {
		command=new Command[numberOfButtons];
		for(int i=0;i<numberOfButtons;i++)
		{
			command[i]=new DummyCommand(tv, ss, xb);
		}
		// TODO Auto-generated constructor stub
	}
	public void asignCommand(int buttonNumber,Command c)
	{
		command[buttonNumber]=c;
	}
	public void doCommand(int number)
	{
		command[number].doCommand();
	}
}

abstract class Command{
	Tv tv;
	SoundSystem ss;
	Xbox xb;
	Command(Tv tv,SoundSystem ss,Xbox xb)
	{
		this.tv=tv;
		this.ss=ss;
		this.xb=xb;
	}
	abstract public void doCommand();
}
class SerialCommand extends Command{
	SerialCommand(Tv tv, SoundSystem ss, Xbox xb) {
		super(tv, ss, xb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand() {
		tv.serialChannel();
		ss.increaseVolume();
	}
	
}

class NewsChannelCommand extends Command{

	NewsChannelCommand(Tv tv, SoundSystem ss, Xbox xb) {
		super(tv, ss, xb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand() {
		tv.newsChannel();
		ss.increaseVolume();
	}
	
}

class TTGameCommand extends Command{

	TTGameCommand(Tv tv, SoundSystem ss, Xbox xb) {
		super(tv, ss, xb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand() {
		xb.ttGame();
		ss.decreaseVolume();
	}
	
}

class DummyCommand extends Command{

	DummyCommand(Tv tv, SoundSystem ss, Xbox xb) {
		super(tv, ss, xb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doCommand() {
		System.out.println("The Command need to be assigned...");
		
	}
	
}
class Tv{
	public void newsChannel()
	{
		System.out.println("News Channel..");
	}
	public void serialChannel()
	{
		System.out.println("Serial Channel..");
	}
}
class SoundSystem{
	public void increaseVolume()
	{
		System.out.println("The volume increased..");
	}
	public void decreaseVolume()
	{
		System.out.println("The Volume decreased..");
	}
}
class Xbox{
	public void ttGame()
	{
		System.out.println("The TT Game..");
	}
}
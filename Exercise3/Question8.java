  package Exercise3;

public class Question8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("A");
		
		ThreadDemo thread1=new ThreadDemo(sb);
		ThreadDemo thread2=new ThreadDemo(sb);
		ThreadDemo thread3=new ThreadDemo(sb);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}

class ThreadDemo extends Thread{
	StringBuffer sbr;
	ThreadDemo(StringBuffer sbr)
	{
		this.sbr=sbr;
	}
	@Override
	public void run() {
		synchronized(sbr) {
			for(int i=0;i<100;i++) {
				System.out.print(sbr+" ");
			}
			System.out.println();
			int val=sbr.charAt(0);
			val++;
			sbr.replace(0, 1,(char)val+"");			
		}
			
	}
}
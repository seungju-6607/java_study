package chapter17;

public class RunnableImpl implements Runnable{

	public RunnableImpl() {}
	
		public void run() {
			for(int i=1; i<=10; i++) {
				try {
				Thread.sleep(1000);
				System.out.println("Runnable ----> " + i);
				}	catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}

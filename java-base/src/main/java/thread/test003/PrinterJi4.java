package thread.test003;

public class PrinterJi4 implements Runnable {
	private FlagNum flagNum;
	public PrinterJi4(FlagNum flagNum) {
		super();
		this.flagNum = flagNum;
	}
	@Override
	public void run() {
		while(flagNum.getCount() > 0){
			if(!flagNum.isFlag()){
				System.out.println("22222");
				synchronized (flagNum) {
					flagNum.setCount(flagNum.getCount() - 1);
					flagNum.setFlag(!flagNum.isFlag());
					//唤醒等待这个锁释放的线程（打印奇数的）
					flagNum.notify();
				}
			}else{
				try {
					synchronized (flagNum) {
						//线程等待、等待被唤醒
						flagNum.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

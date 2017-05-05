package thread.test003;

public class PrinterJi2 implements Runnable {
	private Boolean flag;
	private Integer count;
	private Object lock;
	public PrinterJi2(boolean flag, Integer count,Object lock) {
		super();
		this.flag = flag;
		this.count = count;
		this.lock = lock;
	}
	@Override
	public void run() {
		while(count > 0){
			if(!flag){
				//如果是奇数 打印11111
				System.out.println("22222");
				synchronized (lock) {
					flag = !flag;
					count = count -1;
					//唤醒等待这个锁释放的线程（打印奇数的）
					lock.notify();
				}
			}else{
				try {
					System.out.println("打印偶数等待被唤醒");
					synchronized (lock) {
						//线程等待、等待被唤醒
						lock.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

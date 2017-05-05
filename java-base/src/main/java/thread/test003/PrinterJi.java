package thread.test003;

public class PrinterJi implements Runnable {
	private boolean flag;
	private Integer count;
	private Object lock;
	public PrinterJi(boolean flag, Integer count,Object lock) {
		super();
		this.flag = flag;
		this.count = count;
		this.lock = lock;
	}
	@Override
	public void run() {
		while(count > 0){
			System.out.println("执行线程1");
			if(flag){
				//如果是奇数 打印11111
				System.out.println("11111");
				synchronized (lock) {
					/**
					 * 这里赋值之后 和上面的flag内存地址不一致了
					 */
					flag = !flag;
					count = count -1;
					//唤醒等待这个锁释放的线程（打印偶数的）
					lock.notify();
				}
			}else{
				try {
					System.out.println("打印奇数等待被唤醒");
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
			System.out.println("执行线程11");
		}
	}

}

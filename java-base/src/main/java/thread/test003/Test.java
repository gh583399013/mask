package thread.test003;

public class Test {
	public static void main(String[] args) {
		/**
		 * 这里线程1 线程2都只会执行一次的原因是：
		 * 在执行了flag = !flag; 后flag的地址就变了，所以两个线程都进入了等待状态（等待对方唤醒），但是flag值又不变（值变了，但是不是同一个对象了）
		 * 所以两个线程都不会被对方唤醒 一直处于等待状态，因此执行一次就over了
		 */
		Boolean flag = true;
		Integer count = 1000;
		Object lock = new Object();
		PrinterJi printerJi = new PrinterJi(flag, count,lock);
		PrinterJi2 printerJi2 = new PrinterJi2(flag, count,lock);
		Thread thread1 = new Thread(printerJi);
		Thread thread2 = new Thread(printerJi2);
		thread1.start();
		thread2.start();
		
//		FlagNum f = new FlagNum(true, 10);
//		PrinterJi3 p3 = new PrinterJi3(f);
//		PrinterJi4 p4 = new PrinterJi4(f);
//		Thread thread1 = new Thread(p3);
//		Thread thread2 = new Thread(p4);
//		thread1.start();
//		thread2.start();
	}
}

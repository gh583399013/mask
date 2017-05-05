package io.test001;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	/**
	 * 001-文件处理示例
	 */
	public static void createFile() {
		File f = new File("D:/create.txt");
		try {
			f.createNewFile(); // 当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
			System.out.println("该分区大小" + f.getTotalSpace() / (1024 * 1024 * 1024) + "G"); // 返回由此抽象路径名表示的文件或目录的名称。
			f.mkdirs(); // 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
			// f.delete(); // 删除此抽象路径名表示的文件或目录
			System.out.println("文件名  " + f.getName()); // 返回由此抽象路径名表示的文件或目录的名称。
			System.out.println("文件父目录字符串 " + f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回
															// null。

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 002-文件输入流 我们写一个检测文件长度的小程序，别看这个程序挺长的，你忽略try catch块后发现也就那么几行而已。
	 * 
	 * 上面的程序存在问题是，每读取一个自己我都要去用到FileInputStream，我输出的结果是“---长度是： 64982
	 * 字节”，那么进行了64982次操作！可能想象如果文件十分庞大，这样的操作肯定会出大问题，所以引出了缓冲区的概念。可以将streamReader.
	 * read()改成streamReader.read(byte[]b)此方法读取的字节数目等于字节数组的长度，读取的数据被存储在字节数组中，
	 * 返回读取的字节数，InputStream还有其他方法mark,reset,markSupported方法，例如： markSupported
	 * 判断该输入流能支持mark 和 reset 方法。
	 * mark用于标记当前位置；在读取一定数量的数据(小于readlimit的数据)后使用reset可以回到mark标记的位置。
	 * FileInputStream不支持mark/reset操作；BufferedInputStream支持此操作；
	 * mark(readlimit)的含义是在当前位置作一个标记，制定可以重新读取的最大字节数，也就是说你如果标记后读取的字节数大于readlimit，
	 * 你就再也回不到回来的位置了。 通常InputStream的read()返回-1后，说明到达文件尾，不能再读取。除非使用了mark/reset。
	 */
	public static void fileInputStream() {
		// TODO 自动生成的方法存根
		int count = 0; // 统计文件字节长度
		InputStream streamReader = null; // 文件输入流
		try {
			streamReader = new FileInputStream(new File("D:/test001.txt"));
			// streamReader = new FileInputStream(new File("D:/David/Java/java
			// 高级进阶/files/tiger.jpg"));
			/*
			 * 1.new File()里面的文件地址也可以写成D:\\David\\Java\\java
			 * 高级进阶\\files\\tiger.jpg,前一个\是用来对后一个
			 * 进行转换的，FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
			 */
			while (streamReader.read() != -1) { // 读取文件字节，并递增指针到下一个字节
				count++;
			}
			System.out.println("---长度是： " + count + " 字节");
		} catch (final IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				streamReader.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	/**
	 * 003-复制文件并使用缓冲区
	 */
	public static void copyFile() {
		// TODO自动生成的方法存根
		byte[] buffer = new byte[512]; // 一次取出的字节数大小,缓冲区大小
		int numberRead = 0;
		FileInputStream input = null;
		FileOutputStream out = null;
		try {
			input = new FileInputStream("D:/create.txt");
			out = new FileOutputStream("D:/createCopy.txt"); // 如果文件不存在会自动创建
			while ((numberRead = input.read(buffer)) != -1) { // numberRead的目的在于防止最后一次读取的字节小于buffer长度，
				out.write(buffer, 0, numberRead); // 否则会自动被填充0
			}
		} catch (final IOException e) {
			// TODO自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				input.close();
				out.close();
			} catch (IOException e) {
				// TODO自动生成的 catch 块
				e.printStackTrace();
			}

		}
	}

	/**
	 * java读写对象 读写对象：ObjectInputStream 和ObjectOutputStream ，该流允许读取或写入用户自定义的类，
	 * 但是要实现这种功能，被读取和写入的类必须实现Serializable接口
	 */
	public static void readOrWriteObject() {
		// TODO自动生成的方法存根
		ObjectOutputStream objectwriter = null;
		ObjectInputStream objectreader = null;

		try {
			objectwriter = new ObjectOutputStream(new FileOutputStream("D:/student.txt"));
			objectwriter.writeObject(new Student("gg", 22));
			objectwriter.writeObject(new Student("tt", 18));
			objectwriter.writeObject(new Student("rr", 17));
			objectreader = new ObjectInputStream(new FileInputStream("D:/student.txt"));
			for (int i = 0; i < 3; i++) {
				System.out.println(objectreader.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				objectreader.close();
				objectwriter.close();
			} catch (IOException e) {
				// TODO自动生成的 catch 块
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		/* 001 */
//		createFile();
//		readOrWriteObject();
		try {
			copyFileTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void copyFileTest() throws Exception{
		FileInputStream fis = new FileInputStream("D:/test111.txt");
		FileOutputStream fos = new FileOutputStream("D:/test222.txt");
		byte[] buffer = new byte[1024];
		
		/*实际每次读取量*/
		int readNum = 0;
		/*每次读取量*/
		int readCount = 1024;
//		从off的位置开始放，放len个（off是数组buffer的位置）
//		read(byte[] b, int off, int len)
		while((readNum = fis.read(buffer, 0, readCount)) != -1){
			System.out.println("读取结果：" + readNum);
			System.out.println(buffer[0]+ "|" + buffer[1] + "|" + buffer[2]);
			fos.write(buffer, 0, readCount);
		}
		fis.close();
		fos.close();
		
	}
}
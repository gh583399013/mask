package io.test002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

public class Test {
	public static void StringReaderTest() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.println("请输入字符串:");
		char[] buffer = new char[10];
		int readNum = 0;
		while((readNum = isr.read(buffer, 0, buffer.length)) != -1){
			System.out.println(readNum);
			System.out.print("#" + new String(buffer));
		}
	}
	public static void FileReaderTest() throws IOException{
		FileReader fr = new FileReader("D:/test111.txt");
		BufferedReader br = new BufferedReader(fr);
		String text = null;
		while((text = br.readLine()) != null){
			System.out.println(text);
		}
	}
	
	public static void FileWriterTest() throws IOException{
		FileReader fr = new FileReader("D:/test111.txt");
		FileWriter fw = new FileWriter("D:/test333.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		BufferedReader br = new BufferedReader(fr);
		for(int i=0;i<10;i++){
			bw.write("insert into xxx");
			bw.newLine();
		}
		bw.flush();
		String text = null;
		while((text = br.readLine()) != null){
			System.out.println(text);
		}
	}
	
	public static void main(String[] args) {
		try {
//			StringReaderTest();
			StringReaderTest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

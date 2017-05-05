package reflect.test001;

import java.lang.reflect.Method;

public class Test {
	/**
	 * public Method[] getDeclaredMethods()对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。当然也包括它所实现接口的方法。
	 * @Decription TODO
	 * @param clazz
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @CreateTime 2016年12月16日上午10:58:49
	 * @author fengtao
	 */
	public static void getDeclaredMethod(Class<?> clazz) throws NoSuchMethodException, SecurityException{
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("获取所有public方法:");
		for(Method m:methods){
			System.out.println(m.getName());
		}
		System.out.println("获取指定方法");
		Method method = clazz.getDeclaredMethod("setId", int.class);
		System.out.println("获取指定方法名是:" + method.getName());
	}
	
	/**
	 * public Method[] getMethods()返回某个类的所有公用（public）方法包括其继承类的公用方法，当然也包括它所实现接口的方法。
	 * @Decription TODO
	 * @param clazz
	 * @CreateTime 2016年12月16日上午10:59:50
	 * @author fengtao
	 */
	public static void getMethod(Class<?> clazz){
		Method[] methods = clazz.getMethods();
		System.out.println("获取所有public方法:");
		for(Method m:methods){
			System.out.println(m.getName());
		}
	}	
	
	public static void main(String[] args) {
		//获取类声明所有方法名(...返回值 等等方法的所有信息都可以返回)（不包括父类的方法）
//		try {
//			getDeclaredMethod(Student.class);
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//获取类声明所有方法名(...返回值 等等方法的所有信息都可以返回)（包括父类的方法）
		try {
			getMethod(Student.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

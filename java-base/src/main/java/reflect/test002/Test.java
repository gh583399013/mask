package reflect.test002;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static Student changeStudentInfo(Student student) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Student result = student.getClass().newInstance();
		Method[] methods = student.getClass().getDeclaredMethods();
		for(Method m:methods){
			if(m.getName().startsWith("setId")){
				//设置私有方法可以调用
				m.setAccessible(true);
				m.invoke(result, 100);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		try {
			Student student = new Student();
			student = changeStudentInfo(student);
			System.out.println(student.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

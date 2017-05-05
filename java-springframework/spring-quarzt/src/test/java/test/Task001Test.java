package test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ft.task.SimpleClass;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-conf/applicationContext.xml"})
public class Task001Test {

	@Autowired
	private SimpleClass SimpleClass;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void printSimpleClassContent() {
		SimpleClass.print();
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}

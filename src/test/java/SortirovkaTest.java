

import static org.junit.Assert.*;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortirovkaTest {

	private int random;
	@BeforeClass
	public static void Test() {
		int random = (int) (Math.random()*40 +30);
	}
	
	@Test
	public void test() {
	
		int[]a = new int[8];
		for (int i = 0; i < 8; i++) {
			Test();
			a[i] = random;
		}
		
		boolean isSorted = false;
		int b;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i<(a.length-1);i++) {
				if(a[i] > a[i+1]) {
					isSorted = false;
					
					b=a[i];
					a[i] = a[i+1];
					a[i+1] = b;
			
				
			}
			}
		}
	for (int i = 0; i<7;i++) {
		assertTrue(a[i] >= a[i+1]);
	}
	}
	
	@AfterClass
	public static void AfterTest() {
		System.out.println("Тест выполнен");
	}
}



import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

	public class MassivTest {

		private static int random;

		@BeforeClass
		public static void TestRan() {
			random = (int) (Math.random()*40 + 30);
}
		@Test
		public void test() {
			int[] a = new int[8];
			for (int i = 0; i < 8; i++) {
				TestRan();
				a[i] = random;
				System.out.println(random);
			}
			assertTrue(a.length == 8);
			assertFalse(a==null);
}

}
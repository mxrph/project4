

import static org.junit.Assert.*;

import org.junit.Test;

	public class RandomTest {

	@Test
	public void test() {
		int randomnoe;
		randomnoe = (int) (Math.random()*40+ 30);
		System.out.println(randomnoe);
		assertTrue(randomnoe >= 30 && randomnoe <= 70);

	}

}

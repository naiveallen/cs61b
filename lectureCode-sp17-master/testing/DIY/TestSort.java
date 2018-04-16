import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the methods of the Sort class */
public class TestSort {

	@Test
	public void testSort(){
		String[] input = {"i", "have", "an", "egg"};
	String[] expected = {"an", "egg", "have", "i"};

		Sort.sort(input);
	assertArrayEquals(expected, input);
	}


}
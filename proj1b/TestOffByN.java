import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator OffByN = new OffByN(3);

    @Test
    public void testOffByN() {
        assertTrue(OffByN.equalChars('a', 'd'));
        assertTrue(OffByN.equalChars('d', 'a'));
        assertTrue(OffByN.equalChars('b', 'e'));
        assertFalse(OffByN.equalChars('a', 'a'));
        assertFalse(OffByN.equalChars('b', 'w'));
        assertFalse(OffByN.equalChars('s', 'f'));
    }

}

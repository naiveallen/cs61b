package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer(4);
        arb.enqueue(3.1);
        arb.enqueue(9.6);
        arb.enqueue(10.0);
        arb.enqueue(-5.2);
        assertEquals((Double)3.1, arb.peek());
        arb.dequeue();
        assertEquals((Double)9.6, arb.peek());
        arb.enqueue(5.5);
        assertEquals((Double)9.6, arb.peek());

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;

    /* Index for the next enqueue. */
    private int last;

    /* Array for storing the buffer data. */
    private T[] rb;

    private class bufferIterator implements Iterator<T> {
        private int index = first;
        private int count = 0;
        @Override
        public boolean hasNext() {
            return count < fillCount;
        }

        @Override
        public T next() {
        T val = rb[index];
        index++;
        if (index == capacity) {
            index = 0;
        }
        count++;
        return val;
    }
}

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        rb = (T[])new Object[capacity];
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        last++;
        if (last == capacity) {
            last = 0;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T val = rb[first];
        rb[first] = null;
        first++;
        if (first == capacity) {
            first = 0;
        }
        fillCount--;
        return val;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        T val = rb[first];
        return val;
    }

    // TODO: implement the code to support iteration.
    @Override
    public Iterator iterator() {
        return new bufferIterator();
    }

    public static void main(String[] args) {
        BoundedQueue<Double> bq = new ArrayRingBuffer<>(4);
        bq.enqueue(2.5);
        bq.enqueue(5.6);
        Iterator<Double> bqIterator = bq.iterator();
        while (bqIterator.hasNext()) {
            System.out.println(bqIterator.next());
        }
        /*for (double d : bq) {
            System.out.println(d);
        }*/
    }

}

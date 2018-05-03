import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * An array based implementation of the Map61B class.
 */
public class ArrayMap<K, V> implements Map61B<K, V>, Iterable<K>{
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[])new Object[100];
        values = (V[])new Object[100];
        size = 0;
    }

    public Iterator iterator() {
        return new keyIterator();
        // 或者可以直接用list的iterator。
        /*List<K> keyList = keys();
        return keyList.iterator();*/
    }

    private class keyIterator implements Iterator<K>{
        private int index;

        public keyIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public K next() {
            K returnVal = keys[index];
            index++;
            return returnVal;
        }
    }

    /** Returns the index of the given key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }


    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return index > -1;
    }

    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
            return;
        }
        values[index] = value;
        keys[index] = key;
    }

    public V get(K key) {
        int index = keyIndex(key);
        if(index == -1) {
            throw new IllegalArgumentException("Please input correct key!");
        }
        return values[index];
    }

    public int size() {
        return size;
    }

    public List<K> keys() {
        List<K> keysList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keysList.add(keys[i]);
        }
        return keysList;
    }

    @Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<>();
        am.put(2, 5);
        int expected = 5;
        assertEquals((Integer)expected, am.get(2));
    }

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
        m.put("apple", 2);

        /*ArrayMap.keyIterator mki = m.new keyIterator();
        while(mki.hasNext()) {
            System.out.println(mki.next());
        }*/

        for (String s : m) {
            System.out.println(s);
        }
    }
}

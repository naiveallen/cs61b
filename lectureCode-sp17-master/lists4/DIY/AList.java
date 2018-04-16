/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    public Item[] array;
    public int size;

    /** Creates an empty list. */
    public AList() {
        array = (Item[]) new Object[10];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size == array.length){
            resize(size * 2);
        }
        array[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return array[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return array[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item deleteitem = getLast();
        array[size - 1] = null;
        size--;
        return deleteitem;
    }

    private void resize(int capacity){
        Item[] newArray = (Item[]) new Object[capacity];
        System.arraycopy(array,0, newArray, 0, size);
        array = newArray;
    }
} 
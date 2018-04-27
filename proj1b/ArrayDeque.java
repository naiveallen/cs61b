public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] array;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        array = (Item[]) new Object[8];
        size = 0;
        first = 4;
        last = 5;
    }

    @Override
    public void addFirst(Item x) {
        array[first] = x;
        first--;
        size++;
        if(first == -1) {
            first = array.length - 1;
        }
        if(first == last) {
            expand();
        }
    }

    @Override
    public void addLast(Item x) {
        array[last] = x;
        last++;
        size++;
        if(last == array.length) {
            last = 0;
        }
        if(first == last) {
            expand();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if(first < last) {
            for(int i = first + 1; i < last; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }else{
            for (int i = first + 1; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            for (int j = 0; j < last; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public Item removeFirst() {
        if(size == 0){
            return null;
        }
        Item delete = array[(first + 1) % array.length];
        array[(first + 1) % array.length] = null;
        first++;
        size--;
        if(first == array.length) {
            first = 0;
        }
        if(size < array.length / 4 && array.length > 16) {
            shrink();
        }
        return delete;
    }

    @Override
    public Item removeLast() {
        if(size == 0){
            return null;
        }
        Item delete;
        if(last == 0) {
            delete = array[array.length - 1];
            array[array.length - 1] = null;
        }else{
            delete = array[last - 1];
            array[last - 1] = null;
        }
        last--;
        size--;
        if(last == -1) {
            last = array.length - 1;
        }
        if(size < array.length / 4 && array.length > 16) {
            shrink();
        }
        return delete;
    }

    @Override
    public Item get(int index) {
        if(index < 0 || index >= size()){
            return null;
        }
        if(first < last) {
            return array[index + first + 1];
        }else{
            if(index + first + 1 <= array.length - 1){
                return array[index + first + 1];
            }else{
                return array[index + first + 1 - array.length];
            }
        }
    }

    private void expand() {
        Item[] newArray = (Item[]) new Object[array.length * 2];
        System.arraycopy(array, first, newArray, 0, array.length - first);
        System.arraycopy(array, 0, newArray, array.length - first, last + 1);
        first = 0;
        last = array.length;
        array = newArray;
    }

    private void shrink() {
        Item[] newArray = (Item[]) new Object[array.length / 2];
        if(first < last){
            System.arraycopy(array, first, newArray, 0, last - first);
        }else{
            System.arraycopy(array, first, newArray, 0, array.length - first);
            System.arraycopy(array, 0, newArray, array.length - first, last + 1);
        }

        first = 0;
        last = size + 1;
        array = newArray;
    }

}

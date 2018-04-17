public class ArrayDeque<Item> {
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

    public void addFirst(Item x) {
        if(requireExpand()){
            plusResize();
        }
        array[first] = x;
        first--;
        size++;
    }

    public void addLast(Item x) {
        if(requireExpand()){
            plusResize();
        }
        array[last] = x;
        last++;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = first + 1; i < last; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void removeFirst() {
        if(size == 0){
            return;
        }
        array[first + 1] = null;
        first++;
        size--;
        if(requireShrink()){
            minusResize();
        }
    }

    public void removeLast() {
        if(size == 0){
            return;
        }
        array[last - 1] = null;
        last--;
        size--;
        if(requireShrink()){
            minusResize();
        }
    }

    public Item get(int index) {
        if(index < 0 || index >= size()){
            return null;
        }
        return array[index + first + 1];
    }

    private boolean requireExpand() {
        if(size >= array.length / 2 || last == array.length - 1
                || first == 0){
            return true;
        }else{
            return false;
        }
    }

    private void plusResize() {
        Item[] newArray = (Item[]) new Object[array.length * 2];
        int destPos = newArray.length / 2 - size / 2;
        System.arraycopy(array, first, newArray, destPos, size + 1);
        first = destPos;
        last = first + size + 1;
        array = newArray;
    }

    private boolean requireShrink() {
        if(size <= array.length / 4 && array.length > 16){
            return true;
        }else{
            return false;
        }
    }

    private void minusResize() {
        Item[] newArray = (Item[]) new Object[array.length / 2];
        int destPos = newArray.length / 2 - size / 2;
        System.arraycopy(array, first, newArray, destPos, size + 1);
        first = destPos;
        last = first + size + 1;
        array = newArray;
    }



    public static void main(String[] args) {
        ArrayDeque<String> a = new ArrayDeque<>();
        a.addLast("hello");
        a.addLast("yuanye");
        a.addLast("dell");
        a.printDeque();
        System.out.println(a.get(0));
    }
}
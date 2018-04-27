public interface Deque<Item> {

    void addFirst(Item x);

    void addLast(Item x);

    boolean isEmpty();

    int size();

    void printDeque();

    Item removeFirst();

    Item removeLast();

    Item get(int index);

}

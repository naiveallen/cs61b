public class LinkedListDeque<Item> implements Deque<Item> {
    private class Node{
        private Item val;
        private Node previous;
        private Node next;

        private Node(Item val, Node previous, Node next){
            this.val = val;
            this.previous = previous;
            this.next = next;
        }

        private Node() {
            this(null, null, null);
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Item x) {
        Node p = new Node(x, sentinel, sentinel.next);
        sentinel.next.previous = p;
        sentinel.next = p;
        size++;
    }

    @Override
    public void addLast(Item x) {
        Node p = new Node(x, sentinel.previous, sentinel);
        sentinel.previous.next = p;
        sentinel.previous = p;
        size++;
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
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        size--;
        Item item = sentinel.next.val;
        sentinel.next.next.previous = sentinel;
        sentinel.next = sentinel.next.next;
        return item;
    }

    @Override
    public Item removeLast() {
        size--;
        Item item = sentinel.previous.val;
        sentinel.previous.previous.next = sentinel;
        sentinel.previous = sentinel.previous.previous;
        return item;
    }

    @Override
    public Item get(int index) {
        if(index < 0 || index >= size){
            return null;
        }

        if(index < size / 2){
            Node p = sentinel.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.val;
        }else{
            Node p = sentinel.previous;
            for (int i = size - 1; i > index; i--) {
                p = p.previous;
            }
            return p.val;
        }
    }

    public Item getRecursive(int index) {
        if(index < 0 || index >= size){
            return null;
        }

        return helper(sentinel, index);
    }

    private Item helper(Node front, int index){
        if(index == 0) {
            return front.next.val;
        }
        return helper(front.next, index - 1);
    }

}

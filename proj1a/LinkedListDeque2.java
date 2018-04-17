public class LinkedListDeque2<Item> {
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

    public LinkedListDeque2() {
        sentinel = new Node();
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(Item x) {
        Node p = new Node(x, sentinel, sentinel.next);
        sentinel.next.previous = p;
        sentinel.next = p;
        size++;
    }

    public void addLast(Item x) {
        Node p = new Node(x, sentinel.previous, sentinel);
        sentinel.previous.next = p;
        sentinel.previous = p;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while(p != sentinel){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Item removeFirst() {
        Item item = sentinel.next.val;
        sentinel.next.next.previous = sentinel;
        sentinel.next = sentinel.next.next;
        return item;
    }

    public Item removeLast() {
        Item item = sentinel.previous.val;
        sentinel.previous.previous.next = sentinel;
        sentinel.previous = sentinel.previous.previous;
        return item;
    }

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

    public static void main(String[] args) {
        LinkedListDeque2<String> l = new LinkedListDeque2<>();
        l.addFirst("hello");
        l.addLast("yuanye");
        l.addFirst("One");
        l.addFirst("zero");
        l.addLast("chang");
        l.printDeque();
        System.out.println(l.getRecursive(5));
    }
}

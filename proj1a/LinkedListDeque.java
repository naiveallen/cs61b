public class LinkedListDeque<Item> {
    private class Node{
        private Item val;
        private Node previous;
        private Node next;

        private Node(Item val, Node previous, Node next) {
            this.val = val;
            this.previous = previous;
            this.next = next;
        }

        private Node() {
            this(null, null, null);
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedListDeque() {
        first = new Node();
        last = new Node();
        first.next = last;
        last.previous = first;
        size = 0;
    }

    public void addFirst(Item x) {
        Node newNode = new Node(x, first, first.next);
        first.next.previous = newNode;
        first.next = newNode;
        size++;
    }

    public void addLast(Item x) {
        Node newNode = new Node(x, last.previous, last);
        last.previous.next = newNode;
        last.previous = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = first;
        while(p.next != last) {
            p = p.next;
            System.out.print(p.val + " ");
        }
        System.out.println();
    }

    public Item removeFirst() {
        if(isEmpty()){
            return null;
        }
        Item item = first.next.val;
        first.next.next.previous = first;
        first.next = first.next.next;
        size--;
        return item;
    }

    public Item removeLast() {
        if(isEmpty()){
            return null;
        }
        Item item = last.previous.val;
        last.previous.previous.next = last;
        last.previous = last.previous.previous;
        size--;
        return item;
    }

    public Item get(int index) {
        if(index >= size || index < 0){
            return null;
        }

        if(index < size / 2){
            Node p = first.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.val;
        }else{
            Node p = last.previous;
            for (int i = size - 1; i > index; i--) {
                p = p.previous;
            }
            return p.val;
        }
    }

    public Item getRecursive(int index) {
        if(index >= size || index < 0){
            return null;
        }

        return helper(first, index);
    }

    private Item helper(Node first, int index) {
        first = first.next;
        if(index == 0) {
            return first.val;
        }

        return helper(first, index - 1);
    }


    public static void main(String[] args) {
        LinkedListDeque<String> l = new LinkedListDeque<>();

        l.addFirst("hello");
        l.removeLast();
        l.addLast("fff");
        l.printDeque();
        //System.out.println(l.get(1));
        System.out.println(l.getRecursive(0));
        }
        }
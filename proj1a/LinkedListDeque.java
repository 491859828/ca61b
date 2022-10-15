public class LinkedListDeque<T> {
    private int size = 0;
    private Node<T> frontGuard;
    private Node<T> first;
    private Node<T> last;

    private class Node<T> {
        Node<T> next;
        Node<T> pre;
        T item;
        public Node(T item) {
            pre = null;
            next = null;
            this.item = item;
        }
        public Node(T item, Node<T> pre, Node<T> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

    }

    public LinkedListDeque() {
        frontGuard = new Node<>(null);
        first = frontGuard;
        last = frontGuard;
    }

    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item, frontGuard, first);
        first.pre = newNode;
        frontGuard.next = newNode;
        first = newNode;
        last = frontGuard.pre;
        size++;
    }

    public void addLast(T item) {
        Node<T> newNode = new Node<>(item, last, frontGuard);
        last.next = newNode;
        frontGuard.pre = newNode;
        last = newNode;
        first = frontGuard.next;
        size++;
    }

    public T removeFirst() {
        if(size < 0) return null;
        T r = first.item;
        first = first.next;
        frontGuard.next = first;
        first.pre = frontGuard;
        last = frontGuard.pre;
        size--;
        return r;
    }

    public T removeLast() {
        if(size < 0) return null;
        T r = last.item;
        last = last.pre;
        last.next = frontGuard;
        frontGuard.pre = last;
        first = frontGuard.next;
        size--;
        return r;
    }
    public T get(int i) {
        if(i < 0 || i > size - 1) {
            return null;
        }
        Node<T> p = first;
        while(i != 0) {
            p = p.next;
            i--;
        }
        return p.item;
    }
    private T  getRecursive(Node<T> node, int i) {
        if(i == 0) {
            return node.item;
        }
        return getRecursive(node.next, i - 1);
    }
    public T getRecursive(int i) {
        return getRecursive(first, i);
    }
    public void printDeque() {
        int i = size;
        Node<T> p = first;
        while(i != 0) {
            System.out.print(p.item + " ");
            p = p.next;
            i--;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

}

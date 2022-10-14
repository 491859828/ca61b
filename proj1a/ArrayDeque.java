public class ArrayDeque <T> {
        private int nextFront = 0;
        private int nextRear = 1;
        private T[] items;
        private  int size;

        public ArrayDeque() {
            items = (T[]) new Object[8];
        }

        public int minusOne(int x) {
            return (x - 1 + items.length) % items.length;
        }

        public int addOne(int x) {
            return (x + 1 + items.length) % items.length;
        }

        public void inResize(int l) {
            T[] newItems = (T[]) new Object[l];
            for(int i = 0; i < nextRear; i++) {
                newItems[i] = items[i];
            }
            for(int i = l - 1, j = items.length - 1; i >= l - (items.length - 1 - nextRear); i--, j--) {
                newItems[i] = items[j];
            }
            nextFront = l - (items.length - 1 - nextRear) - 1;
            items = newItems;

        }

        public void deResize(T[] items, int l) {

        }

        public void addFirst(T item) {
            if(nextFront == nextRear) {
                inResize(items.length * 2);
            }
            items[nextFront] = item;
            nextFront = minusOne(nextFront);
            size++;
        }

        public void removeFirst() {
            items[addOne(nextFront)] = null;
            nextFront = addOne(nextFront);
        }


        public T getFirst() {
            return items[addOne(nextFront)];
        }

        public void addLast(T item) {
            if(nextFront == nextRear) {
                inResize(items.length * 2);
            }
            items[nextRear] = item;
            nextRear = addOne(nextRear);
            size++;
        }

        public T getLast() {
            return items[minusOne(nextRear)];
        }

        public void removeLast() {
            items[minusOne(nextRear)] = null;
            nextRear = minusOne(nextRear);
        }

    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(6);
        d.addLast(6);
        d.addLast(6);
        d.addLast(6);
        d.addFirst(2);
        d.addLast(5);
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(6);
        d.addLast(6);
        d.addLast(6);
        d.addLast(6);
        d.addFirst(2);
        d.addLast(5);
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(6);
        d.addLast(6);
        d.addLast(6);
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();
        d.removeLast();

    }

}

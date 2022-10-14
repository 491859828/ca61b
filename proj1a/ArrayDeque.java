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

        public void resize(int l) {
            T[] newItems = (T[]) new Object[l];
            if(nextFront < nextRear) {
                for(int j  = nextFront + 1, i = 0; j < nextRear; i++, j++) {
                    newItems[i] = items[j];
                }
                nextFront = newItems.length - 1;
                nextRear = size;
            }else{
                for(int i = 0; i < nextRear; i++) {
                    newItems[i] = items[i];
                }
                for(int i = l - 1, j = items.length - 1; i >= l - (items.length - 1 - nextFront); i--, j--) {
                    newItems[i] = items[j];
                }
                nextFront = l - (items.length - 1 - nextFront) - 1;
            }
            items = newItems;

        }


        public void addFirst(T item) {
            if(nextFront == nextRear) {
                resize(items.length * 2);
            }
            items[nextFront] = item;
            nextFront = minusOne(nextFront);
            size++;
        }

        public void removeFirst() {
            items[addOne(nextFront)] = null;
            nextFront = addOne(nextFront);
            size--;
            if(items.length >= 16 && size * 4 < items.length) {
                resize(items.length/2);
            }
        }


        public T getFirst() {
            return items[addOne(nextFront)];
        }

        public void addLast(T item) {
            if(nextFront == nextRear) {
                resize(items.length * 2);
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
            size--;
            if(items.length > 16 && ((double)size / items.length) < 0.25) {
                resize(items.length/2);
            }
        }

        public T get(int i) {
            if(i < 0 || i > size - 1) {
                return null;
            }
            return items[(nextFront + i + 1) % items.length];
        }

    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.addLast(5);
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        d.removeFirst();
        System.out.println(d.get(2));

    }

}

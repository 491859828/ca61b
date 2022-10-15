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

        public T removeFirst() {
            T r = items[addOne(nextFront)];
            items[addOne(nextFront)] = null;
            nextFront = addOne(nextFront);
            size--;
            if(items.length >= 16 && size * 4 < items.length) {
                resize(items.length/2);
            }
            return r;
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

        public T removeLast() {
            T r = items[minusOne(nextRear)];
            items[minusOne(nextRear)] = null;
            nextRear = minusOne(nextRear);
            size--;
            if(items.length > 16 && ((double)size / items.length) < 0.25) {
                resize(items.length/2);
            }
            return r;
        }

        public T get(int i) {
            if(i < 0 || i > size - 1) {
                return null;
            }
            return items[(nextFront + i + 1) % items.length];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void printDeque() {
            if(size < 0) return;
            if(nextFront > nextRear) {
                for(int i = nextFront + 1; i < items.length; i++) {
                    System.out.print(items[i] + " ");
                }
                for(int i = 0; i < nextRear; i++) {
                    System.out.print(items[i] + " ");
                }
                System.out.println();
                return;
            }
            for(int i = nextFront + 1; i < nextRear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }

    public static void main(String[] args) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addFirst(10);
        d.addLast(12);
        d.printDeque();
        System.out.println(d.size);
        System.out.println(d.isEmpty());
    }

}

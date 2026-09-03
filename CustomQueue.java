public class CustomQueue {
    private int[] data;
    private static final int DEFAULT_SIZE = 8;
    int end = 0;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        data[end++] = item;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }

        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception{
        CustomQueue queue= new CustomQueue();
        queue.insert(3);
        queue.insert(6);
        queue.insert(5);
        queue.insert(19);
        queue.insert(1);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();

        System.out.println(queue.remove());
        queue.insert(99);
        queue.display();

        //if specified size is greater than what we have inserted- all empty places are displayed as 0
    }
}

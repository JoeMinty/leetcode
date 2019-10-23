public class Leetcode622 {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println(queue.Rear());
    }
}

class MyCircularQueue {

    public int[] elements;

    public int size;

    public int head;

    public int tail;

    public int length;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        elements = new int[k];
        size = 0;
        head = 0;
        tail = -1;
        length = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (size == length) {
            return false;
        }
        tail = (tail + 1) % length;
        elements[tail] = value;
//        tail = (tail + 1) % length;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        elements[head] = 0;
        head = (head + 1) % length;
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size > 0) {
            return elements[head];
        }
        return -1;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size > 0) {
            return elements[tail];
        }
        return -1;

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == length;
    }
}

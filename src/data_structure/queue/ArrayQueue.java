package data_structure.queue;

public class ArrayQueue<T> {
    int front;
    int rear;
    int capacity;
    T[] queue;

    @SuppressWarnings("unchecked")
    ArrayQueue(int capacity){
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
        queue = (T[]) new Object[this.capacity];
    }

    public void enqueue(T element) {
        if(isFull()) {
            System.out.println("Queue is Full!");
            return;
        }

        rear = (rear+1) % this.capacity;
        queue[rear] = element;
    }

    public T dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        front = (front + 1) % this.capacity;
        return queue[front];
    }

    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }

        return queue[front+1];
    }

    public int size() {
        return Math.abs( (rear+1) - (front+1) );
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        if(isEmpty()) {
            System.out.println("Queue is already empty!");
        }
        else {
            front = -1;
            rear = -1;
            queue = (T[]) new Object[this.capacity];
            System.out.println("Queue has cleared!");
        }
    }

    public boolean isFull() {
        return (this.rear == this.capacity-1);
    }

    public boolean isEmpty() {
        if(front == rear) {
            front = -1;
            rear = -1;
        }
        return this.front == this.rear;
    }
}

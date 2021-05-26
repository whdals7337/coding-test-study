package data_structure.queue;

public class ListQueue<T> {
    private QueueNode<T> front;
    private QueueNode<T> rear;

    public ListQueue() {
        this.front = null;
        this.front = null;
    }

    public void enQueue(T item) {
        QueueNode<T> node = new QueueNode<>(item);

        if(isEmpty()){
            front = node;
        }else{
            rear.next = node;
        }
        rear = node;
    }

    public T deQueue() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            T item = front.data;
            front = front.next;
            if(front == null){
                rear = null;
            }
            return item;
        }
    }

    public T peek() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            return front.data;
        }
    }

    public void clear() {
        if(isEmpty()) {
            System.out.println("Queue is already empty!");
        }
        else {
            front = null;
            rear = null;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}

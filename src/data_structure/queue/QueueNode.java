package data_structure.queue;

public class QueueNode<T> {
    T data;
    QueueNode<T> next;

    public QueueNode() {
        this.next = null;
    }

    public QueueNode(T data){
        this.data = data;
        next = null;
    }

    public T getData(){
        return this.data;
    }
}
package data_structure.stack;

public class ListStack<T> {
    StackNode<T> top;

    public ListStack() {
        this.top = null;
    }

    public void push(T data) {
        StackNode<T> stackNode = new StackNode<>(data);
        stackNode.linkNode(top);
        top = stackNode;
    }

    public T peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return top.getData();
    }

    public T pop() {
        if (isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T data = top.getData();
        top = top.getNextNode();
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

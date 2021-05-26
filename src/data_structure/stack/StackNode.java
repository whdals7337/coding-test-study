package data_structure.stack;

public class StackNode<T> {
    private T data;
    private StackNode<T> nextStackNode;

    public StackNode(T data) {
        this.data = data;
        this.nextStackNode = null;
    }

    protected void linkNode(StackNode<T> stackNode) {
        this.nextStackNode = stackNode;
    }

    protected T getData() {
        return this.data;
    }

    protected StackNode<T> getNextNode() {
        return this.nextStackNode;
    }
}

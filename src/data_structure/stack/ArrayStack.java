package data_structure.stack;

import java.util.Arrays;

public class ArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private int top;
    private T[] stackArr;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.top = -1;
        this.stackArr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        this.top = -1;
        this.stackArr = (T[]) new Object[size];
    }

    public void push(T t) {
        if (isFull()) {
            resize(2 * stackArr.length);
        }
        stackArr[++top] = t;
    }

    public T pop() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        T item = stackArr[top--];

        if (isTooBigSize()) {
            resize(stackArr.length / 2);
        }

        return item;
    }

    public T peek() {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stackArr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == stackArr.length - 1;
    }

    private boolean isTooBigSize() {
        return top < (stackArr.length / 4);
    }

    private void resize(int newCapacity) {
        stackArr = Arrays.copyOf(stackArr, Math.max(DEFAULT_CAPACITY, newCapacity));
    }
}

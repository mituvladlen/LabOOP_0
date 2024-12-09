package oop.Lab3;

public class ArrayImplementation<T> implements Queue<T>{
    private T[] array;
    private int capacity;
    private final int front;
    private int rear;

    public ArrayImplementation() {
        initializeArray(0);
        this.front = 0;
        this.rear = -1;
    }
    public void initializeArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = array.length;
    }

    @Override
    public void enqueue(T element) {
        if(!isEmpty()){
            capacity++;
            T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, capacity-1);
            initializeArray(this.capacity);
            System.arraycopy(newArray, 0, array, 0, capacity-1);
        }else{
            capacity++;
            initializeArray(capacity);
        }
        array[++rear] = element;
    }
    @Override
    public void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return;
        }
        capacity--;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 1, newArray, 0, capacity);
        initializeArray(capacity);
        System.arraycopy(newArray, 0, array, 0, capacity);
        rear--;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek at.");
            return null;
        }
        return array[front];
    }
    @Override
    public int size(){
        return array.length;
    }
    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }
}
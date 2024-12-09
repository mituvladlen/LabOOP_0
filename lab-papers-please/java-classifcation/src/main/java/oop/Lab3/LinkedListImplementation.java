package oop.Lab3;

public class LinkedListImplementation<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListImplementation() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        size++;
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public void dequeue() {
        if(isEmpty()){
            System.out.println("The queue is empty. Nothing to dequeue.");
            return;
        }
        size--;
        this.head = head.next;

        //if queue becomes empty, tail should be null as well
        if(this.head == null){
            this.tail = null;
        }
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek at.");
            return null;
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

}
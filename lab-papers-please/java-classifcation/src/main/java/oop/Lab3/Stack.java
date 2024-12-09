package oop.Lab3;

public class Stack<T>{
    private Node<T> top;
    private int size;

    public Stack(){
        this.top = null;
        this.size = 0;
    }

    public void push(T element){
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty. Nothing to pop.");
            return;
        }
        top = top.next;
        size--;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("Stack is empty. Nothing to peek at.");
            return null;
        }
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        return size;
    }
}
package oop.Lab3;

public class DoubleStackImplementation<T> implements Queue<T>{
    private final Stack<T> inStack;
    private final Stack<T> outStack;

    public DoubleStackImplementation() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    @Override
    public void enqueue(T element) {
        inStack.push(element);
    }

    @Override
    public void dequeue() {
        if(isEmpty()){
            System.out.println("Queue is empty. Nothing to dequeue.");
            return;
        }
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.peek());
                inStack.pop();
            }
        }
        outStack.pop();
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek at.");
            return null;
        }
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.peek());
                inStack.pop();
            }
        }
        return outStack.peek();
    }

    @Override
    public int size() {
        return inStack.size() + outStack.size();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
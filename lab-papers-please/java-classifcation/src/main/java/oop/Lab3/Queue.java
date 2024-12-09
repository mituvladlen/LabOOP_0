package oop.Lab3;

public interface Queue<T>{
    void enqueue(T element); //add element to queue
    void dequeue(); //remove elem
    T peek(); //return first elem without removing
    boolean isEmpty();
    int size();
}
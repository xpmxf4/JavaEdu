package org.example;

public class CircularQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public CircularQueue(int[] queue, int size, int front, int rear) {
        this.queue = queue;
        this.size = size;
        this.front = front;
        this.rear = rear;
    }

    public boolean offer(int value) {
        if (size == queue.length) {
            return false; // 큐가 가득 참
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
        return true;
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return queue[front];
    }
}

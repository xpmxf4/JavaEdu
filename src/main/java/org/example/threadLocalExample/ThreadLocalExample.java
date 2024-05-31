package org.example.threadLocalExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    private static final ThreadLocal<Integer> userId = ThreadLocal.withInitial(() -> null);
    private static final ThreadLocal<String> transactionId = ThreadLocal.withInitial(() -> null);
    private static final ThreadLocal<String> session = ThreadLocal.withInitial(() -> null);

    public static Integer getUserId() {
        return userId.get();
    }

    public static void setUserId(Integer id) {
        userId.set(id);
    }

    public static String getTransactionId() {
        return transactionId.get();
    }

    public static void setTransactionId(String id) {
        transactionId.set(id);
    }

    public static String getSession() {
        return session.get();
    }

    public static void setSession(String s) {
        session.set(s);
    }

    public static void clear() {
        userId.remove();
        transactionId.remove();
        session.remove();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            setUserId(1);
            setTransactionId("TXN12345");
            setSession("Session1");
            System.out.println("Task 1 executed by " + Thread.currentThread().getName() +
                    ": UserId = " + getUserId() + ", TransactionId = " + getTransactionId() + ", Session = " + getSession());
            clear();
        };

        Runnable task2 = () -> {
            setUserId(2);
            setTransactionId("TXN67890");
            setSession("Session2");
            System.out.println("Task 2 executed by " + Thread.currentThread().getName() +
                    ": UserId = " + getUserId() + ", TransactionId = " + getTransactionId() + ", Session = " + getSession());
            clear();
        };

        Runnable task3 = () -> {
            setUserId(3);
            setTransactionId("TXN54321");
            setSession("Session3");
            System.out.println("Task 3 executed by " + Thread.currentThread().getName() +
                    ": UserId = " + getUserId() + ", TransactionId = " + getTransactionId() + ", Session = " + getSession());
            clear();
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown();
    }
}

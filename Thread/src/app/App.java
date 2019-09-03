package app;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class App {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new InnerApp(), "Thread1");
        Thread t2 = new Thread(new InnerApp(), "Thread2");
        // t1.run();
        t1.start();
        t2.start();
        t2.run(); // 이걸 실행하니 'main'이라고 출력된다.

        System.out.println("***************************");
        try {
            Runnable r = () -> System.out.print("run ");
            Thread t = new Thread(r);
            t.start();
            t.join(); // 스레드가 종료할 때 까지 기다린다.
            System.out.println("main "); // run main 출력됨.
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
        System.out.println("***************************");

        ArrayList<AtomicInteger> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("set=" + new AtomicInteger());
            list.add(new AtomicInteger());
        }

        for (int i = 0; i < list.size(); i++) {
            AtomicInteger value = list.get(i);
            value.incrementAndGet();
            if ((i % 2) == 0) value.compareAndSet(1, 5);
            System.out.println(value + " ");
        }
    }
}

class InnerApp implements Runnable {

    @Override
    synchronized public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}


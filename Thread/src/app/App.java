package app;

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
            System.out.println("main ");
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }
    }
}

class InnerApp implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
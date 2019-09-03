package app;

public class App {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new InnerApp(), "Thread1");
        Thread t2 = new Thread(new InnerApp(), "Thread2");
        // t1.run();
        t1.start();
        t2.start();
        t2.run(); // 이걸 실행하니 'main'이라고 출력된다.
    }
}

class InnerApp implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
import java.time.Month;

public class Main {

    static MyThread[] threads = new MyThread[12];

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 12; i++) {
            MyThread thread = new MyThread(i);
            threads[i-1] = thread;
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All threads finished");
    }
}
import java.time.Month;

public class Main {

    static MyThread[] threads = new MyThread[12];

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 12; i++) {
            MyThread thread = new MyThread(i);
            threads[i-1] = thread;
            thread.run();
        }

        long start = System.currentTimeMillis();
        boolean interruptAll = false;
        while(true) {
            for (MyThread thread :
                    threads) {
                thread.printThread();
                if (System.currentTimeMillis() - start >= 100000) {
                    interruptAll = true;
                    break;
                }
            }
            if (interruptAll) {
                for (MyThread thread :
                        threads) {
                    thread.interrupt();
                }
                break;
            }
        }
        System.out.println("All threads finished");
    }
}
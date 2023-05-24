import java.time.Month;

public class Main {

    static MyThread[] threads = new MyThread[12];

    public static void main(String[] args) throws InterruptedException {

        boolean interruptAll = false;
        long start = System.currentTimeMillis();

        while(!interruptAll) {
            for (int i = 1; i <= 12; i++) {
                MyThread thread = new MyThread(i);
                thread.setName(Month.of(i).toString());
                threads[i - 1] = thread;
                thread.start();
                thread.join();
                if (System.currentTimeMillis() - start >= 100000) {
                    interruptAll = true;
                    thread.interrupt();
                    break;
                }
            }
        }

        System.out.println("All threads finished");
    }
}
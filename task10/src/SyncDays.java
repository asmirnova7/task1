import java.time.Month;

public class SyncDays {

    public static boolean isLocked = false;
    public synchronized void printMonth(int monthNum) throws InterruptedException {

        if (!Thread.currentThread().interrupted()) {
            while (isLocked) {
                wait();
            }

            isLocked = true;
            boolean interruptAfter = false;
            System.out.print("Days of " + Thread.currentThread().getName() + ": ");
            for (int i = 1; i <= Month.of(monthNum).length(false); i++) {
                System.out.print(" " + i + " ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println();
            isLocked = false;
            notifyAll();
        }
    }
}

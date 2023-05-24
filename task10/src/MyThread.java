import java.time.Month;

class MyThread extends Thread {

    SyncDays syncDays;
    private int month = 0;

    public MyThread (int monthNum) {
        super(Month.of(monthNum).toString());
        month = monthNum;
        syncDays = new SyncDays();
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        boolean interruptAll = false;
        while(true) {
            for (MyThread thread :
                    Main.threads) {
                try {
                    if (!thread.isInterrupted()) {
                        thread.printThread();
                    }
                } catch (InterruptedException e) {
                    break;
                }
                if (System.currentTimeMillis() - start >= 100000) {
                    interruptAll = true;
                    break;
                }
            }
            if (interruptAll) {
                for (MyThread thread :
                        Main.threads) {
                    thread.interrupt();
                }
                break;
            }
        }
    }

    public void printThread() throws InterruptedException {
        syncDays.printMonth(month, Month.of(month).toString());
    }
}

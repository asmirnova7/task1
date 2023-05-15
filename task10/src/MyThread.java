import java.time.Month;

class MyThread extends Thread {

    SyncDays syncDays;
    private int month = 0;

    public MyThread (int monthNum) {
        super(Month.of(monthNum).toString());
        month = monthNum;
    }

    @Override
    public void run() {
       syncDays = new SyncDays();
    }

    public void printThread() {
        syncDays.printMonth(month, Month.of(month).toString());
    }
}

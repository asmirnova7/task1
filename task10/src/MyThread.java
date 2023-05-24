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
       try {
           syncDays.printMonth(month);
       } catch (InterruptedException e) {
            throw new RuntimeException(e);
       }

    }
}

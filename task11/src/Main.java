import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Runnable> listTasks = new CopyOnWriteArrayList<>();
        Bank bank = new Bank(10);

        for(int i = 0; i < 10000; i++) {
            Runnable task = () -> bank.transfer();
            listTasks.add(task);
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();

        try {
            int num = 1;
            for (Runnable task:
                    listTasks) {
                System.out.println("Задача № " + num);
                Future<?> future = executor.submit(task);
                // Ждем 1 секунду, пока задача выполнится
                future.get(1, TimeUnit.SECONDS);
                //  через 100 с. выходим из цикла
                if (System.currentTimeMillis() - start >= 100000) {
                    future.cancel(true);
                    break;
                }
                num++;
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        catch (ExecutionException e) {
        }
        catch (TimeoutException e) {
        }
        finally {
            executor.shutdown();
        }
        System.out.println("Суммы на счетах:");
        bank.printAllAccountsSum();

    }
}
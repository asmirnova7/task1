import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;


public class Bank {

    private BigDecimal[] accounts;

    public Bank(int n) {
        accounts = new BigDecimal[n];

        for (int i = 0; i < n; i++) {
            BigDecimal temp = new BigDecimal("100.0");
            accounts[i] = temp;
        }
    }

    public BigDecimal sumAccountsInBank() {
        BigDecimal sum = new BigDecimal("0.0");

        if (accounts != null) {
            for (int i = 0; i < accounts.length; i++) {
                sum = sum.add(accounts[i]);
            }
        }

        return sum;
    }

    public void transfer() {

        if (accounts != null) {
            BigDecimal randomSum = new BigDecimal(ThreadLocalRandom.current().nextDouble(10, 21));
            int randomAccountFrom = ThreadLocalRandom.current().nextInt(0, accounts.length );
            int randomAccountTo = ThreadLocalRandom.current().nextInt(0, accounts.length);

            if (accounts[randomAccountFrom].compareTo(randomSum) == 1 ||
                    accounts[randomAccountFrom].compareTo(randomSum) == 0) {
                System.out.println("Перевод суммы " + randomSum + " со счета " + randomAccountFrom +
                                   " на счет " + randomAccountTo + ", поток " + Thread.currentThread().getName());
                accounts[randomAccountFrom] = accounts[randomAccountFrom].subtract(randomSum);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                accounts[randomAccountTo] = accounts[randomAccountTo].add(randomSum);
            }

            System.out.println("Баланс банка после перевода " + sumAccountsInBank().toString());
        }
    }

    public void printAllAccountsSum() {
        BigDecimal sum = new BigDecimal("0.0");
        if (accounts != null) {
            for (int i = 0; i < accounts.length; i++) {
                System.out.println(accounts[i].toString());
                sum = sum.add(accounts[i]);
            }
        }
        System.out.println("Баланс банка: " + sum.toString());
    }
}

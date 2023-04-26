import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {

        String answer = "y";

        do {
            System.out.println("Сыграем в игру ? (д/н)");

            Scanner scanner = new Scanner(in);
            answer = scanner.nextLine().toLowerCase();

            if (!answer.equals("д")) {
                System.out.println("Как хочешь. Пока!");
                break;
            }

            System.out.println("Загадай число из некоторого целого интервала чисел");
            System.out.println("Введи начало интервала = ");
            int min = scanner.nextInt();
            System.out.println("Введи конец интервала = ");
            int max = scanner.nextInt();

            if (max <= min) {
                throw new IncorrectIntervalException("Некорректный интервал!");
            }

            int len = (max - min) + 1;
            int[] array = new int[len];
            System.out.println("Твой интервал:");
            for (int i = 0; i < len; i++) {
                array[i] = min + i;
                System.out.printf(String.format(" %s ", array[i]));
            }

            searcher(array, len);

        } while (answer.equals("д"));

    }

    public static void searcher(int[] a, int n) {
        int n2 = n/2;
        if (n2 == 0)  {
            out.println(String.format("Не могу угадать :("));
            return;
        };
        int elem = a[n / 2];

        out.println();
        out.println(String.format("Это число %s ? (д/н)", elem));
        Scanner scanner = new Scanner(in);
        String answer = scanner.nextLine();

        if (answer.toLowerCase().equals("д")) {
            out.println("Ура! Победа!");
            return;
        }
        int[] array = new int[n2];

        out.println(String.format("Число %s больше или меньше загаданного ? (больше/меньше)", elem));
        answer = scanner.nextLine().toLowerCase();

        while(!Sign.more.isValInSign(answer)) {
            out.println("Поддерживаются только значения:");
            for (Sign sign : Sign.values()) {
                out.println(sign.getRussianTitle());
            }
            out.println(String.format("Число %s больше или меньше загаданного ? (больше/меньше)", elem));
            answer = scanner.nextLine().toLowerCase();
        }

        if (answer.equals(Sign.less.getRussianTitle()))
        {
            out.println("Новый массив:");
            for (int i = 0; i < n2; i++) {
                array[i] = a[i + n2];
                out.println(array[i]);
            }
        }
        if (answer.equals(Sign.more.getRussianTitle())) {
            out.println("Новый массив:");
            for (int i = 0; i < n2; i++) {
                array[i] = a[i];
                out.println(array[i]);
            }
        }

        searcher(array,n2);

        return;
    }
}
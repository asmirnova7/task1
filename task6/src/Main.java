public class Main {
    public static void main(String[] args) {

        String [][] arraySquare = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        String [][] arrayRect = {{"1","2","3"},{"1","1","1"},{"0","0","0"},{"2","1","0"}};
        String [][] arrayWithString = {{"1","a","3"},{"4","5","6"},{"7","8","9"}};

        try {
            System.out.println("Массив arraySquare:");
            int sum = checkArray(arraySquare);
            System.out.println(String.format("Сумма элементов = %s", sum));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Массив arrayRect:");
            int sum = checkArray(arrayRect);
            System.out.println(String.format("Сумма элементов = %s", sum));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Массив arrayWithString:");
            int sum = checkArray(arrayWithString);
            System.out.println(String.format("Сумма элементов = %s", sum));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int checkArray(String[][] array) throws WrongArrayDataException {
        int n = array.length;
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            if (array[i].length != n) {
                throw  new UnsupportedArraySizeException("Неправильный размер массива");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (RuntimeException e) {
                    throw  new WrongArrayDataException(String.format("Ошибка преобразования: строка %s, столбец %s", i, j));
                }
            }
        }
        return sum;
    }
}
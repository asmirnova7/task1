import java.util.Arrays;

public class Sortable implements SortingAlgorithm {

    @Override
    public void quickSort(String[] arr, int leftBorder, int rightBorder) {
        int i = leftBorder;

        int j = rightBorder;

        if (j - i >= 1)
        {
            String pivot = arr[i];
            while (j > i)
            {
                while (arr[i].compareTo(pivot) <= 0 && i < rightBorder && j > i) {
                    i++;
                }

                while (arr[j].compareTo(pivot) >= 0 && j > leftBorder && j >= i) {
                    j--;
                }

                if (j > i) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            String temp = arr[leftBorder];
            arr[leftBorder] = arr[j];
            arr[j] = temp;

            quickSort(arr, leftBorder, j - 1);
            quickSort(arr, j + 1, rightBorder);
        }
    }

    @Override
    public void arraySort(String[] arr) {
        Arrays.sort(arr);
    }
}

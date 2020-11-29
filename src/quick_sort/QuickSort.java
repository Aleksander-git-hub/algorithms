package quick_sort;

public class QuickSort
{
    public static void main(String[] args) {
        int[] array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        System.out.println(arrayToString(array));

        quickSort(array, 0, array.length - 1);
        System.out.println(arrayToString(array));

    }

    private static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = array[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index2];
        array[index2] = array[index1];
        array[index1] = temp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(array[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

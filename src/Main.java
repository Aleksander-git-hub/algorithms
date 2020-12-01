import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println("Заполняю массив...");
        fillArray(array);
        System.out.println(arrayToString(array));
        System.out.println("Сортирую массив...");
        quickSort(array, 0, array.length - 1);
        System.out.println(arrayToString(array));
        System.out.println("Введите число, которое хотите найти: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println("Поиск...");
        int result = binarySearch(array, 0, array.length - 1, value);
        if (result == -1) {
            System.out.println("Нет такого числа: " + value);
        } else {
            System.out.println("Число " + value + " под индексом " + result);
        }
    }

    private static int binarySearch(int[] array, int start, int end, int valueToFind) {
        if (end >= start) {
            int middleIndex = start + (end - start) / 2;
            if (array[middleIndex] == valueToFind) {
                return middleIndex;
            }
            if (array[middleIndex] > valueToFind) {
                return binarySearch(array, start, middleIndex - 1, valueToFind);
            } else {
                return binarySearch(array, middleIndex + 1, end, valueToFind);
            }
        }
        return -1;
    }

    private static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to);
            quickSort(array, from, divideIndex - 1);
            quickSort(array, divideIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;
        int pivot = array[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {

            while(array[leftIndex] < pivot) {
                leftIndex++;
            }

            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = (int) Math.round(Math.random() * 100);
            array[i] = value;
        }
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

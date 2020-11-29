package search_lin_and_bin;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        int[] array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};
        System.out.println(arrayToString(array));
        System.out.println("Сортирую массив...");
        quickSort(array, 0, array.length - 1);
        System.out.println("Массив отсортирован!");
        System.out.println(arrayToString(array));
        System.out.println("Введите число которое необходимо найти: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        //System.out.println(searchLinear(array, value));
        System.out.println(searchBinaryRecursive(array, 0, array.length - 1, value));
    }

    private static int searchBinaryRecursive(int[] array, int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }

            if (array[middleIndex] > elementToFind) {
                return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
            }
        }
        return -1;
    }

    private static int searchLinear(int[] array, int elementToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind) {
                return i;
            }
        }
        return -1;
    }

    private static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int middleIndex = partition(array, from, to);
            quickSort(array, from, middleIndex - 1);
            quickSort(array, middleIndex, to);
        }
    }

    private static int partition(int[] array, int from, int to) {
        int leftIndex = from;
        int rightIndex = to;

        int pivot = array[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {

            while (array[leftIndex] < pivot) {
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

package selection_sort;

public class Main
{
    public static void main(String[] args) {
        int[] array = new int[] {64,42,73,41,31,53,16,24,57,42,74,55,36};

        for (int step = 0; step < array.length; step++) {
            System.out.println(arrayToString(array));
            int index = min(array, step);
            int temp = array[index];
            array[index] = array[step];
            array[step] = temp;
        }
    }

    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
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
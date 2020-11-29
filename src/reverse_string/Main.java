package reverse_string;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Введите слово: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println(reverseString(answer));
    }

    private static String reverseString(String str) {
        char[] array = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            result.append(array[i]);
        }
        return result.toString();
    }
}

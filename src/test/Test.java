package test;

public class Test
{
    public static void main(String[] args) {
        System.out.println(fac(20));
    }

    private static long fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n-1);
    }

}

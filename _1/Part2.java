package _1;

public class Part2 {

    private static final double epsilon = Math.pow(10,-5);

    static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static  void main(String[] args){


        System.out.printf("%-15s %-15s %-10s%n", "x", "Сумма (S)", "Итераций (n)");
        for (double x = 0.1;x<=0.9;x+=0.1){
            double sum = 0;
            double res;
            int n = 1;
            do {
                res = ((2.0 * n + 1) / factorial(n)) * Math.pow(x, 2 * n);
                sum += res;
                n++;
            } while (Math.abs(res) > epsilon && n < 20);

            System.out.printf("%-15.4f %-15.4f %-10d%n", x, sum, n - 1);


        }

    }
}

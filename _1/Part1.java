package _1;

public class Part1 {


    private static final double a = 1.5;
    private static final double b =2;

    private static double func1(double x){
        return (Math.exp(x) - Math.exp(-x)) / 2;
    }


    private static double func2(double x){
        double drob= (x + 1) / Math.sqrt(x);
        return 0.25*(drob * Math.exp(Math.sqrt(x)) - Math.sqrt(x));

    }

    private static double func3(double x){
        return a*x + b;
    }


    public static void main(String[] args){
//        double b = 2;
//        double a =1.5;
        System.out.printf("%-10s %-10s%n", "x", "y");

        for (double x = -1;x<=4;x+=0.4){
            double y;
            if (x <= 0) {
                y = func1(x);
            } else if (x <= 3) {
                y = func2(x);
            } else {
                y = func3(x);
            }

            System.out.printf("%-10.4f %-10.4f%n", x, y);
        }
    }
}

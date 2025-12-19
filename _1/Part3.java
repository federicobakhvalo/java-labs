package _1;

public class Part3 {

    static boolean isAllowedValue(int value, int[] allowed) {
        for (int a : allowed) {
            if (value == a) {
                return true;
            }
        }
        return false;
    }

    public static  void main (String [] args) {
        int[] source = {1, 3, 5, 7, 9, 3};
        int[] allowed = {3, 7};
        int count = 0;
        for (int x : source) {
            if (!isAllowedValue(x, allowed)) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int x : source) {
            if (!isAllowedValue(x, allowed)) {
                result[index++] = x;
            }
        }
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

package _2._2;
import java.util.Scanner;

public class MainString2 {
//    3.	Написать программу, которая считывает с клавиатуры текст и выводит на экран толь¬ко строки,
//    содержащие двузначные числа

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите весь текст (строки через Enter, затем пустая строка для окончания):");

        // Считываем весь текст как одну строку с несколькими Enter
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;  // пустая строка — конец ввода
            sb.append(line).append("\n");
        }

        // Разделяем на массив строк
        String[] lines = sb.toString().split("\n");

        // Обрабатываем массив
        for (String line : lines) {
            if (containsTwoDigitNumber(line)) {
                System.out.println(line);
            }
        }

        scanner.close();
    }


    private static boolean containsTwoDigitNumber(String line) {
        int i = 0;
        while (i < line.length()) {
            char c = line.charAt(i);
            // Пропускаем нецифровые символы
            if (c < '0' || c > '9') {
                i++;
                continue;
            }
            int start = i;
            // Считываем последовательность цифр
            while (i < line.length() && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                i++;
            }
            int length = i - start;

            if (length == 2) {
                return true;
            }
        }
        return false;
    }


}

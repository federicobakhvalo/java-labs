package _2._2;
import java.util.Scanner;

public class MainString {

//    3)	Ввести с клавиатуры слово и символ.
//    Заменить в слове первую букву “A” на  символ.
//    Присоединить введенный символ к началу слова.  Вывести слово и символ.


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод слова
        System.out.print("Введите слово: ");
        String word = scanner.nextLine();

        // Ввод символа
        System.out.print("Введите символ: ");
        char symbol = scanner.next().charAt(0);

        // Замена первой буквы 'A' на введённый символ
        int index = word.indexOf('A');
        if (index != -1) {
            word = word.substring(0, index) + symbol + word.substring(index + 1);
        }

        // Присоединение символа к началу слова
        word = symbol + word;

        // Вывод результата
        System.out.println("Результат: " + word);
        System.out.println("Введённый символ: " + symbol);

        scanner.close();
    }
}

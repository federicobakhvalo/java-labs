package _3._4;

public class Main {

    public static  void main (String[] args) {
        Stack stack = new Stack();
        stack.push(1, 'A');
        stack.push(2, 'B');
        stack.push(3, 'C');
        System.out.println("Стек:");
        stack.printStack(); // (3, C) (2, B) (1, A)
        Item popped = stack.pop();
        System.out.println("Удалили элемент: (" + popped.d.number + ", " + popped.d.letter + ")");
        System.out.println("После удаления:");
        stack.printStack();
        System.out.println("Поиск (2, B): " + stack.contains(2, 'B')); // true
        System.out.println("Поиск (3, C): " + stack.contains(3, 'C')); // false
    }
}

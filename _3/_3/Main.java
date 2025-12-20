package _3._3;

public class Main {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1, 'A');
        q.enqueue(2, 'B');
        q.enqueue(3, 'C');
        System.out.println("Очередь:");
        q.printQueue(); // (1, A) (2, B) (3, C)
        System.out.println("Удаляем элемент: ");
        Item removed = q.dequeue();
        System.out.println("(" + removed.d.number + ", " + removed.d.letter + ")");
        System.out.println("После удаления:");
        q.printQueue(); // (2, B) (3, C)
        System.out.println("Поиск (3, C): " + q.contains(3, 'C'));

    }
}

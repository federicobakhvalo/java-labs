package _3._2;

public class Main {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("До обмена первого и последнего:");
        list.printList(); // 1 2 3 4
        list.swapFirstLast();
        System.out.println("После обмена первого и последнего:");
        list.printList(); // 4 2 3 1
    }
}


package _3._2;

public class CircularDoublyLinkedList {
    private Item head;
    public void add(int value) {
        Item newItem = new Item(value);
        if (head == null) {
            head = newItem;
            head.next = head;
            head.prev = head;
        } else {
            Item tail = head.prev;
            tail.next = newItem;
            newItem.prev = tail;
            newItem.next = head;
            head.prev = newItem;
        }
    }

    // Метод для печати списка (для проверки)
    public void printList() {
        if (head == null) {
            System.out.println("Список пустой");
            return;
        }

        Item current = head;
        do {
            System.out.print(current.d + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
    public void swapFirstLast() {
        if (head == null || head.next == head) {
            // Пустой список или один элемент — ничего менять не нужно
            return;
        }

        Item tail = head.prev;

        // Меняем данные
        int temp = head.d;
        head.d = tail.d;
        tail.d = temp;
    }
}

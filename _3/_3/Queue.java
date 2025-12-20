package _3._3;

public class Queue {
    private Item front;
    private Item rear;

    // Добавление элемента в конец очереди
    public void enqueue(int number, char letter) {
        Item newItem = new Item(number, letter);
        if (rear == null) {
            front = rear = newItem;
        } else {
            rear.next = newItem;
            rear = newItem;
        }
    }

    // Удаление элемента из начала очереди
    public Item dequeue() {
        if (front == null) {
            throw new RuntimeException("Очередь пуста");
        }
        Item temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        temp.next = null; // для очистки ссылки
        return temp;
    }

    // Поиск элемента по обоим полям
    public boolean contains(int number, char letter) {
        Item current = front;
        while (current != null) {
            if (current.d.number == number && current.d.letter == letter) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Печать очереди
    public void printQueue() {
        Item current = front;
        while (current != null) {
            System.out.print("(" + current.d.number + ", " + current.d.letter + ") ");
            current = current.next;
        }
        System.out.println();
    }
}

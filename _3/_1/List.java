package _3._1;

public class List {
    private ListElement head; // Указатель на первый элемент
    private ListElement tail; // Указатель на последний элемент


    float average() {
        if (head == null) {
            System.out.println("Список пустой");
            return 0f; // или можно выбросить исключение
        }
        int sum = 0;
        int count = 0;
        ListElement current = head;
        while (current != null) {
            sum += Integer.parseInt(current.data); // если data хранит числа как строки
            count++;
            current = current.next;
        }
        return (float) sum / count;
    }

    void insertTwoBeforeLast(ListElement E1, ListElement E2) {
        if (head == null) {
            System.out.println("Список пустой, вставка невозможна");
            return;
        }

        if (head == tail) {
            E1.next = E2;
            E2.next = head;
            head = E1;
            return;
        }

        ListElement current = head;
        while (current.next != tail) {
            current = current.next;
        }
        E1.next = E2;
        E2.next = tail;
        current.next = E1;
    }


    void add(ListElement newElement) {
        if (head == null) {
            head = newElement;
            tail = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;
        }
    }
    void printList() {
        if (head == null) {
            System.out.println("Список не имеет элементов");
        } else {
            ListElement currentElement = head;
            while (currentElement != null) {
                System.out.println(currentElement.data);
                currentElement = currentElement.next;
            }
        }
    }
}

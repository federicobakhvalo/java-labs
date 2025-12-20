package _3._4;

public class Stack {
    private Item top; // вершина стека

    // Добавление на вершину
    public void push(int number, char letter) {
        Item newItem = new Item(number, letter);
        newItem.next = top;
        top = newItem;
    }

    // Удаление с вершины
    public Item pop() {
        if (top == null) {
            throw new RuntimeException("Стек пуст");
        }
        Item temp = top;
        top = top.next;
        temp.next = null;
        return temp;
    }

    // Поиск элемента
    public boolean contains(int number, char letter) {
        Item current = top;
        while (current != null) {
            if (current.d.number == number && current.d.letter == letter) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Печать стека
    public void printStack() {
        Item current = top;
        while (current != null) {
            System.out.print("(" + current.d.number + ", " + current.d.letter + ") ");
            current = current.next;
        }
        System.out.println();
    }
}

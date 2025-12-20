package _3._3;

public class Item {
    public static class Data {
        public int number;
        public char letter;
    }

    Data d;
    Item next;

    public Item(int number, char letter) {
        this.d = new Data();
        this.d.number = number;
        this.d.letter = letter;
        this.next = null;
    }
}

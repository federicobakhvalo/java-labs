package _3._4;

import _3._3.Item.Data;

class Item {
    Data d;
    Item next;

    public Item(int number, char letter) {
        this.d = new Data();
        this.d.number = number;
        this.d.letter = letter;
        this.next = null;
    }
}



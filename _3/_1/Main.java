package _3._1;

public class Main {

    public static void main (String[] args){
        List myList = new List();
        myList.add(new ListElement("10"));
        myList.add(new ListElement("20"));
        myList.add(new ListElement("30"));
        myList.printList();
        float avg = myList.average();
        System.out.println("Среднее арифметическое: " + avg);
        myList.insertTwoBeforeLast(new ListElement("X"), new ListElement("Y"));
        System.out.println("\nПосле вставки:");
        myList.printList();
    }

}

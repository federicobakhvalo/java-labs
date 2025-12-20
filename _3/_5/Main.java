package _3._5;

public class Main {

    public static void main(String[] args) {
        int[] array = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        // 2. Создание дерева
        BinaryTree tree = new BinaryTree();

        // 3. Заполнение дерева из массива
        for (int value : array) {
            tree.insert(value);
        }

        // 4. Просмотр дерева сверху вниз (прямой обход)
        System.out.println("Обход дерева сверху вниз:");
        tree.printTree(tree.root);

        // 5. Поиск элемента
        int key = 7;
        System.out.println("\nПоиск элемента " + key + ": " + tree.search(key));

        int key2 = 5;
        System.out.println("Поиск элемента " + key2 + ": " + tree.search(key2));
    }
}


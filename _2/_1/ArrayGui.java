package _2._1;









import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArrayGui extends JFrame {

    private JTextArea taskText;
    private JTextField nField, kField;
    private JPanel sourcePanel, allowedPanel, resultPanel;
    private JTextField[] sourceFields, allowedFields;
    private JButton calculateButton;


    public ArrayGui() {
        setTitle("Задача с массивом");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        // Текст задачи
        taskText = new JTextArea("Введите элементы массива и разрешённые элементы.\n" +
                "Программа формирует новый массив с неразрешёнными элементами.");
        taskText.setLineWrap(true);
        taskText.setWrapStyleWord(true);
        taskText.setEditable(false);
        taskText.setFont(new Font("Arial", Font.PLAIN, 14));
        add(taskText, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        sourcePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        allowedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        resultPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Неразрешённые элементы"));

        inputPanel.add(createInputPanel("Введите длину массива n:", nField = new JTextField(5),
                sourcePanel, "Создать поля для массива", e -> createFields(sourcePanel, nField)));
        inputPanel.add(sourcePanel);
        inputPanel.add(createInputPanel("Введите длину массива разрешённых элементов k:", kField = new JTextField(5),
                allowedPanel, "Создать поля для разрешённых элементов", e -> createFields(allowedPanel, kField)));
        inputPanel.add(allowedPanel);

        calculateButton = new JButton("Выполнить алгоритм");
        calculateButton.addActionListener(e -> runAlgorithm());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        inputPanel.add(buttonPanel);

        add(inputPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(resultPanel);
        scrollPane.setPreferredSize(new Dimension(780, 80));
        add(scrollPane, BorderLayout.SOUTH);
    }

    // Создание панели с полем и кнопкой
    private JPanel createInputPanel(String labelText, JTextField field, JPanel targetPanel, String buttonText, java.awt.event.ActionListener action) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(labelText));
        panel.add(field);
        JButton button = new JButton(buttonText);
        button.addActionListener(action);
        panel.add(button);
        return panel;
    }


    private void createFields(JPanel panel, JTextField lengthField) {
        panel.removeAll();
        try {
            int n = Integer.parseInt(lengthField.getText());
            if (n < 0) throw new NumberFormatException();
            JTextField[] fields = new JTextField[n];
            for (int i = 0; i < n; i++) {
                fields[i] = new JTextField(5);
                fields[i].setHorizontalAlignment(JTextField.CENTER);
                panel.add(fields[i]);
            }
            if (panel == sourcePanel) sourceFields = fields;
            else allowedFields = fields;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введите корректное положительное число!");
        }
        panel.revalidate();
        panel.repaint();
    }

    private int[] getIntArrayFromFields(JTextField[] fields) throws NumberFormatException {
        int[] array = new int[fields.length];
        for (int i = 0; i < fields.length; i++) {
            array[i] = Integer.parseInt(fields[i].getText());
        }
        return array;
    }

    // Алгоритм вычисления массива с неразрешёнными элементами
    private void runAlgorithm() {
        if (sourceFields == null || allowedFields == null) {
            JOptionPane.showMessageDialog(this, "Сначала создайте поля для массивов!");
            return;
        }

        try {
            int[] source = getIntArrayFromFields(sourceFields);
            int[] allowed = getIntArrayFromFields(allowedFields);
            ArrayList<Integer> resultList = new ArrayList<>();
            for (int x : source) if (!isAllowedValue(x, allowed)) resultList.add(x);

            showResult(resultList);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Проверьте корректность введённых чисел!");
        }
    }

    // Проверка разрешённого значения
    private boolean isAllowedValue(int value, int[] allowed) {
        for (int a : allowed) if (value == a) return true;
        return false;
    }

    // Вывод результата в виде ячеек
    private void showResult(ArrayList<Integer> resultList) {
        resultPanel.removeAll();
        for (int val : resultList) {
            JTextField cell = new JTextField(String.valueOf(val), 5);
            cell.setHorizontalAlignment(JTextField.CENTER);
            cell.setEditable(false);
            resultPanel.add(cell);
        }
        resultPanel.revalidate();
        resultPanel.repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArrayGui().setVisible(true));
    }
}

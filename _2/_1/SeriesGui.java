package _2._1;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SeriesGui extends JFrame {

    private JTextField xStartField;
    private JTextField xEndField;
    private JTextField dxField;
    private JButton calcButton;
    private JTable table;
    private DefaultTableModel tableModel;

    private static final double EPS = 1e-5;

    public SeriesGui() {
        setTitle("Вычисление бесконечного ряда");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private void initUI() {
        // Панель ввода Xn, Xk, dX
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 3, 10, 5)); // 2 строки, 3 столбца, отступы 10/5


        inputPanel.add(new JLabel("Xn:", SwingConstants.CENTER));
        inputPanel.add(new JLabel("Xk:", SwingConstants.CENTER));
        inputPanel.add(new JLabel("dX:", SwingConstants.CENTER));
        xStartField = new JTextField("-1");
        xEndField = new JTextField("1");
        dxField = new JTextField("0.1");
        xStartField.setHorizontalAlignment(JTextField.CENTER);
        xEndField.setHorizontalAlignment(JTextField.CENTER);
        dxField.setHorizontalAlignment(JTextField.CENTER);

        inputPanel.add(xStartField);
        inputPanel.add(xEndField);
        inputPanel.add(dxField);


        // Кнопка расчета
        calcButton = new JButton("Расчет");
        calcButton.addActionListener(e -> calculateSeries());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calcButton);

        // Таблица
        tableModel = new DefaultTableModel(new String[]{"X", "Y"}, 0);
        table = new JTable(tableModel);
        // Компоновка
        setLayout(new BorderLayout(5, 5));
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    private double computeSumForX(double x) {
        double sum = 0.0;
        double term;
        int n = 1;

        do {
            term = ((2.0 * n + 1) / factorial(n)) * Math.pow(x, 2 * n);
            sum += term;
            n++;
        } while (Math.abs(term) > EPS && n < 20); // защита от бесконечного цикла

        return sum;
    }

    private void computeSeries(double Xn, double Xk, double dX) {
        tableModel.setRowCount(0); // очистка таблицы
        double x = Xn;

        while (x <= Xk) {
            double sum = computeSumForX(x);
            tableModel.addRow(new Object[]{
                    String.format("%.4f", x),
                    String.format("%.6f", sum)
            });
            x += dX;
        }
    }

    private void calculateSeries() {
        tableModel.setRowCount(0); // очистка таблицы

        double Xn, Xk, dX;
        try {
            Xn = Double.parseDouble(xStartField.getText());
            Xk = Double.parseDouble(xEndField.getText());
            dX = Double.parseDouble(dxField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Введите корректные числовые значения!",
                    "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dX <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Шаг dX должен быть положительным!",
                    "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Xn > Xk) {
            JOptionPane.showMessageDialog(this,
                    "Xn не может быть больше Xk!",
                    "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        computeSeries(Xn, Xk, dX);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SeriesGui().setVisible(true));
    }
}
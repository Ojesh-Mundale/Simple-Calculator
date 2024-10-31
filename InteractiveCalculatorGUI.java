import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteractiveCalculatorGUI {

    private static JTextField displayField;
    private static StringBuilder currentInput = new StringBuilder();
    private static double firstOperand = 0;
    private static String operator = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interactive Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Arial", Font.BOLD, 36));
        displayField.setPreferredSize(new Dimension(400, 50));
        frame.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                currentInput.append(command);
                displayField.setText(currentInput.toString());
            } else if (command.equals("C")) {
                currentInput.setLength(0);
                firstOperand = 0;
                operator = "";
                displayField.setText("");
            } else if (command.equals("=")) {
                if (!operator.isEmpty() && currentInput.length() > 0) {
                    double secondOperand = Double.parseDouble(currentInput.toString());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = firstOperand + secondOperand;
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            break;
                        case "/":
                            if (secondOperand != 0) {
                                result = firstOperand / secondOperand;
                            } else {
                                displayField.setText("Error: Division by zero");
                                return;
                            }
                            break;
                    }
                    displayField.setText(String.valueOf(result));
                    currentInput.setLength(0);
                    operator = "";
                }
            } else {
                if (currentInput.length() > 0) {
                    firstOperand = Double.parseDouble(currentInput.toString());
                    operator = command;
                    currentInput.setLength(0);
                }
            }
        }
    }
}

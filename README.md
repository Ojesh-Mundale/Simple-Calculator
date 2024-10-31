### Plan

1. **Title**: Add a title for the project.
2. **Description**: Provide a brief description of the project.
3. **Features**: List the features of the calculator.
4. **Requirements**: Specify the requirements to run the project.
5. **Usage**: Provide instructions on how to run the project.
6. **Code Explanation**: Explain the main components and functionality of the code.

### 

README.md



```markdown
# Interactive Calculator GUI

## Description

This project is a simple interactive calculator with a graphical user interface (GUI) built using Java Swing. The calculator allows users to perform basic arithmetic operations such as addition, subtraction, multiplication, and division by clicking on buttons.

## Features

- Addition, subtraction, multiplication, and division operations
- Clear button to reset the input
- Large display field for input and results
- Buttons for numbers (0-9) and operations (+, -, *, /)
- Error handling for division by zero

## Requirements

- Java Development Kit (JDK) 8 or higher

## Usage

1. Clone the repository or download the source code.
2. Compile the Java file:
   ```sh
   javac InteractiveCalculatorGUI.java
   ```
3. Run the compiled Java program:
   ```sh
   java InteractiveCalculatorGUI
   ```

## Code Explanation

### Imports

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
```

- `javax.swing.*`: Provides classes for creating the GUI components.
- `java.awt.*`: Provides classes for layout management.
- `java.awt.event.*`: Provides classes for handling events.

### Main Class

```java
public class InteractiveCalculatorGUI {
    private static JTextField displayField;
    private static StringBuilder currentInput = new StringBuilder();
    private static double firstOperand = 0;
    private static String operator = "";
```

- `InteractiveCalculatorGUI`: The main class of the program.
- `displayField`: A text field to display the input and result.
- `currentInput`: A `StringBuilder` to store the current input.
- `firstOperand`: A variable to store the first operand.
- `operator`: A variable to store the selected operator.

### Main Method

```java
public static void main(String[] args) {
    JFrame frame = new JFrame("Interactive Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 500);
    frame.setLayout(new BorderLayout());
```

- `JFrame`: The main window of the application.
- `setDefaultCloseOperation`: Specifies the operation when the window is closed.
- `setSize`: Sets the size of the window.
- `setLayout`: Sets the layout manager for the window.

### Display Field

```java

displayField = new JTextField();
displayField.setEditable(false);
displayField.setHorizontalAlignment(JTextField.RIGHT);
displayField.setFont(new Font("Arial", Font.BOLD, 36));
displayField.setPreferredSize(new Dimension(400, 50));
frame.add(displayField, BorderLayout.NORTH);

```

- `JTextField`: A text field to display the input and result.
- `setEditable(false)`: Makes the text field non-editable.
- `setHorizontalAlignment`: Aligns the text to the right.
- `setFont`: Sets the font of the text.
- `setPreferredSize`: Sets the preferred size of the text field.
- `add`: Adds the text field to the frame.

### Button Panel

```java
JPanel buttonPanel = new JPanel();
buttonPanel.setLayout(new GridLayout(4, 4));
```

- `JPanel`: A panel to hold the buttons.
- `setLayout`: Sets the layout manager for the panel.

### Buttons

```java
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
```

- `JButton`: Creates buttons for numbers and operations.
- `setFont`: Sets the font of the button text.
- `addActionListener`: Adds an action listener to handle button clicks.
- `add`: Adds the button to the panel.

### Adding Components to Frame

```java
frame.add(buttonPanel, BorderLayout.CENTER);
frame.setVisible(true);
```

- `add`: Adds the button panel to the frame.
- `setVisible(true)`: Makes the frame visible.

### ButtonClickListener Class

```java
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
```

- `ButtonClickListener`: Handles button click events.
- `actionPerformed`: Defines the actions to be performed when a button is clicked.
- `command`: The text of the clicked button.
- `currentInput.append(command)`: Appends the clicked number to the current input.
- `displayField.setText(currentInput.toString())`: Updates the display field with the current input.
- `command.equals("C")`: Clears the input and resets the calculator.
- `command.equals("=")`: Performs the selected operation and displays the result.
- `operator`: Stores the selected operator.
- `firstOperand`: Stores the first operand.
- `secondOperand`: Stores the second operand.
- `result`: Stores the result of the operation.
```

### Explanation

- **Title**: The title of the project.
- **Description**: A brief description of the project.
- **Features**: Lists the features of the calculator.
- **Requirements**: Specifies the requirements to run the project.
- **Usage**: Provides instructions on how to run the project.
- **Code Explanation**: Explains the main components and functionality of the code.

### Credits

Behold the greatest master of code....

AARIZ!!!!!!!!!!!
A graphical calculator application built using Java Swing and AWT. This simple calculator can perform basic operations: addition, subtraction, multiplication, and division.

Features

Graphical Interface: Built with Java Swing and AWT for an intuitive, user-friendly experience.
Basic Operations: Supports addition, subtraction, multiplication, and division.
Error Handling: Provides alerts for invalid inputs and division by zero.

Requirements
Java Development Kit (JDK) 8 or higher.

Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/simple-calculator-swing.git

Navigate to the project directory:

bash
Copy code
cd simple-calculator-swing

Compile the code:

bash
Copy code
javac CalculatorGUI.java

Run the application:

bash
Copy code
java CalculatorGUI


Usage
The calculator GUI will open, displaying buttons for digits, operations, and a result display area.
Click buttons to input numbers and operations.
Press = to display the result or C to clear the input.
Example UI
The UI consists of:

A text field displaying inputs and results.
Buttons for numbers (0-9), operations (+, -, *, /), and = for results.
Code Overview
CalculatorGUI.java: Main file containing:
The GUI setup with Swing components like JFrame, JButton, and JTextField.
Action listeners for handling button clicks and performing calculations.

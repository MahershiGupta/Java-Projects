import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// The Calculator class implements the ActionListener interface to handle button events.
public class Calculator implements ActionListener {
    JFrame frame; // Frame to hold all components.
    JTextField textfield; // Text field to display input and results.
    JButton[] numberButtons = new JButton[10]; // Array to hold number buttons (0-9).
    JButton[] functionButtons = new JButton[9]; // Array to hold function buttons (+, -, *, /, ., =, Del, Clr, (-)).
    JButton addButton, subButton, mulButton, divButton; // Function buttons for basic arithmetic operations.
    JButton decButton, equButton, delButton, clrButton, negButton; // Other function buttons (decimal, equals, delete,
                                                                   // clear, negate).
    JPanel panel; // Panel to organize buttons in a grid layout.

    Font myFont = new Font("Ink Free", Font.BOLD, 30); // Font for buttons and text field.

    double num1 = 0, num2 = 0, result = 0; // Variables to store numbers and result.
    char operator; // Variable to store the current operator.

    // Constructor to set up the calculator GUI.
    Calculator() {
        frame = new JFrame("Calculator"); // Create a new frame with the title "Calculator".
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation.
        frame.setSize(420, 550); // Set the size of the frame.
        frame.setLayout(null); // Use null layout for custom positioning of components.

        textfield = new JTextField(); // Create a text field for displaying input and results.
        textfield.setBounds(50, 25, 300, 50); // Set the position and size of the text field.
        textfield.setFont(myFont); // Set the font of the text field.
        textfield.setEditable(false); // Make the text field non-editable.

        // Initialize function buttons with their respective labels.
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        // Add function buttons to the array.
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Loop through the function buttons array and add action listeners to each
        // button.
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Loop through the number buttons array, create buttons, and add action
        // listeners.
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Set the position and size of the special function buttons.
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Create a panel to organize the number and operator buttons in a grid layout.
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add number and operator buttons to the panel in the desired order.
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame.
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true); // Make the frame visible.
    }

    // Main method to create an instance of the Calculator class.
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    // Action listener method to handle button click events.
    @Override
    public void actionPerformed(ActionEvent e) {
        // Loop through number buttons to append the clicked number to the text field.
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        // Append decimal point to the text field when the decimal button is clicked.
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        // Set the operator and store the first number when an operator button is
        // clicked.
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        // Perform the calculation when the equals button is clicked.
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result)); // Display the result.
            num1 = result; // Store the result as the first number for subsequent operations.
        }
        // Clear the text field when the clear button is clicked.
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        // Delete the last character in the text field when the delete button is
        // clicked.
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        // Negate the number in the text field when the negate button is clicked.
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
    }
}

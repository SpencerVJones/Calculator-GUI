import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JPanel screenPanel;
    JPanel rowOnePanel;
    JPanel rowTwoPanel;
    JPanel rowThreePanel;
    JPanel rowFourPanel;
    JPanel rowFivePanel;

    JTextField screen;

    JButton clearButton;
    JButton backButton;
    JButton decimalButton;

    JButton zeroButton;
    JButton oneButton;
    JButton twoButton;
    JButton threeButton;
    JButton fourButton;
    JButton fiveButton;
    JButton sixButton;
    JButton sevenButton;
    JButton eightButton;
    JButton nineButton;

    JButton divideButton;
    JButton mutiplyButton;
    JButton subtractButton;
    JButton addButton;
    JButton equalButton;

    JButton percentButton;
    JButton squareRootButton;

    double operand1 = 0;
    double operand2 = 0;
    String operator = "";


    Calculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(300, 400);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        // Instantiate Panels
        screenPanel = new JPanel();
        screenPanel.setPreferredSize(new Dimension(275, 100));

        rowOnePanel = new JPanel();
        rowOnePanel.setPreferredSize(new Dimension(275, 40));

        rowTwoPanel = new JPanel();
        rowTwoPanel.setPreferredSize(new Dimension(275, 40));

        rowThreePanel = new JPanel();
        rowThreePanel.setPreferredSize(new Dimension(275, 40));

        rowFourPanel = new JPanel();
        rowFourPanel.setPreferredSize(new Dimension(275, 40));

        rowFivePanel = new JPanel();
        rowFivePanel.setPreferredSize(new Dimension(275, 40));


        // Instantiate TextField
        screen = new JTextField();
        screen.setBackground(new Color(204, 229, 225));
        screen.setPreferredSize(new Dimension(275, 100));
        screen.setEditable(false);
        screen.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));


        // Instantiate Buttons
        // Panel 1 buttons
        clearButton = new JButton("C");
        clearButton.setPreferredSize(new Dimension(63, 35));
        clearButton.addActionListener(this);

        backButton = new JButton("<-");
        backButton.setPreferredSize(new Dimension(63, 35));
        backButton.addActionListener(this);

        percentButton = new JButton("%");
        percentButton.setPreferredSize(new Dimension(63, 35));
        percentButton.addActionListener(this);

        squareRootButton = new JButton("√");
        squareRootButton.setPreferredSize(new Dimension(63, 35));
        squareRootButton.addActionListener(this);


        // Panel 2 buttons
        oneButton = new JButton("1");
        oneButton.setPreferredSize(new Dimension(63, 35));
        oneButton.addActionListener(this);

        twoButton = new JButton("2");
        twoButton.setPreferredSize(new Dimension(63, 35));
        twoButton.addActionListener(this);

        threeButton = new JButton("3");
        threeButton.setPreferredSize(new Dimension(63, 35));
        threeButton.addActionListener(this);

        addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(63, 35));
        addButton.addActionListener(this);


        // Panel 3 buttons
        fourButton = new JButton("4");
        fourButton.setPreferredSize(new Dimension(63, 35));
        fourButton.addActionListener(this);

        fiveButton = new JButton("5");
        fiveButton.setPreferredSize(new Dimension(63, 35));
        fiveButton.addActionListener(this);

        sixButton = new JButton("6");
        sixButton.setPreferredSize(new Dimension(63, 35));
        sixButton.addActionListener(this);

        subtractButton = new JButton("-");
        subtractButton.setPreferredSize(new Dimension(63, 35));
        subtractButton.addActionListener(this);


        // Panel 4 buttons
        sevenButton = new JButton("7");
        sevenButton.setPreferredSize(new Dimension(63, 35));
        sevenButton.addActionListener(this);

        eightButton = new JButton("8");
        eightButton.setPreferredSize(new Dimension(63, 35));
        eightButton.addActionListener(this);

        nineButton = new JButton("9");
        nineButton.setPreferredSize(new Dimension(63, 35));
        nineButton.addActionListener(this);

        mutiplyButton = new JButton("x");
        mutiplyButton.setPreferredSize(new Dimension(63, 35));
        mutiplyButton.addActionListener(this);


        // Panel 5 buttons
        zeroButton = new JButton("0");
        zeroButton.setPreferredSize(new Dimension(63, 35));
        zeroButton.addActionListener(this);

        decimalButton = new JButton(".");
        decimalButton.setPreferredSize(new Dimension(63, 35));
        decimalButton.addActionListener(this);

        equalButton = new JButton("=");
        equalButton.setPreferredSize(new Dimension(63, 35));
        equalButton.addActionListener(this);

        divideButton = new JButton("/");
        divideButton.setPreferredSize(new Dimension(63, 35));
        divideButton.addActionListener(this);


        // Add to panels
        screenPanel.add(screen);

        rowOnePanel.add(clearButton);
        rowOnePanel.add(backButton);
        rowOnePanel.add(percentButton);
        rowOnePanel.add(squareRootButton);

        rowTwoPanel.add(oneButton);
        rowTwoPanel.add(twoButton);
        rowTwoPanel.add(threeButton);
        rowTwoPanel.add(addButton);

        rowThreePanel.add(fourButton);
        rowThreePanel.add(fiveButton);
        rowThreePanel.add(sixButton);
        rowThreePanel.add(subtractButton);

        rowFourPanel.add(sevenButton);
        rowFourPanel.add(eightButton);
        rowFourPanel.add(nineButton);
        rowFourPanel.add(mutiplyButton);

        rowFivePanel.add(zeroButton);
        rowFivePanel.add(decimalButton);
        rowFivePanel.add(equalButton);
        rowFivePanel.add(divideButton);

        // Add to frame
        this.add(screenPanel);
        this.add(rowOnePanel);
        this.add(rowTwoPanel);
        this.add(rowThreePanel);
        this.add(rowFourPanel);
        this.add(rowFivePanel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) throws NumberFormatException {

        if (e.getSource() == clearButton) {
            screen.setText("");
            operand1 = operand2 = 0;
            operator = "";
        }


        if (e.getSource() == backButton) {
            String currentText = screen.getText();
            if (currentText.length() > 0) {
                screen.setText(currentText.substring(0, currentText.length() - 1));
            }
        }


        if (e.getSource() == decimalButton) {
            screen.setText(screen.getText() + ".");
        }


        if (e.getSource() == zeroButton) {
            screen.setText(screen.getText() + "0");
        }


        if (e.getSource() == oneButton) {
            screen.setText(screen.getText() + "1");
        }


        if (e.getSource() == twoButton) {
            screen.setText(screen.getText() + "2");
        }


        if (e.getSource() == threeButton) {
            screen.setText(screen.getText() + "3");
        }


        if (e.getSource() == fourButton) {
            screen.setText(screen.getText() + "4");
        }


        if (e.getSource() == fiveButton) {
            screen.setText(screen.getText() + "5");
        }


        if (e.getSource() == sixButton) {
            screen.setText(screen.getText() + "6");
        }


        if (e.getSource() == sevenButton) {
            screen.setText(screen.getText() + "7");
        }


        if (e.getSource() == eightButton) {
            screen.setText(screen.getText() + "8");
        }


        if (e.getSource() == nineButton) {
            screen.setText(screen.getText() + "9");
        }


        if (e.getSource() == divideButton) {
            screen.setText(screen.getText() + "/");
        }


        if (e.getSource() == mutiplyButton) {
            screen.setText(screen.getText() + "*");
        }


        if (e.getSource() == subtractButton) {
            screen.setText(screen.getText() + "-");
        }


        if (e.getSource() == addButton) {
            screen.setText(screen.getText() + "+");
        }


        if (e.getSource() == equalButton) {

            String expression = screen.getText();

            try {
                // Use a regular expression to split the expression into operands and operator
                String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");

                if (tokens.length != 3) {
                    // Invalid expression format
                    throw new IllegalArgumentException();
                }

                double num1 = Double.parseDouble(tokens[0].trim());
                double num2 = Double.parseDouble(tokens[2].trim());
                String op = tokens[1].trim();

                double result = 0;

                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            screen.setText("Error");
                            return;
                        }
                        break;
                    default:
                        screen.setText("Error");
                        return;
                }

                // Display the result on the screen
                screen.setText(Double.toString(result));

                // Reset operands and operator
                operand1 = operand2 = 0;
                operator = "";
            } catch (IllegalArgumentException ex) {
                // Handle parsing or invalid expression format exception
                screen.setText("Error");
            }
        }


        if (e.getSource() == percentButton) {
            try {
                double currentValue = Double.parseDouble(screen.getText()) / 100.0;
                screen.setText(Double.toString(currentValue));
            } catch (NumberFormatException ex) {
                screen.setText("Error");
            }
        }


        if (e.getSource() == squareRootButton) {
            try {
                double currentValue = Math.sqrt(Double.parseDouble(screen.getText()));
                screen.setText(Double.toString(currentValue));
            } catch (NumberFormatException ex) {
                screen.setText("Error");
            }
        }
    }
}
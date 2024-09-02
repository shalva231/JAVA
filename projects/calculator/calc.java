package projects.calculator;

import java.awt.*;
import java.awt.event.*;

// extending frame class to our class calc   
public class calc extends Frame implements ActionListener {

    TextField display; // text field to display the result
    String num1, num2, operator; // variables to hold numbers and operations

    // constructor
    calc() {
        num1 = num2 = operator = ""; // initialize variables

        // create a text field
        display = new TextField();

        display.setBounds(10, 35, 240, 60);
        display.setFont(new Font("Arial", Font.BOLD, 45));
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        add(display);

        setResizable(false);

        // creating buttons
        Button clear = new Button("C");
        Button del = new Button("<=");
        Button perc = new Button("%");
        Button div = new Button("/");

        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button mult = new Button("X");

        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button sub = new Button("-");

        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button plus = new Button("+");

        Button zero = new Button("0");
        Button dot = new Button(".");
        Button equal = new Button("=");

        // setting button positions on screen
        clear.setBounds(10, 90, 60, 60);
        del.setBounds(70, 90, 60, 60);
        perc.setBounds(130, 90, 60, 60);
        div.setBounds(190, 90, 60, 60);

        seven.setBounds(10, 150, 60, 60);
        eight.setBounds(70, 150, 60, 60);
        nine.setBounds(130, 150, 60, 60);
        mult.setBounds(190, 150, 60, 60);

        four.setBounds(10, 210, 60, 60);
        five.setBounds(70, 210, 60, 60);
        six.setBounds(130, 210, 60, 60);
        sub.setBounds(190, 210, 60, 60);

        one.setBounds(10, 270, 60, 60);
        two.setBounds(70, 270, 60, 60);
        three.setBounds(130, 270, 60, 60);
        plus.setBounds(190, 270, 60, 60);

        zero.setBounds(10, 330, 120, 60);
        dot.setBounds(130, 330, 60, 60);
        equal.setBounds(190, 330, 60, 60);

        // set button colors and fonts
        setButtonStyle(clear, Color.BLACK, new Color(184, 115, 51));
        setButtonStyle(del, Color.BLACK, new Color(184, 115, 51));
        setButtonStyle(perc, Color.BLACK, new Color(184, 115, 51));
        setButtonStyle(div, Color.BLACK, new Color(184, 115, 51));

        setButtonStyle(seven, Color.BLACK, Color.WHITE);
        setButtonStyle(eight, Color.BLACK, Color.WHITE);
        setButtonStyle(nine, Color.BLACK, Color.WHITE);
        setButtonStyle(mult, Color.BLACK, new Color(184, 115, 51));

        setButtonStyle(four, Color.BLACK, Color.WHITE);
        setButtonStyle(five, Color.BLACK, Color.WHITE);
        setButtonStyle(six, Color.BLACK, Color.WHITE);
        setButtonStyle(sub, Color.BLACK, new Color(184, 115, 51));

        setButtonStyle(one, Color.BLACK, Color.WHITE);
        setButtonStyle(two, Color.BLACK, Color.WHITE);
        setButtonStyle(three, Color.BLACK, Color.WHITE);
        setButtonStyle(plus, Color.BLACK, new Color(184, 115, 51));

        setButtonStyle(zero, Color.BLACK, Color.WHITE);
        setButtonStyle(dot, Color.BLACK, Color.WHITE);
        equal.setBackground(new Color(184, 115, 51));
        equal.setForeground(Color.WHITE);
        equal.setFont(new Font("Arial", Font.BOLD, 20));

        // add action listeners to the buttons
        clear.addActionListener(this);
        del.addActionListener(this);
        perc.addActionListener(this);
        div.addActionListener(this);
        mult.addActionListener(this);
        sub.addActionListener(this);
        plus.addActionListener(this);
        equal.addActionListener(this);
        dot.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);

        // add the buttons into the frame
        add(clear);
        add(del);
        add(perc);
        add(div);
        add(one);
        add(two);
        add(three);
        add(mult);
        add(four);
        add(five);
        add(six);
        add(sub);
        add(seven);
        add(eight);
        add(nine);
        add(plus);
        add(zero);
        add(dot);
        add(equal);

        // frame settings
        setSize(260, 400);
        setTitle("Calculator");
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
    }

    private void setButtonStyle(Button button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, 20));
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // recives the lable of the button press

        // digit and decimal points
        if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
            if (!operator.isEmpty()) {
                num2 += command;
            } else {
                num1 += command;
            }
            display.setText(num1 + operator + num2);
        } else if (command.equals("C")) {
            // clear everything
            num1 = num2 = operator = "";
            display.setText("");

        } else if (command.equals("<=")) {
            // delete last character
            if (!num2.isEmpty()) {
                num2 = num2.substring(0, num2.length() - 1);
            } else if (!operator.isEmpty()) {
                operator = "";
            } else if (!num1.isEmpty()) {
                num1 = num1.substring(0, num1.length() - 1);
            }
            display.setText(num1 + operator + num2);
        } else if (command.equals("=")) {
            // perform calculation
            double result;
            switch (operator) {
                case "+":
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    break;
                case "-":
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    break;
                case "X":
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    break;
                case "/":
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    break;
                case "%":
                    result = Double.parseDouble(num1) % Double.parseDouble(num2);
                    break;
                default:
                    return;
            }
            display.setText("" + result);
            num1 = Double.toString(result);
            operator = num2 = "";
        } else {
            // Handle operator
            if (num1.isEmpty()) {
                return; // ignore if no number is entered yet
            }
            if (!operator.isEmpty()) {
                return; // ignore if operator is already chosen
            }
            operator = command;
            display.setText(num1 + operator);
        }
    }

    public static void main(String[] args) {
        new calc();
    }
}

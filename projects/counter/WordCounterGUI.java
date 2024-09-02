package projects.counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI {

    public static void main(String[] args) {
        // create a JFrame to hold the GUI components
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // create a JTextArea for inputting the text
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 50, 700, 400);
        frame.add(scrollPane);

        // create a JButton to trigger the word count
        JButton countButton = new JButton("Count the Words");
        countButton.setBounds(325, 460, 150, 50);  
        countButton.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(countButton);

        // create a JLabel to display the result
        JLabel resultLabel = new JLabel("Word Count: ");
        resultLabel.setBounds(325, 520, 300, 40);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(resultLabel);

        // create an instance of the counter class
        counter wordCounter = new counter();

        // add an ActionListener to the button
        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = wordCounter.countWords(text);

                // Timer to update the word count gradually
                Timer timer = new Timer(10, new ActionListener() {
                    private int currentCount = 0;
                    public void actionPerformed(ActionEvent e) {
                        if (currentCount < wordCount) {
                            currentCount++;
                            resultLabel.setText("Word Count: " + currentCount);
                        } else {
                            ((Timer) e.getSource()).stop();
                        }
                    }
                });

                timer.start();
            }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

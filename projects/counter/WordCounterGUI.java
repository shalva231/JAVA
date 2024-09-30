package projects.counter;

//  java -cp bin projects.counter.WordCounterGUI


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Word Counter");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 50, 700, 400);
        frame.add(scrollPane);

        JButton countButton = new JButton("Count the Words");
        countButton.setBounds(325, 460, 150, 50);  
        countButton.setFont(new Font("Arial", Font.PLAIN, 20));
        frame.add(countButton);

        JLabel resultLabel = new JLabel("Word Count: ");
        resultLabel.setBounds(325, 520, 300, 40);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(resultLabel);

        counter wordCounter = new counter();

        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = wordCounter.countWords(text);

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

package projects.TextBasedGame;

//  java -cp bin projects.TextBasedGame.TextBasedGame


import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class TextBasedGame {
    public static void main(String[] args) {
        // create the frame
        JFrame frame = new JFrame();
        frame.setSize(1200, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE, 3);

        // ==================================================
        // textarea for displaying text
        // ==================================================
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);   
        textArea.setForeground(Color.WHITE);    
        textArea.setBorder(whiteBorder);
 

        JScrollPane scrollPane = new JScrollPane(textArea);
        int frameWidth = 1200;
        int frameHeight = 1000;
        int textAreaWidth = frameWidth - 100;
        int textAreaHeight = 400;
        int xPosition = (frameWidth - textAreaWidth) / 2;

        scrollPane.setBounds(xPosition, 20, textAreaWidth, textAreaHeight);
        frame.add(scrollPane);
        // ==================================================
        // end of textarea

        // ==================================================




        
        // ==================================================
        // create the navigation 
        // ==================================================
        JPanel navigation = new JPanel();
        navigation.setBounds(50, 400+25, 1100, 40);
        navigation.setBackground(Color.BLACK);   
        navigation.setForeground(Color.WHITE);    
        navigation.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));


        JButton inventory = new JButton("inventory ⫺");
        JButton BTM = new JButton("Back To Main 🏠");
        JButton map = new JButton("map 🏞");
        JButton shop = new JButton("shop 🛒");
        JButton inst = new JButton("INSTRUCTIONS ❓");


        // Style the buttons
        inventory.setFont(new Font("plain", Font.PLAIN, 16));
        BTM.setFont(new Font("plain", Font.PLAIN, 16));
        map.setFont(new Font("plain", Font.PLAIN, 16));
        shop.setFont(new Font("plain", Font.PLAIN, 16));
        inst.setFont(new Font("plain", Font.PLAIN, 16));

        inventory.setBackground(Color.BLACK);
        BTM.setBackground(Color.BLACK);
        map.setBackground(Color.BLACK);
        shop.setBackground(Color.BLACK);
        inst.setBackground(Color.BLACK);


        inventory.setForeground(Color.WHITE);
        BTM.setForeground(Color.WHITE);
        map.setForeground(Color.WHITE);    
        shop.setForeground(Color.WHITE);
        inst.setForeground(Color.WHITE);

        //add action listeners to the buttons
        inventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("You open your inventory.\n");
            }
        });

        BTM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("You go back to the main menu.\n");
            }
        });


        map.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("You open the map.\n");
            }
        });



        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("You open the shop.\n");
            }
        });
        inst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(" here are some Instructions:\n" +
                        "This is a text-based adventure game.\n");
            }
        });


        // Add buttons to the navigation
        navigation.add(BTM);
        navigation.add(inventory);
        navigation.add(map);
        navigation.add(shop);
        navigation.add(inst);

        frame.add(navigation);
    // ==================================================
    // end of navigation
    // ==================================================


    // ==================================================
    // JPanels
    // ==================================================
    //---------------------------------------------------
    // main (choices)

    JPanel main = new JPanel(new GridLayout(4,2,10,10));

    main.setBounds(50, 475, 1100, 460);
    main.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    main.setBackground(Color.black);
    main.setForeground(Color.white);

    JButton choice1 = new JButton("");
    JButton choice2 = new JButton("");
    JButton choice3 = new JButton("");
    JButton choice4 = new JButton("");
    JButton choice5 = new JButton("");
    JButton choice6 = new JButton("");
    JButton choice7 = new JButton("");
    JButton choice8 = new JButton("");


    choice1.setFont(new Font("italic", Font.ITALIC, 16));
    choice2.setFont(new Font("italic", Font.ITALIC, 16));
    choice3.setFont(new Font("italic", Font.ITALIC, 16));
    choice4.setFont(new Font("italic", Font.ITALIC, 16));
    choice5.setFont(new Font("italic", Font.ITALIC, 16));
    choice6.setFont(new Font("italic", Font.ITALIC, 16));
    choice7.setFont(new Font("italic", Font.ITALIC, 16));
    choice8.setFont(new Font("italic", Font.ITALIC, 16));



    choice1.setBackground(Color.BLACK);
    choice1.setForeground(Color.white);

    choice2.setBackground(Color.BLACK);
    choice2.setForeground(Color.white);

    choice3.setBackground(Color.BLACK);
    choice3.setForeground(Color.white);

    choice4.setBackground(Color.BLACK);
    choice4.setForeground(Color.white);

    choice5.setBackground(Color.BLACK);
    choice5.setForeground(Color.white);

    choice6.setBackground(Color.BLACK);
    choice6.setForeground(Color.white);

    choice7.setBackground(Color.BLACK);
    choice7.setForeground(Color.white);

    choice8.setBackground(Color.BLACK);
    choice8.setForeground(Color.white);



    choice1.setText("choice 1");
    choice2.setText("choice 2");
    choice3.setText("choice 3");
    choice4.setText("choice 4");
    choice5.setText("choice 5");
    choice6.setText("choice 6");
    choice7.setText("choice 7");
    choice8.setText("choice 8");





    main.add(choice1);
    main.add(choice2);
    main.add(choice3);
    main.add(choice4);
    main.add(choice5);
    main.add(choice6);
    main.add(choice7);
    main.add(choice8);


    // add the first panel to the frame
    frame.add(main);




        frame.setVisible(true);
    }


}


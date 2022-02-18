import java.awt.event.*;
        import java.io.InputStream;
        import java.util.Scanner;
        import javax.swing.*;
        import java.awt.FlowLayout;

public class LuckyTicket {
    public static void main(String[] args) {
        JPanel windowContent = new JPanel();
        JLabel label1 = new JLabel("Introduce your ticket number");
        JTextField field1 = new JTextField(10);
        JButton go = new JButton ("search");
        JTextArea result = new JTextArea();

        windowContent.add(label1);
        windowContent.add(field1);
        windowContent.add(go);
        windowContent.add(result);
        JFrame frame = new JFrame("my first UI");
        frame.setContentPane(windowContent);
        frame.setSize(500,150);
        frame.setVisible(true);


        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = field1.getText();

                int ticket = Integer.parseInt(x);
                //declaration of variables for the lucky ticket and counting how many tickets you should buy
                int countLT = 0;
                int luckyTicket = 0;
                //checking if introduced data is a number between 1-999999
                if (ticket >= 1 & ticket <= 999999) {
                    //searching next lucky ticket
                    while (ticket <= 999999) {
                        int n1 = ticket / 100000 % 10;
                        int n2 = ticket / 10000 % 10;
                        int n3 = ticket / 1000 % 10;
                        int n4 = ticket / 100 % 10;
                        int n5 = ticket / 10 % 10;
                        int n6 = ticket % 10;

                        if (n1 + n2 + n3 != n4 + n5 + n6) {
                            countLT++;
                            ticket++;
                        } else
                            break;

                        luckyTicket = ticket;
                    }
                    if (luckyTicket == 0)
                        //printing out the result
                        // System.out.println("Your ticket is lucky! Congratulations!");
                        result.setText("Your ticket is lucky! Congratulations!");
                    else result.setText("Lucky ticket:"  + luckyTicket + " will be after " + countLT + " tickets");
                    //System.out.println("Lucky ticket: " + luckyTicket + " will be after " + countLT + " tickets");
                    //printing the eror message in case you introdused invalid ticket number
                } else result.setText("Ticketnumber must be from 1 to 999999! \nRestart the program and try again ");
                //System.out.println("Ticketnumber must be from 1 to 999999! Restart the program and try again ");

            }
        });
    }

}
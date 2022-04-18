/**
 * PopUp class whenever an error or
 * message that needs to be displayed
 * to the account is needed.
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUp {
    public PopUp(String display){ //constructor which takes the string that needs to be displayed to the account
        JFrame f = new JFrame();
        JButton button = new JButton("OK");
        button.setBounds(80, 50, 30, 15);
        JLabel label = new JLabel(display);
        label.setBounds(15, 30, 350, 15);
        f.add(button);
        f.add(label);
        f.setSize(350,100);
        f.setLayout(null);  
        f.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() { //when the button is pressed
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f.dispose(); //disposes of the frame
            }
        });
    }
}
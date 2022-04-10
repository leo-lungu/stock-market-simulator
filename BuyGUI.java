import javax.swing.*;

public class BuyGUI {


    public static void buyWindow() {
        JFrame f = new JFrame("TradeIT | Buy Stocks");


 
        // create a label to display text
        JLabel l = new JLabel("new text ");
 
        // create a panel
        JPanel p = new JPanel();
 
        // add label to panel
        p.add(l);
 
        // add panel to frame
        f.add(p);

        JButton exit = new JButton("Exit");
        exit.setBounds(300, 300, 100, 20);
        f.add(exit);
        exit.addActionListener(e -> {
            f.dispose();
        });
        f.setSize(400,500);
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible 
    }
}

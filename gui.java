import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {
    public gui() {
        JFrame f = new JFrame("TradeIT");
        JPanel p1 = null;
        p1 = tabBuy(p1);
        JPanel p2 = null;
        p2 = tabSell(p2);
        JPanel p3 = null;
        p3 = tabPortfolio(p3);
        JTabbedPane tp=new JTabbedPane();
        tp.add("Buy", p1);
        tp.setBounds(50,50,400,400);
        tp.add("Sell",p2);
        tp.add("Portfolio",p3);
        f.add(tp);  
        f.setSize(500,520);
        f.setLayout(null);  
        f.setVisible(true);
    }

    public static JPanel tabBuy(JPanel p1) {
        JButton buy = new JButton("Buy");
        p1=new JPanel();
        String country[]={"AAPL","NVDA","GOOG"};
        JComboBox cb=new JComboBox(country);
        cb.setBounds(50, 50,90,20);
        JTextField tf1 = new JTextField();
        tf1.setBounds(70,70,150,20);
        p1.add(cb);
        p1.add(tf1);
        p1.add(buy);
        p1.add(buy);
        buy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Bought: "
                        + cb.getItemAt(cb.getSelectedIndex());
                System.out.println(data);
            }
        });
        return p1;
    }

    public static JPanel tabSell(JPanel p2) {
        JButton buy = new JButton("Sell");
        p2=new JPanel();
        String country[]={"AAPL","NVDA","GOOG"};
        JComboBox cb=new JComboBox(country);
        cb.setBounds(50, 50,90,20);
        p2.add(cb);
        p2.add(buy);
        buy.setBounds(130, 100, 100, 40);
        return p2;
    }

    public static JPanel tabPortfolio(JPanel p3) {
        JButton buy = new JButton("Portfolio");
        p3=new JPanel();
        p3.add(buy);
        buy.setBounds(130, 100, 100, 40);
        return p3;
    }
}

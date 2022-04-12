import javax.swing.*;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends Trade{
    public gui(User user) {
        Market m = new Market();
        System.out.println("test");
        JFrame f = new JFrame("TradeIT");
        System.out.println("test2");

        JButton button = new JButton("Click to Close!");

        double price0 =m.getCurrentPrice(0);
        String s0 = Double.toString(price0);
        System.out.println(m.getCurrentPrice(0));
        JLabel labelCurrentPrice0 = new JLabel(s0);
        labelCurrentPrice0.setBounds(350,550, 100,30);

        double price1 =m.getCurrentPrice(1);
        String s1 = Double.toString(price1);
        System.out.println(m.getCurrentPrice(1));
        JLabel labelCurrentPrice1 = new JLabel(s1);
        labelCurrentPrice1.setBounds(450,550, 100,30);

        double price2 =m.getCurrentPrice(2);
        String s2 = Double.toString(price2);
        System.out.println(m.getCurrentPrice(2));
        JLabel labelCurrentPrice2 = new JLabel(s2);
        labelCurrentPrice2.setBounds(550,550, 100,30);

        button.setLayout(null);
        button.setBounds(505, 50, 50, 50);
        button.addActionListener(e -> {
            f.dispose();
            m.marketOnFalse();
        });
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double price0 =m.getCurrentPrice(0);
                String s0 = Double.toString(price0);
                labelCurrentPrice0.setText(s0);
                double price1 =m.getCurrentPrice(1);
                String s1 = Double.toString(price1);
                labelCurrentPrice1.setText(s1);
                double price2 =m.getCurrentPrice(2);
                String s2 = Double.toString(price2);
                labelCurrentPrice2.setText(s2);
            }
        };

        JPanel p1 = null;
        p1 = tabBuy(p1, user, m);
        p1.setLayout(new GridLayout(3, 1));
        JPanel p2 = null;
        p2 = tabSell(p2, user);
        p2.setLayout(new GridLayout(3, 1));
        JPanel p3 = null;
        p3 = tabPortfolio(p3, user, m);
        p3.setLayout(new GridLayout(3, 1));
        JPanel p4 = null;
        p4 = tabDeposit(p4, user);
        p4.setLayout(new GridLayout(4, 0));
        JTabbedPane tp=new JTabbedPane();
        tp.add("Buy", p1);
        tp.add("Sell", p2);
        tp.add("Portfolio", p3);
        tp.add("Deposit", p4);
        tp.setBounds(50,50,400,400);
        f.add(labelCurrentPrice0);
        f.add(labelCurrentPrice1);
        f.add(labelCurrentPrice2);
        f.add(tp);  
        f.add(button);
        f.setSize(700,720);
        f.setLayout(null);  
        f.setVisible(true);
        Timer timer = new Timer(9999, taskPerformer);
        timer.start();
    }
    

    public static JPanel tabBuy(JPanel p1, User user, Market m) {
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
                String data = "Bought: " + cb.getItemAt(cb.getSelectedIndex());
                System.out.println(data);
                String stock = (String) cb.getItemAt(cb.getSelectedIndex());
                int amount = Integer. parseInt(tf1.getText());
                buyStock(stock, amount, user, m);
            }
        });
        return p1;
    }

    public static JPanel tabSell(JPanel p2, User user) {
        JButton sell = new JButton("Sell");
        p2=new JPanel();
        String country[]={"AAPL","NVDA","GOOG"};
        JComboBox cb=new JComboBox(country);
        cb.setBounds(50, 50,90,20);
        JTextField tf1 = new JTextField();
        p2.add(cb);
        p2.add(tf1, BorderLayout.SOUTH);
        p2.add(sell);
        
        sell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Sold: " + cb.getItemAt(cb.getSelectedIndex());
                System.out.println(data);
                String stock = (String) cb.getItemAt(cb.getSelectedIndex());
                int amount = Integer.parseInt(tf1.getText());
                sellStock(stock, amount, user);
            }
        });
        return p2;
    }

    public static JPanel tabPortfolio(JPanel p3, User user, Market m) {
        p3 = new JPanel();
        double price0 = m.getCurrentPrice(0);
        String s0 = Double.toString(price0);
        System.out.println(m.getCurrentPrice(0));
        JLabel labelCurrentPrice0 = new JLabel("Current price of AAPL: " + s0);
        JLabel labelStock0 = new JLabel("Number of AAPL Stocks: " + user.getAccount().getStockHeld("AAPL"));

        double price1 = m.getCurrentPrice(1);
        String s1 = Double.toString(price1);
        System.out.println(m.getCurrentPrice(1));
        JLabel labelCurrentPrice1 = new JLabel("Current price of NVDA: " + s1);
        JLabel labelStock1 = new JLabel("Number of NVDA Stocks: " + user.getAccount().getStockHeld("NVDA"));

        double price2 =m.getCurrentPrice(2);
        String s2 = Double.toString(price2);
        System.out.println(m.getCurrentPrice(2));
        JLabel labelCurrentPrice2 = new JLabel("Current price of AMZN: " + s2);
        JLabel labelStock2 = new JLabel("Number of AMZN Stocks: " + user.getAccount().getStockHeld("AMZN"));

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double price0 =m.getCurrentPrice(0);
                String s0 = Double.toString(price0);
                labelCurrentPrice0.setText("Current price of AAPL: " + s0);
                labelStock0.setText("Number of AAPL Stocks: " + user.getAccount().getStockHeld("AAPL"));
                double price1 =m.getCurrentPrice(1);
                String s1 = Double.toString(price1);
                labelCurrentPrice1.setText("Current price of NVDA: " + s1);
                labelStock0.setText("Number of NVDA Stocks: " + user.getAccount().getStockHeld("NVDA"));
                double price2 =m.getCurrentPrice(2);
                String s2 = Double.toString(price2);
                labelCurrentPrice2.setText("Current price of AMZN: " + s2);
                labelStock0.setText("Number of AMZN Stocks: " + user.getAccount().getStockHeld("AMZN"));
            }
        };
        p3.add(labelCurrentPrice0);
        p3.add(labelStock0);
        p3.add(labelCurrentPrice1);
        p3.add(labelStock1);
        p3.add(labelCurrentPrice2);
        p3.add(labelStock2);
        Timer timer = new Timer(9999, taskPerformer);
        timer.start();
        System.out.println("test");
        return p3;
    }

    public static JPanel tabDeposit(JPanel p4, User user) {
        JButton deposit = new JButton("Deposit");
        p4=new JPanel();
        JTextField tf1 = new JTextField();
        p4.add(tf1);
        p4.add(deposit);
        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(tf1.getText());
                user.getAccount().deposit(amount);
            }
        });
        return p4;
    }
}

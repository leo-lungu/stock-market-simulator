/**
 * The GUI class creates the GUI
 * which has different panels
 * and calls other classes
 * and methods in order to do the
 * back-end work.
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GUI {
    public GUI(Account account) { //constructor
        
        //initialises the different construcotrs
        Market m = new Market(); 
        Market mc = new MarketCrypto(account);
        Trade sell = new Sell();
        Trade buy = new Buy();
        
        //creates the frame and the different buttons and labels
        JFrame f = new JFrame("Trade Stocks and Cryptocurrencies");
        JButton buttonExit = new JButton("Exit");
        JButton buttonReset = new JButton("Reset");

        JLabel labelCurrentPrice0 = new JLabel();
        labelCurrentPrice0.setBounds(61, 465, 100, 30);

        JLabel labelCurrentPrice1 = new JLabel();
        labelCurrentPrice1.setBounds(61, 505, 100, 30);

        JLabel labelCurrentPrice2 = new JLabel(); 
        labelCurrentPrice2.setBounds(267, 465, 100, 30);
              
        JLabel labelCurrentPrice3 = new JLabel();
        labelCurrentPrice3.setBounds(267, 505, 100, 30);
        
        JLabel labelBalance = new JLabel();
        labelBalance.setBounds(210, 20, 200, 30);

        buttonExit.setLayout(null);
        buttonExit.setBounds(160, 550, 80, 40);

        buttonReset.setLayout(null);
        buttonReset.setBounds(260, 550, 80, 40);
        
        //updates the different prices
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double price0 = round(m.getCurrentPrice(0)); //uses the Market class to get the price
                String s0 = "AAPL: $" + (price0);
                labelCurrentPrice0.setText(s0);
                double price1 = round(m.getCurrentPrice(1));
                String s1 = "NVDA: $" + (price1);
                labelCurrentPrice1.setText(s1);
                double price2 = round(mc.getCurrentPrice(0));
                String s2 = "BTC: $" + (price2);
                labelCurrentPrice2.setText(s2);
                double price3 = round(mc.getCurrentPrice(1)); //uses the MarketCrypto class to get the price
                String s3 = "ETH: $" + (price3);
                double balance = round(account.getBalance());
                labelCurrentPrice3.setText(s3);
                String sb = "Balance: $" + (balance);
                labelBalance.setText(sb);
            }
        };
        //creates the different panels and calls each respective method
        JPanel p1 = null;
        p1 = tabTrade(p1, account, m, mc, buy, sell);
        p1.setLayout(null);
        JPanel p2 = null;
        p2 = tabPortfolio(p2, account, m, mc, buy);
        p2.setLayout(new GridLayout(4, 1));
        JPanel p3 = null;
        p3 = tabBalance(p3, account);
        p3.setLayout(null);
        JTabbedPane tp=new JTabbedPane();

        //adds the panels to the frame
        tp.add("Trade", p1);
        tp.add("Portfolio", p2);
        tp.add("Balance", p3);
        tp.setBounds(50,50,400,400);

        //adds the current prices to the frame and the rest of the butons/labels
        f.add(labelCurrentPrice0);
        f.add(labelCurrentPrice1);
        f.add(labelCurrentPrice2);
        f.add(labelCurrentPrice3);
        f.add(labelBalance);
        f.add(tp);  
        f.add(buttonExit);
        f.add(buttonReset);

        buttonExit.addActionListener(e -> { //when exit button is clicked, it saves the progress of the account and the prices
            account.saveProgress();
            m.saveProgress("stockprices.txt");
            mc.saveProgress("cryptoprices.txt");
            System.exit(0); //and exits the program
        });

        buttonReset.addActionListener(e -> { //when reset button is clicked, it resets the balance and asset held by the account
            account.addAsset("AAPL", 0);
            account.addAsset("NVDA", 0);
            account.addAsset("BTC", 0);
            account.addAsset("ETH", 0);
            account.setBalance(0);
            new PopUp("Reset Completed");
        });

        f.addWindowListener(new WindowAdapter() { //when the red cross is clicked on the actual frame, it saves the progress of the account and the prices
            public void windowClosing(WindowEvent we) {
                account.saveProgress();
            m.saveProgress("stockprices.txt");
            mc.saveProgress("cryptoprices.txt");
            System.exit(0); //and exits the program
        }});

        //properties of the frame
        f.setSize(500,660);
        f.setLayout(null);  
        f.setVisible(true);

        Timer timer = new Timer(1000, taskPerformer); //taskPerformer will run every 1 second in the background
        timer.start();
           
    }

    /**
     * Below are the panel methods.
     */
    
    public  JPanel tabTrade(JPanel p1, Account account, Market m, Market mc, Trade buy, Trade sell) { //Trade panel
        p1=new JPanel(); //creates the panel

        JButton buyButton = new JButton("Buy"); //creates the 2 buttons to sell and buy the assets
        JButton sellButton = new JButton("Sell");

        //creates the labels and the lists for the panel
        JLabel stocksText = new JLabel("Asset:");
        JLabel amountText = new JLabel("Amount:");
        String stocks[]={"AAPL","NVDA","BTC","ETH"};
        JComboBox<String> cb = new JComboBox<>(stocks);
        JTextField tf1 = new JTextField();

        //sets the bounds for the labels and buttons
        cb.setBounds(175,50,90,25);
        stocksText.setBounds(125,50,150,20);;
        amountText.setBounds(85,105,150,20);
        tf1.setBounds(140,105,150,20);
        buyButton.setBounds(120,250,150,20);
        sellButton.setBounds(120,280,150,20);

        //adds everything to the panel
        p1.add(stocksText);
        p1.add(cb);
        p1.add(amountText);
        p1.add(tf1);
        p1.add(buyButton);
        p1.add(sellButton);
        
        //makes the buy button work
        buyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String asset = (String) cb.getItemAt(cb.getSelectedIndex()); //gets the item the account selected
                    double amount = Double.parseDouble(tf1.getText()); //and the amount they typed
                    if (asset.equals("ETH") || asset.equals("BTC")) { //checks whether it is a cryptocurrency
                        buy.trade(asset, amount, account, mc); //calls the respective buy method
                    } else {
                        buy.trade(asset, amount, account, m);
                    }
                } catch(Exception exc) {
                    new PopUp("Error: must be an integer");
                }   
            }
        });

        //makes the sell button work
        sellButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String asset = (String) cb.getItemAt(cb.getSelectedIndex()); //gets the item the account
                    double amount = Double.parseDouble(tf1.getText()); //and the amount they typed
                    if (asset == "ETH" || asset == "BTC") { //checks whether it is a cryptocurrency
                        sell.trade(asset, amount, account, mc); //calls the respective method
                    } else {
                        sell.trade(asset, amount, account, m);
                    }
                } catch (Exception exc) {
                        new PopUp("Error: must be an integer");
                }
            }
        });

        return p1;
    }

    //panel for the portfolio
    public  JPanel tabPortfolio(JPanel p2, Account account, Market m, Market mc, Trade t ) {
        p2 = new JPanel(); //creates the panel

        //creates the labels for the prices and the asset holdings by the account
        double price0 = m.getCurrentPrice(0);
        String s0 = Double.toString(price0);
        JLabel labelCurrentPrice0 = new JLabel("Price AAPL: " + s0);
        JLabel labelStock0 = new JLabel(" AAPL Stocks: " + round(account.getAssetHeld("AAPL"))); //gets the amount held from the Account class

        double price1 = m.getCurrentPrice(1);
        String s1 = Double.toString(price1);
        JLabel labelCurrentPrice1 = new JLabel("Price NVDA: " + s1);
        JLabel labelStock1 = new JLabel(" NVDA Stocks: " + round(account.getAssetHeld("NVDA")));

        double price2 =mc.getCurrentPrice(0);
        String s2 = Double.toString(price2);
        JLabel labelCurrentPrice2 = new JLabel("Price BTC: " + s2);
        JLabel labelStock2 = new JLabel(" BTC Coins:" + round(account.getAssetHeld("BTC")));

        double price3 =mc.getCurrentPrice(1);
        String s3 = Double.toString(price3);
        JLabel labelCurrentPrice3 = new JLabel("Price ETH: " + s3);
        JLabel labelStock3 = new JLabel(" ETH Coins: " + round(account.getAssetHeld("ETH")));

        //a method to update the prices using the timer variable below
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double price0 = round(m.getCurrentPrice(0));
                String s0 = Double.toString(price0);
                labelCurrentPrice0.setText("Price AAPL: " + s0);
                labelStock0.setText("AAPL Stocks: " + round(account.getAssetHeld("AAPL")));
                double price1 = round(m.getCurrentPrice(1));
                String s1 = Double.toString(price1);
                labelCurrentPrice1.setText("Price NVDA: " + s1);
                labelStock1.setText("NVDA Stocks: " + round(account.getAssetHeld("NVDA")));
                double price2 = round(mc.getCurrentPrice(0));
                String s2 = Double.toString(price2);
                labelCurrentPrice2.setText("Price BTC: " + s2);
                labelStock2.setText("BTC Stocks: " + round(account.getAssetHeld("BTC")));
                double price3 = round(mc.getCurrentPrice(1));
                String s3 = Double.toString(price3);
                labelCurrentPrice3.setText("Current price of ETH: " + s3);
                labelStock3.setText("ETH Coins: " + round(account.getAssetHeld("ETH")));
            }
        };

        //every 1 second the method above is executed
        Timer timer = new Timer(1000, taskPerformer);
        timer.start();

        //adds all the labels to the panel
        p2.add(labelCurrentPrice0);
        p2.add(labelStock0);
        p2.add(labelCurrentPrice1);
        p2.add(labelStock1);
        p2.add(labelCurrentPrice2);
        p2.add(labelStock2);
        p2.add(labelCurrentPrice3);
        p2.add(labelStock3);

        return p2;
    }

    //panel for depositing and withdrawing
    public JPanel tabBalance(JPanel p3, Account account) {
        p3=new JPanel(); //creating the panel

        //creating the buttons, thetext fields and the labels
        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JTextField tf1 = new JTextField();
        JLabel amountText = new JLabel("Amount:");

        //sets the positioning for them
        amountText.setBounds(85,105,150,20);
        tf1.setBounds(140,105,150,20);
        deposit.setBounds(120,250,150,20);
        withdraw.setBounds(120,280,150,20);

        //adds them to the panel
        p3.add(tf1);
        p3.add(deposit);
        p3.add(withdraw);
        p3.add(amountText);

        //when the button to deposit is clicked it will deposit the money to the account
        deposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount;
                if (tf1.getText().equals("")) {
                    amount = 0;
                    new PopUp("Error: No number inserted");
                } else {
                    amount = Integer.parseInt(tf1.getText()); //gets the amount
                    try {
                        account.deposit(amount);
                        new PopUp("Deposited: $" + amount);
                    } catch (Exception exc) { //catches an exception
                        new PopUp("Error: must be an integer");
                    }
                }
            }
        });

        withdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount;
                if (tf1.getText().equals("")) {
                    amount = 0;
                    new PopUp("Error: No number inserted");
                } else {
                    amount = Integer.parseInt(tf1.getText()); //gets the amount
                    try {
                        Double balanceOld = account.getBalance();
                        account.withdraw(amount);
                        if (balanceOld > account.getBalance()) {
                            new PopUp("Withdrew: $" + amount);
                        }
                    } catch (Exception exc) { //catches an exception
                        new PopUp("Error: must be an integer");
                    }
                }
            }
        });
        return p3;
    }

    public  double round(double number) { //method to round the numbers
        DecimalFormat df = new DecimalFormat("###.00"); //they are rounded to 2 decimal places
        String newNumber = df.format(number);
        number = Double.parseDouble(newNumber);
        return number; 
        /**
         * NOTE: only the front end numbers are rounded, so that there isn't any losses of funds or staking
         * as a result of rounding decimals.
        */
    }

}

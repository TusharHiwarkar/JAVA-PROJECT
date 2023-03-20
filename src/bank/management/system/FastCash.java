package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class  FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pin;
    FastCash(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 750);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(160,240,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("RS 100");
        deposit.setBounds(140,350,130,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("RS 500");
        withdrawl.setBounds(290,350,130,20);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("RS 1000");
        fastCash.setBounds(140,380,130,20);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("RS 2000");
        miniStatement.setBounds(290,380,130,20);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("RS 5000");
        pinChange.setBounds(140,410,130,20);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("RS 10000");
        balanceEnquiry.setBounds(290,410,130,20);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("BACK");
        exit.setBounds(290,440,130,20);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        new FastCash("");
    }
    
}


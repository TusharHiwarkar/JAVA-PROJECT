package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton savingAccount,fdAccount,cAccount,rdAccount;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,10,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,80,200,30);
        add(type);
        
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Raleway",Font.BOLD,16));
        savingAccount.setBounds(100,120,150,20);
        savingAccount.setBackground(Color.WHITE);
        add(savingAccount);
        
        fdAccount = new JRadioButton("Fixed Deposit Account");
        fdAccount.setFont(new Font("Raleway",Font.BOLD,16));
        fdAccount.setBounds(350,120,250,20);
        fdAccount.setBackground(Color.WHITE);
        add(fdAccount);
        
        cAccount = new JRadioButton("Current Account");
        cAccount.setFont(new Font("Raleway",Font.BOLD,16));
        cAccount.setBounds(100,150,250,20);
        cAccount.setBackground(Color.WHITE);
        add(cAccount);
        
        rdAccount = new JRadioButton("Reccuring Deposit Account");
        rdAccount.setFont(new Font("Raleway",Font.BOLD,16));
        rdAccount.setBounds(350,150,250,20);
        rdAccount.setBackground(Color.WHITE);
        add(rdAccount);
        
        ButtonGroup accType = new ButtonGroup();
        accType.add(savingAccount);
        accType.add(fdAccount);
        accType.add(cAccount);
        accType.add(rdAccount);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,200,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-8877");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,200,300,30);
        add(number);
        
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,230,300,20);
        add(cardDetail);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,260,200,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,260,300,30);
        add(pnumber);
        
        JLabel pinDetail = new JLabel("Your 4 Digit Pin");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,290,300,20);
        add(pinDetail);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,340,400,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,370,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,370,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,400,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,400,200,30);
        add(c4);
        
        c5 = new JCheckBox("Chaque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,430,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,430,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,490,600,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,540,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,540,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        
        setSize(820,720);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(savingAccount.isSelected()){
                accountType = "Saving Account";
            }else if(fdAccount.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(cAccount.isSelected()){
                accountType = "Current Account";
            }else if(rdAccount.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5632328000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM CARD";
            }else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + " EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type Is Required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
    }    
        public static void main(String[] args){
        new SignupThree("");
    }
    
}

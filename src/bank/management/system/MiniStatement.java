
package bank.management.system;
import javax.swing.*;
import java.sql.*;



public class MiniStatement extends JFrame{
    MiniStatement(String pin){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        
        
        JLabel mini = new JLabel();
        mini.setBounds(40,70,400,500);
        add(mini);
        
        JLabel bank = new JLabel("Bank Of Baroda");
        bank.setBounds(140,40,100,20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(40,80,500,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(40,400,400,20);
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number : "  + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is Rs " + bal);
        }catch(Exception e){
            System.out.println(e);
        }
            
            
            
            
            
            
            
            
            
        
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }
    public static void main(String[] args){
        new MiniStatement("");
    }
    
    
}


package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    JPasswordField pText,repText;
    JButton change,back;
    String pin;
    PinChange(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,750,750);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Ststem",Font.BOLD,16));
        text.setBounds(190,210,700,35);
        image.add(text);
        
    
        
        JLabel pinText = new JLabel("NEW PIN");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Ststem",Font.BOLD,16));
        pinText.setBounds(130,260,200,25);
        image.add(pinText);
        
        pText = new JPasswordField();
        pText.setFont(new Font("Raleway",Font.BOLD,25));
        pText.setBounds(290,260,130,25);
        image.add(pText);
        
        
        JLabel repinText = new JLabel("RE-ENTER NEW PIN");
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("Ststem",Font.BOLD,16));
        repinText.setBounds(130,300,200,25);
        image.add(repinText);
        
        repText = new JPasswordField();
        repText.setFont(new Font("Raleway",Font.BOLD,25));
        repText.setBounds(290,300,130,25);
        image.add(repText);
        
        change = new JButton("Change");
        change.setBounds(320,380,100,20);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(320,410,100,20);
        back.addActionListener(this);
        image.add(back);
     
     
        
        setSize(750,750);
        setLocation(300,0);
        setUndecorated(false);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
        try{
            String npin = pText.getText();
            String rpin = repText.getText();
            
            if(!npin.equals(rpin)){
                
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter PIN");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
                return;
            }
            
            Conn c = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"'";
            
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
        
    }
    
}

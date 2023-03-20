package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{
    JTextField panNumberTextField,aadharNumberTextField;
    JButton next;
    JRadioButton syes,sno,exyes,exno;
    JComboBox Religion,Category,Occupation,Income,Education;
    String formno;
    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPICATION FORM - PAGE 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        Religion = new JComboBox(valReligion);
        Religion.setBounds(300,140,400,30);
        Religion.setBackground(Color.WHITE);
        add(Religion);
        
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300,190,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);
        
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String incomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        Income = new JComboBox(incomeCategory);
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String educationValues[] = {"Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        Education = new JComboBox(educationValues);
        Education.setBounds(300,315,400,30);
        Education.setBackground(Color.WHITE);
        add(Education);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);
        
        String occupationValues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        Occupation = new JComboBox(occupationValues);
        Occupation.setBounds(300,390,400,30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);
        
        JLabel panNumber = new JLabel("Pan Number:");
        panNumber.setFont(new Font("Raleway",Font.BOLD,20));
        panNumber.setBounds(100,440,200,30);
        add(panNumber);
        
        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panNumberTextField.setBounds(300,440,400,30);
        add(panNumberTextField);
        
        JLabel aadharNumber = new JLabel("Aadhar Number:");
        aadharNumber.setFont(new Font("Raleway",Font.BOLD,20));
        aadharNumber.setBounds(100,490,200,30);
        add(aadharNumber);
        
        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharNumberTextField.setBounds(300,490,400,30);
        add(aadharNumberTextField);
        
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup senior = new ButtonGroup();
        senior.add(syes);
        senior.add(sno);
        
        JLabel exAccount = new JLabel("Exisiting Account:");
        exAccount.setFont(new Font("Raleway",Font.BOLD,20));
        exAccount.setBounds(100,590,200,30);
        add(exAccount);
        
        exyes = new JRadioButton("Yes");
        exyes.setBounds(300,590,100,30);
        exyes.setBackground(Color.WHITE);
        add(exyes);
        
        exno = new JRadioButton("No");
        exno.setBounds(450,590,100,30);
        exno.setBackground(Color.WHITE);
        add(exno);
        
        ButtonGroup exaccount = new ButtonGroup();
        exaccount.add(exyes);
        exaccount.add(exno);
        
        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,650,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String sreligion = (String)Religion.getSelectedItem();
        String scategory =  (String)Category.getSelectedItem();
        String sincome =(String)Income.getSelectedItem();
        String seducation = (String)Education.getSelectedItem();
        String soccupation = (String) Occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected())
        {
            seniorcitizen = "Yes";
        }else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String exisitingaccount = null;
        if(exyes.isSelected()){
            exisitingaccount = "Yes";
        }else if(exno.isSelected()){
            exisitingaccount = "Unmarried";
        }
        
        String span = panNumberTextField.getText();
        String saadhar = aadharNumberTextField.getText();
        
        
        try{
            
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+exisitingaccount+"','"+span+"','"+saadhar+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        new SignupTwo("");
        
        
    }
        
        
    
}

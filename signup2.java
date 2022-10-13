
package atm.simulator.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup2 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JCheckBox ch1;
    JButton b1,b2,b3;
    JTextField t1,t2,t3;
    JPasswordField ps1 ;
    JComboBox cb1, cb2,cb3,cb4;        
     
    signup2()
    {
        super("ATM Simulator System --> Signup");
        
        setLayout(null);
        setSize(700,700);
        setLocation(350,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("Form no :-");
        l1.setBounds(200, 30, 200, 50);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l2 = new JLabel("Category :- ");
        l2.setBounds(200, 120, 100, 30);
        l3 = new JLabel("Income :- ");
        l3.setBounds(200,180,100,30);
        l4 = new JLabel("Occupation :- ");
        l4.setBounds(200,240,100,30);
        l5 = new JLabel("AADHAR :- ");
        l5.setBounds(200,300,100,30);
        l6 = new JLabel("PAN :- ");
        l6.setBounds(200,360,100,30);
        l7 = new JLabel("Account Type :- ");
        l7.setBounds(200,420,100,30);
        
        t1 = new JTextField();
        t1.setBounds(400, 30,150,50);
        t1.setFont(new Font("Arial",Font.BOLD,20));
        t2 = new JTextField();
        t2.setBounds(400,300,150,30);
        t3 = new JTextField();
        t3.setBounds(400,360,150,30);
       
        
        b1 = new JButton("Submit");
        b2 = new JButton("back");
        
        ch1 = new JCheckBox("I hereby decalre that all the details mentioned by me are correct",true);
        ch1.setBounds(200, 500, 400, 20);
        ch1.setFont(new Font("Raleway",Font.ITALIC,10));
        ch1.setBackground(Color.WHITE);
        
        String category[] = {"General","OBC","SC","ST","Other"};
        cb1= new JComboBox(category);
        cb1.setBounds(400,120,100,30);
        String income[] = {"Null","<100,000","<200,000","<500,000"};
        cb2 = new JComboBox(income);
        cb2.setBounds(400, 180, 100, 30);
        String occupation[] = {"Student","Salaried","Self-employed","Other"};
        cb3= new JComboBox(occupation);
        cb3.setBounds(400, 240, 100, 30);
        String account[] = {"Saving","Current","Fixed Deposit","Recurring Deposit"};
        cb4 = new JComboBox(account);
        cb4.setBounds(400, 420, 100, 30);
        
        b1 = new JButton("Submit");
        b1.setBounds(500, 600, 100, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Back");
        b2.setBounds(200, 600, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(l1);
        add(t1);
        add(l2);
        add(cb1);
        add(l3);
        add(cb2);
        add(l4);
        add(cb3);
        add(l5);
        add(t2);
        add(l6);
        add(t3);
        add(l7);
        add(cb4);
        add(ch1);
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b2)
        {
            new Login().setVisible(true);
            dispose();
        }
        try
        {
            if(ae.getSource()==b1)
            {   
                if(t1.getText()=="" || t2.getText()=="" || t3.getText()=="" /*|| !(ch1.isSelected())*/)
                {
                    JOptionPane.showMessageDialog(null,"Please fill all fields");
                }
                else
                {
                conn c1 = new conn();
                
                String formno2 = t1.getText();
                String category = (String)cb1.getSelectedItem();
                String income = (String)cb2.getSelectedItem();
                String occupation = (String)cb3.getSelectedItem();
                String account = (String)cb4.getSelectedItem();
                String aadhar = t2.getText();
                String pan = t3.getText();
                
            
                Random ran = new Random();
                long temp_cardno = (ran.nextLong() % 90000000L) + 5344624400000000L;
                long cardno = Math.abs(temp_cardno);
                long temp_pin = (ran.nextLong() % 9000L)+1000L;
                long pin = Math.abs(temp_pin);
            
                    
                
                ResultSet rs  = c1.s1.executeQuery("Select * from signup1");
                while (rs.next())
                    {
                    String formno1 = rs.getString("formno");
                    if(formno1.equals(formno2))
                        {
                             String q1 = "insert into signup2 values('"+category+"','"+income+"','"+occupation+"','"+aadhar+"','"+pan+"','"+cardno+"','"+pin+"','"+account+"');";
                             c1.s1.executeUpdate(q1);
                  
                             String q2 = "insert into login values('"+cardno+"','"+pin+"');";
                             c1.s1.executeUpdate(q2);
                             
                             
                  
                             JOptionPane.showMessageDialog(null,"Your Card Number is "+cardno+"\n Your pin is "+pin+"\n Please remenber these credentials");
                
                             new deposit_new().setVisible(true);
                             setVisible(false);
                             break;
                        }
                
                    }
                }
                
        
            }
        }catch(Exception e)
        {
            System.out.println("Exception found"+e);
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new signup2().setVisible(true);
    }
}
        


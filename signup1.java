
package atm.simulator.system;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;

public class signup1 extends JFrame implements ActionListener 
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    
    Random ran = new Random();
    long temp4 = (ran.nextLong() % 9000L)+1000L;
    long first = Math.abs(temp4);
    signup1()
    {
        super("ATM Simulator System --> Signup ");
       
        setSize(700,700);
        setLayout(null);
        setLocation(350,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        l1 = new JLabel("Application no : "+first);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l2 = new JLabel("Personal details :- ");
        l3 = new JLabel ("Name:- ");
        l4 = new JLabel("Father's Name :- ");
        l5 = new JLabel("Date of Birth :- ");
        
        l6 = new JLabel("Email Address :- ");
        l7 = new JLabel("Address :- ");
        l8 = new JLabel("State :- ");
        l9= new JLabel("City:- ");
        
        
        t1 = new JTextField("Your name");
        t2 = new JTextField("Father's name");
        t3 = new JTextField("date-month-year");
        
        t4 = new JTextField("abcd@xyz.com");
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        
        
        b1 = new JButton("Next-->");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        add(l1);
        l1.setBounds(250,30,200,30);
        add(l2);
        l2.setBounds(100,80,150,30);
        add(l3);
        l3.setBounds(100,130,100,30);
        add(l4);
        l4.setBounds(100,180,100,30);
        add(l5);
        l5.setBounds(100,230,100,30);
        add(l6);
        l6.setBounds(100,280,100,30);
        add(l7);
        l7.setBounds(100,330,100,30);
        add(l8);
        l8.setBounds(100,380,100,30);
        add(l9);
        l9.setBounds(100,430,100,30);
        
        
        add(t1);
        t1.setBounds(220,130,300,30);
        add(t2);
        t2.setBounds(220,180,300,30);
        add(t3);
        t3.setBounds(220,230,300,30);
        add(t4);
        t4.setBounds(220,280,300,30);
        add(t5);
        t5.setBounds(220,330,300,30);
        add(t6);
        t6.setBounds(220,380,300,30);
        add(t7);
        t7.setBounds(220,430,300,30);
       
        add(b1);
        b1.setBounds(450, 580, 100, 30);
        
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            if(t1.getText()=="" || t2.getText()=="" || t3.getText()=="")
            {
                JOptionPane.showMessageDialog(null,"Please fill all fields");
            }
            else
            {
                conn c1 = new conn();
                
                String name = t1.getText();
                String fname = t2.getText();
                String dob = t3.getText();
                String a = t5.getText();
                String b = t6.getText();
                String c = t7.getText();
                String address = a+" "+b+" "+c;
                String email = t4.getText();
       
                String qq= "Insert into signup1 values('"+name+"','"+fname+"','"+dob+"','"+address+"','"+email+"','"+first+"');";
                c1.s1.executeUpdate(qq);
               JOptionPane.showMessageDialog(null,"Data saved Successfully ");
                new signup2().setVisible(true);
               setVisible(false);
               dispose();
            }
            
        }catch(Exception e)
        {
            System.out.println("error opccured "+e);
        }
    }
public static void main(String args[])
{
    new signup1().setVisible(true);
}

}


package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class deposit_new extends JFrame implements ActionListener  
{
    JLabel l1,l2,l3;
    JButton b1,b2;
    JTextField t1,t2;
    
    deposit_new()
    {
         super("ATM Simulator System --> Deposite");
         setLayout(null);
         setSize(500,500);
         setLocation(400,100);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setBackground(Color.WHITE);
         ImageIcon i = new ImageIcon("D:\\Software\\java\\workspace\\atmsimulator\\src\\atmsimulatorsystem\\Deposit.png");  
         
         l1= new JLabel(i);
         l2= new JLabel("Enter Amount:- ");
         l3= new JLabel("Enter pin :- ");
         b1= new JButton("Submit");
         b2 = new JButton("Exit");
         t1= new JTextField();
         t2= new JTextField();
         
         add(l1);
         l1.setBounds(180, 20, 140, 140);
         add(l2);
         l2.setBounds(70,200,100,30);
         add(l3);
         l3.setBounds(70,250,100,30);
         add(t1);
         t1.setBounds(200, 200, 200, 30);
         add(t2);
         t2.setBounds(200, 250, 200, 30);
         add(b1);
         b1.setBounds(120,330,100,30);
         b1.setBackground(Color.BLACK);  
         b1.setForeground(Color.WHITE);
         add(b2);
         b2.setBounds(300,330,100,30);
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         
         b1.addActionListener(this);
         b2.addActionListener(this);
        
         
    }
    public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==b1)
            {
                try
                {   
                 String pin = t2.getText();
                 String d1 = t1.getText();
                 
                 conn c1 = new conn();
                 String q = "insert into bank values('"+pin+"','"+d1+"',null,'"+d1+"');";
                 c1.s1.executeUpdate(q);
                 String q2 = "insert into bankmain values('"+pin+"','"+d1+"');";
                 c1.s1.executeUpdate(q2);
                 JOptionPane.showMessageDialog(null,"Money successfully deposited ");
                 new Login().setVisible(true);
                 dispose();
                }catch(Exception e)
                {
                    System.out.println("Exception occured "+e);
                    e.printStackTrace();
                }
            }
            if(ae.getSource()==b2)
            {
                System.exit(0);
            }
        }
    public static void main(String args[])
    {
        new deposit_new().setVisible(true);
    }
}
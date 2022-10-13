
package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener
{
    JButton b1,b2;
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField p1;
    
    Withdraw()
    {
         super("ATM Simulator System --> Withdraw");
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
         p1= new JPasswordField();
         
         add(l1);
         l1.setBounds(180, 20, 140, 140);
         add(l2);
         l2.setBounds(70,200,100,30);
         add(l3);
         l3.setBounds(70,250,100,30);
         add(t1);
         t1.setBounds(200, 200, 200, 30);
         add(p1);
         p1.setBounds(200, 250, 200, 30);
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
        if(ae.getSource()==b2)
            {
                new transaction().setVisible(true);
                dispose();
            }
                    if(ae.getSource()==b1)
            {
                try
                {   
                conn c1 = new conn();
                
                double balance=0;
                double amt = Double.parseDouble(t1.getText());
                String pin = p1.getText();
                String s1 = "Select balance from bankmain where pin='"+pin+"'";
                ResultSet rs = c1.s1.executeQuery(s1);
                
                 if(rs.next())
                 {
                     balance = rs.getDouble("balance");
                     balance -= amt;
                    
                     String s2 = "Insert into bank values ('"+pin+"',null,'"+amt+"','"+balance+"')";
                     c1.s1.executeUpdate(s2);
                     String s3 =" update bankmain set balance='"+balance+"' where pin ='"+pin+"';";
                     c1.s1.executeUpdate(s3);
                     
                     JOptionPane.showMessageDialog(null,"Amount Successfully Deducted, now balance is "+balance);
                     new transaction().setVisible(true);
                     dispose();
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Incorrect Pin ");
                 }
                
             
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"An Error Occured");
                }
                
                
            }

    }
    public static void main(String args[])
    {
        new Withdraw().setVisible(true);
    }  

}


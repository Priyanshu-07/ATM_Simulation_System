
package atm.simulator.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class transaction extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7;
    JLabel l1;
    
    transaction()
    {
        super("ATM Simulator System --> Transactions ");
        
        setSize(700,700);
        setLayout(null);
        setLocation(350,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1= new JLabel("Transactions");
        
        b1= new JButton("Deposit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2= new JButton("Withdraw");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b3= new JButton("Mini Statement");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b4= new JButton("Fast cash");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b5= new JButton("Pin Change");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b6= new JButton("Balance Enquiry");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b7= new JButton("Exit");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        
        add(l1);
        l1.setFont(new Font("Algerian",Font.BOLD,55));
        l1.setBounds(150,30,600,100);
        add(b1);
        b1.setBounds(100,250,200,50);
        add(b2);
        b2.setBounds(400,250,200,50);
        add(b3);
        b3.setBounds(100,350,200,50);
        add(b4);
        b4.setBounds(400,350,200,50);
        add(b5);
        b5.setBounds(100,450,200,50);
        add(b6);
        b6.setBounds(400,450,200,50);
        add(b7);
        b7.setBounds(250,550,200,50);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new Deposite().setVisible(true);
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==b2)
        {
            new Withdraw().setVisible(true);
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==b3)
        {
            new Ministatement().setVisible(true);
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==b4)
        {
            new Fastcash().setVisible(true);
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==b5)
        {
            new Change().setVisible(true);
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==b6)
        {
            new Balance().setVisible(true);
            setVisible(false);
            dispose();
        }
        if(ae.getSource()==b7)
        {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new transaction().setVisible(true);
    }

}

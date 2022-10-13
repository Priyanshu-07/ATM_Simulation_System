
package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener
{
    JComboBox cb1;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6;
    String pin;
    int count=0;
    
    Fastcash()
    {
        super("ATM Simulator System --> Fast Cash");
        setSize(500,500);
        setLocation(350,100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        
        l1 = new JLabel("Please Validate Pin Before proceeding ");
        l2 = new JLabel(" FAST CASH ");
        b1 = new JButton("Add Transaction");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2 = new JButton("Show list ");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b3 = new JButton("Validate");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b4 = new JButton("Proceed Transaction ");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b5 = new JButton(" Back ");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b6 = new JButton(" Exit ");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        
        cb1 = new JComboBox();
        
        add(l2);
        l2.setBounds(130, 50, 400, 40);
        l2.setFont( new Font("Algerian",Font.BOLD,40));
        add(cb1);
        cb1.setBounds(80, 120, 350, 40);
        cb1.setBackground(Color.WHITE);
        cb1.setFont(new Font("Arial",Font.BOLD,20));
        add(b4);
        b4.setBounds(80,200,180,30);
        add(b2);
        b2.setBounds(280,200, 150, 30);
        add(l1);
        l1.setBounds(70, 250, 400, 30);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        add(b1);
        b1.setBounds(80,300,180,30);
        add(b3);
        b3.setBounds(280,300,150,30);
        add(b5);
        b5.setBounds(80,350,180,30);
        add(b6);
        b6.setBounds(280,350,150,30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
       
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==b2)
       {
           showele();
       }
       if(ae.getSource()==b1)
       {
           addtxn();
       }
       if(ae.getSource()==b3)
       {
           testpin();
       }
       if(ae.getSource()==b4)
       {
           txn();
       }
       if(ae.getSource()==b5)
       {
           new transaction().setVisible(true);
           dispose();
       }
       if(ae.getSource()==b6)
       {
           System.exit(0);
       }
    }
    public int testpin()
    {
        
       pin = JOptionPane.showInputDialog("Please enter the pin");
        try
        {
            
        
             conn c1 = new conn();
             ResultSet rs = c1.s1.executeQuery("Select pin from bankmain;");
             while(rs.next())
             {
                 String pn = rs.getString("pin");
                 if(pin.equals(pn))
                 {
                   count = 1;  
                 }
             }
            
        }catch(Exception e){System.out.println("exceptionnnnnnn "+e);}
       return count;
    }
    public void showele()
    {
        if(count==1)
        {
            cb1.removeAllItems();
            try
            {
                conn c1 = new conn();
                ResultSet rs1 = c1.s1.executeQuery("Select txn_name from fastcash where pin ='"+pin+"';");
                while(rs1.next())
                     {
                         String ele = rs1.getString("txn_name");
                         cb1.addItem(ele);
                     }
            }catch(Exception ee){}
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Incorrect Pin entered");
            
        }
    }
    public void addtxn()
    {
        if(count==1)
        {
            try
            {
                conn c1 = new conn();
                String tname = JOptionPane.showInputDialog("Please enter Transaction name");
                String tamt = JOptionPane.showInputDialog("Please enter transaction amount");
                String q1 = "Insert into fastcash values('"+pin+"','"+tname+"','"+tamt+"');";
                c1.s1.executeUpdate(q1);
            }catch(Exception ee){}
        }
        else
        {
        JOptionPane.showMessageDialog(null, "Incorrect Pin entered or not Validated ");
            
        }
    }
    public void txn()
    {
        if(testpin()==1)
        {
            try
            {
                conn c1 = new conn();
                String txname = (String)cb1.getSelectedItem();
                double balance = 0,txamt = 0;
                ResultSet rs2 = c1.s1.executeQuery("Select amount from fastcash where pin='"+pin+"' and txn_name = '"+txname+"';");
                if(rs2.next())
                {
                    txamt = rs2.getDouble("amount");
                }
                
                ResultSet rs1 = c1.s1.executeQuery("Select balance from bankmain where pin='"+pin+"';");
                if(rs1.next())
                {
                    balance = rs1.getDouble("balance");
                }        
                balance -= txamt;
                String q2 = "Insert into bank values('"+pin+"',null,'"+txamt+"','"+balance+"');";
                c1.s1.executeUpdate(q2);
                String q3 = "Update bankmain set balance='"+balance+"' where pin = '"+pin+"';";
                c1.s1.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null," Transaction Updated amount = "+txamt+" \n balance = "+balance);
            }catch(Exception ee)
            {
                System.out.println("EXCEPTION "+ee);
            }
        }
    }
    public static void main(String args[])
    {
        new Fastcash().setVisible(true);
    }
}

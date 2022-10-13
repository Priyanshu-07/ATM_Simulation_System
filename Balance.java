
package atm.simulator.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener
{
  JLabel l1,l2,l3;
  JPasswordField p1;
  JButton b1,b2;
  
  Balance()
  {
      super("ATM Simulator System --> Balance ");
      
      setSize(500,500);
      setLocation(400,100);
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      l1 =new JLabel("Your Balance :-");
      l2 = new JLabel();
      l3 = new JLabel("Pin :- ");
      
      b1= new JButton("<< Back");
      b2 = new JButton("Show Balance");
      
      p1 = new JPasswordField();
      
      add(l1);
      l1.setBounds(100,30,250,80);
      l1.setFont(new Font("Arial",Font.BOLD,35));
      add(l2);
      l2.setBounds(150,150,250,80);
      l2.setFont(new Font("Arial",Font.BOLD,40));
      add(l3);
      l3.setBounds(160,250,40,30);
      add(p1);
      p1.setBounds(200,250,100,30);
      add(b1);
      b1.setBounds(200,380,100,30);
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.WHITE);
      add(b2);
      b2.setBounds(180,330,150,30);
      b2.setBackground(Color.BLACK);
      b2.setForeground(Color.WHITE);

      b1.addActionListener(this);
      b2.addActionListener(this);
      
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new transaction().setVisible(true);
            dispose();
        }
        if(ae.getSource()==b2)
        {
            try
            {
                conn c1 = new conn();
                
                String pin = p1.getText();
                ResultSet rs = c1.s1.executeQuery("Select balance from bankmain where pin = '"+pin+"';");
                if(rs.next())
                {
                    String bal = rs.getString("balance");
                    l2.setText(bal);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Input");
                }
                
                
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[])
    {
        new Balance().setVisible(true);
    }
    
    
}


package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Change extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    JPasswordField p1,p2,p3;
    
    Change()
    {
      
      super("ATM Simulator System --> Pin Change ");
      
      setSize(500,500);
      setLocation(400,100);
      setLayout(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      l1 =new JLabel("Change PIN");
      l2 = new JLabel("Pin :- ");
      l3 = new JLabel("New Pin :- ");
      l4 = new JLabel("Confirm Pin :-");
      
      b1= new JButton("<< Back");
      b2 = new JButton("Submit");
      
      p1 = new JPasswordField();
      p2 = new JPasswordField();
      p3 = new JPasswordField();
      
      add(l1);
      l1.setBounds(150,30,250,80);
      l1.setFont(new Font("Arial",Font.BOLD,35));
      add(l2);
      l2.setBounds(150,150,80,30);
      l2.setFont(new Font("Arial",Font.BOLD,25));
      add(l3);
      l3.setBounds(150,200,80,30);
      add(l4);
      l4.setBounds(150,250,80,30);
      add(p1);
      p1.setBounds(300,150,80,30);
      add(p2);
      p2.setBounds(300,200,80,30);
      add(p3);
      p3.setBounds(300,250,80,30);
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
                String npin = p2.getText();
                String cpin = p3.getText();
                
                ResultSet rs = c1.s1.executeQuery("Select pin from bankmain;");
                if(npin.equals(cpin))
                {
                    while(rs.next())
                    {
                        if(npin.equals(rs.getString("pin")))
                        {
                            JOptionPane.showMessageDialog(null,"Pin is already allocated \n Try again.");
                            break;
                        }
                        else
                        {
                         String q = "update bankmain set pin = '"+npin+"' where pin='"+pin+"';";
                         c1.s1.executeUpdate(q);
                         String q1 = "update bank set pin = '"+npin+"' where pin='"+pin+"';";
                         c1.s1.executeUpdate(q1);
                         String q2 = "update signup2 set pin = '"+npin+"' where pin='"+pin+"';";
                         c1.s1.executeUpdate(q2);
                         String q3 = "update login set pin = '"+npin+"' where pin='"+pin+"';";
                         c1.s1.executeUpdate(q3);
                   
                         JOptionPane.showMessageDialog(null,"Pin Successfully Changed");
                         new transaction().setVisible(true);
                         dispose();
                         break;
                         
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Pin does not match");
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main (String args[])
    {
        new Change().setVisible(true);
    }     
       

}

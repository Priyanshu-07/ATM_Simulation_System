
package atm.simulator.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Ministatement extends JFrame implements ActionListener
{
    JButton b1 ;
    //JPasswordField p1;
    JTable t1;
    //JLabel l1;
    JScrollPane sp;
    String x[]={"Deposit","Withdraw","Balance"};
    String y[][] = new String[30][3];
    int i=0,j=0;
    
    Ministatement()
    {
        super("ATM Simulator System --> Statement");
        setSize(500,500);
        setLocation(350,100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        b1 = new JButton("Back");
        
        
        String pin = JOptionPane.showInputDialog("Please Enter Pin ");
        
        try
        {
           conn c1 = new conn();
                 ResultSet rs = c1.s1.executeQuery("Select * from bank where pin='"+pin+"';");
                        if(rs.next())
                        {
                         while(rs.next())
                            {
                                y[i][j++] = rs.getString("deposit");
                                y[i][j++] = rs.getString("withdraw");
                                y[i][j++] = rs.getString("balance");
                                j=0;
                                i++;
                            }
                            t1 = new JTable(y,x);
                            sp = new JScrollPane(t1);
                         
                        }
             
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Incorrect Credentials or No Statement to Show");
                            new transaction().setVisible(true);
                            dispose();
                            
                        }
                    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    add(sp);
    sp.setBounds(40, 20, 400, 300);
    add(b1);
    b1.setBounds(180,350,80,40);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
    
    b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new transaction().setVisible(true);
            dispose();
        }
       
    }
   public static void main(String args[])
   {
       new Ministatement().setVisible(true);
   }
    
}

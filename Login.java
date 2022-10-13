
package atm.simulator.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener
{
    JButton b, b2,b3;
    JLabel l1;
    JLabel l2,l3;
    JTextField t1;
    JPasswordField p1;
    Login()
    {
        super("ATM Simulator System");
        setLayout(null);
        setSize(500,500);
        setLocation(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i = new ImageIcon("D:\\Software\\java\\workspace\\atmsimulator\\src\\atmsimulatorsystem\\icon.png");
        getContentPane().setBackground(Color.WHITE);
       
        
        b = new JButton(" Login ");
        b2 = new JButton(" Clear ");
        b3 = new JButton(" New User   >>   SignUp ");
        l1 = new JLabel(" Card Number: ");
        l2 = new JLabel(" Password: ");
        l3 = new JLabel(i);
        t1 = new JTextField(15);
        p1 = new JPasswordField(15);
        add(l3);
        l3.setBounds(180,20,130,130);
        add(l1);
        l1.setBounds(70,200,100,30);
        add(t1);
        t1.setBounds(200, 200, 200, 30);
        add(l2);
        l2.setBounds(70,250,100,30);
        add(p1);
        p1.setBounds(200, 250, 200, 30);
        add(b);
        b.setBounds(120,330,100,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        add(b2);
        b2.setBounds(300, 330, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b3);
        b3.setBounds(120, 370, 280, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        b.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }
        public void actionPerformed(ActionEvent ae)
        {
         try{
            conn c1 = new conn();
         
            String  u = t1.getText();
            String ps = p1.getText();
            String q = "Select * from login where cardno = '"+u+"' and pin = '"+ps+"'";
            ResultSet rs = c1.s1.executeQuery(q); 
            if(ae.getSource()==b)
             {
                 if(rs.next())
                 {
                      new transaction().setVisible(true);
                    setVisible(false);
                    dispose();
                 }
                 else 
                 {
                     JOptionPane.showMessageDialog(null,"Invalid Card number or Password");
                 }
                 
             }
            if(ae.getSource()==b2)
            {
                t1.setText("");
                p1.setText("");
            }
            
            
            } catch(Exception e)
            {
             System.out.println("Exception :"+e);   
            }
         if(ae.getSource()==b3)
         {
             new signup1().setVisible(true);
             dispose();
         }
        }
         public static void main(String args[])
         {
            new Login().setVisible(true);
         }
    }


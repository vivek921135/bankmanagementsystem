
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.*;

public class Login extends JFrame implements ActionListener {
    
 JButton signin, signup , clear ;
 JTextField cardtextfield;
 JPasswordField pintextfield; // for making pin privacy we used jpasswordfield

    Login()//constructor by clicking login class only jframe will be created automatically
    {
        setTitle("Automated Teller Machine");
        setLayout(null);//to off the default layout of java swing
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//imageicon is the class used fro taking the image from the dekstop
        // now we have to place this image on the jframe but we cant direcctly do that so we created jlabel
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT); //for giving the size or scaling of the image we required
        ImageIcon i3= new ImageIcon(i2);// jlabel cant use image class of awt so converted again to imageicon after changing its size
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);//setting the location of image on jframe
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
         JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pintextfield= new JPasswordField();
        pintextfield.setBounds(300,220,230,30);
        pintextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(pintextfield);
        
         JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardtextfield= new JTextField();
        cardtextfield.setBounds(300,150,230,30);
        cardtextfield.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtextfield);
        
        signin =new JButton("Sign in");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setBounds(300,300,100,30);
        signin.addActionListener(this);
        add(signin);
        
        clear=new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("Sign Up");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);// to change the background colour of jframe
        
        setSize(800,480); // setting length and breadth of frame
        setVisible(true); // default visibility of jframe is false so we hev to make it true
        setLocation(350,200); // to set the location of jframe on screen
    }
    
    public void actionPerformed(ActionEvent ae)// tells us what we have to do(performed) when any button is clicked
    {
        if(ae.getSource()== clear){
              cardtextfield.setText("");
              pintextfield.setText("");

        }
        else if(ae.getSource()== signin){
            Conn conn= new Conn();
            String cardnumber= cardtextfield.getText();
            String pinnumber=pintextfield.getText();
            String query="select * from login where card_number= '"+cardnumber+"' and pin='"+pinnumber+"'";
            
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()== signup){
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
       new Login(); // creating object for login class
    }
}

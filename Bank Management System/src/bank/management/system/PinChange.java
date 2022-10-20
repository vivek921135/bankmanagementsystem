
package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener{

    JPasswordField newpin,repin;
    JButton change,back;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel im= new JLabel(i3);
        im.setBounds(0,0,900,900);
        add(im);
        
        JLabel text= new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        im.add(text);
        
        JLabel pintext= new JLabel("New PIN:");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        im.add(pintext);
        
        newpin= new JPasswordField();
        newpin.setFont(new Font("Raleway",Font.BOLD,25));
        newpin.setBounds(330,320,180,25);
        im.add(newpin);
        
        JLabel repintext= new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165,360,180,25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        im.add(repintext);
        
        repin= new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        im.add(repin);
        
        change= new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        im.add(change);
        
        back= new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        im.add(back);
        
         setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin=newpin.getText();
            String rpin=repin.getText();
            
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter new Pin");
                return; 
            }
            
            if(rpin.equals("")){
               JOptionPane.showMessageDialog(null, "Please re-enter new Pin");
                return; 
            }
           Conn c = new Conn();
           String query1= "update bank set pin='"+rpin+"' where pin='"+pinnumber+"' ";
           String query2= "update login set pin='"+rpin+"' where pin='"+pinnumber+"' ";
           String query3= "update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"' ";
            
           c.s.executeUpdate(query1);
           c.s.executeUpdate(query2);
           c.s.executeUpdate(query3);
           
           JOptionPane.showMessageDialog(null, "PIN Changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }
        catch(Exception e){
           System.out.println(e); 
        }
    }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}



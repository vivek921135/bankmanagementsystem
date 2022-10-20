
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*; // package required for random class
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener{
    
    String formno;
    JTextField pan,aadhar;
    JComboBox religion,category,income,education,occupation;
    JRadioButton senior,nonsenior,existing,nonexisting;
     JButton next;

    Signuptwo(String formno){
        this.formno =formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionaldetails= new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel name= new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
         religion= new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel fname= new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
         category= new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob= new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valIncome[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
         income= new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender= new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email= new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,320,200,30);
        add(email);
        
        String valEducation[]={"Non Graduate","Graduation","Post Graduation","Doctrate","Other"};
        education= new JComboBox(valEducation);
        education.setBounds(300,320,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel marital= new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String valOccupation[]={"Student","Salaried","Self-Employed","Bussiness","Retired","Other"};
         occupation= new JComboBox(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel address= new JLabel("Pan Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan= new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city= new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar= new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state= new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        senior= new JRadioButton("Yes");
        senior.setBackground(Color.WHITE);
        senior.setBounds(300,540,100,30);
        add(senior);
        
        nonsenior= new JRadioButton("No");
        nonsenior.setBackground(Color.WHITE);
        nonsenior.setBounds(450,540,100,30);
        add(nonsenior);
        
        ButtonGroup seniorGroup= new ButtonGroup();//these are used bcoz we can choose only one at a time from these radio butttons
        seniorGroup.add(senior);
        seniorGroup.add(nonsenior);
        
        JLabel pincode= new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
      
        existing= new JRadioButton("Yes");
        existing.setBackground(Color.WHITE);
        existing.setBounds(300,590,100,30);
        add(existing);
        
        nonexisting= new JRadioButton("No");
        nonexisting.setBackground(Color.WHITE);
        nonexisting.setBounds(450,590,100,30);
        add(nonexisting);
        
        ButtonGroup existingGroup= new ButtonGroup();//these are used bcoz we can choose only one at a time from these radio butttons
        existingGroup.add(existing);
        existingGroup.add(nonexisting);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);// to change the background colour of jframe
        
       setSize(850,800); // setting length and breadth of frame
       setVisible(true); // default visibility of jframe is false so we hev to make it true
       setLocation(350,10);
    }
   
    public void actionPerformed(ActionEvent ae){
      String sreligion = (String)religion.getSelectedItem(); 
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        String scitizen = "";
        if(senior.isSelected()){ 
            scitizen = "Yes";
        }
        else if(nonsenior.isSelected()){ 
            scitizen = "No";
        }
           
        String eaccount = "";
        if(existing.isSelected()){ 
            eaccount = "Yes";
        }else if(nonexisting.isSelected()){ 
            eaccount = "No";
        }
       
        
        try{
                Conn c= new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+scitizen+"','"+eaccount+"')";
                c.s.executeUpdate(query);
             
                setVisible(false);
                new Signup3(formno).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new Signuptwo("");
    }
}
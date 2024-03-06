
package electricity.billing.system;

/**
 *
 * @author sougato
 */

import javax.swing.*;
import javax.swing.border.*; //as java doesnt import the subpackages only classes are imported
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    //Global Variables
    JButton create, back;
    Signup(){
        //setSize(700,400)
        //setLocation(450,150)
        // or we can use setBounds() 
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel=new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230), 2),"Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173,216,230))); 
        //by defualt it's empty
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        
        //Heading Label
        JLabel heading=new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20); 
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma" , Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(heading);//setting it over the panel and not the frame
   
        // Choice of account type
        Choice accountType=new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);
        
        //Meter number Label
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20); 
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblmeter);//setting it over the panel and not the frame
   
        //Input Field for meter number
        JTextField meter=new JTextField();
        meter.setBounds(260, 90, 150, 20);
        panel.add(meter);
        
        //Username Label
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20); 
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblusername);//setting it over the panel and not the frame
   
        //Input Field for Username
        JTextField username=new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
        
        //Name Label
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20); 
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblname);//setting it over the panel and not the frame
   
        //Input Field for Name
        JTextField name=new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);
        
        //Password Label
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20); 
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblpassword);//setting it over the panel and not the frame
   
        //Input Field for Password
        JTextField password=new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        //Buttons
        //Create Button
        create=new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);
        
        //Back Button
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,260,120,25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(415,30,250,250);
        panel.add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new Signup();
    }
}

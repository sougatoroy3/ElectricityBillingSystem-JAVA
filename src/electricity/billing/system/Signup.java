
package electricity.billing.system;

/**
 *
 * @author sougato
 */

import javax.swing.*;
import javax.swing.border.*; //as java doesnt import the subpackages only classes are imported
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener{
    
    //Global Declaration of Variables
    JButton create, back;
    Choice accountType;
    JTextField meter, username, name, password;
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
        accountType=new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);
        
        
        //Meter number Label
        JLabel lblmeter=new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20); 
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        lblmeter.setVisible(false);
        panel.add(lblmeter);//setting it over the panel and not the frame
   
        //Input Field for meter number
        meter=new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        //Username Label
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20); 
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblusername);//setting it over the panel and not the frame
   
        //Input Field for Username
        username=new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);
        
        //Name Label
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20); 
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblname);//setting it over the panel and not the frame
   
        //Input Field for Name
        name=new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Password Label
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20); 
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));//Tahoma is font style and 14 is font size
        panel.add(lblpassword);//setting it over the panel and not the frame
   
        //Input Field for Password
        password=new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);
        
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
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
            String atype=accountType.getSelectedItem();//item is retrieved 
            String susername=username.getText();
            String sname=name.getText();
            String spassword=password.getText();
            String smeter=meter.getText();
            
            //under try and catch block cause there may be a chance of exception
            try{
                Conn c=new Conn();
                String query=null; //creating a query 
                //inserting as per table
                if (atype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"')";
                } else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                setVisible(false);
                new Login();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new Signup();
    }
}

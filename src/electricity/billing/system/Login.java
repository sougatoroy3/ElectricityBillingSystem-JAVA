
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    
    Login(){
        super("Login Page"); //to add a heading
        // super must always be the first statement to a constructor
        getContentPane().setBackground(Color.WHITE); // to set background colour
        
        // setting up the layout of the components
        // by default it's in border layout
        setLayout(null);
        
        //USERNAME
        JLabel lblusername=new JLabel("Username"); // to show some text in the frame
        // manually placing the components
        lblusername.setBounds(300, 20, 100, 20); //only works when setLayout is null
        add(lblusername);
        
        // INPUT FIELD for username
        JTextField username=new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);
        
        //PASSWORD
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);
        
        // INPUT FIELD for password
        JTextField password=new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);
        
        //LOGIN AS
        JLabel loggininas=new JLabel("Log in as");
        loggininas.setBounds(300, 100, 100, 20);
        add(loggininas);
        
        // Create a drop down for login as componenet
        // we can use choice class(awt) or jcombobox(swing)
        Choice logginin=new Choice();
        logginin.add("Admin");
        logginin.add("Customer");
        logginin.setBounds(400, 100, 150, 20);
        add(logginin);
        
        //Login Button with image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        JButton login=new JButton("Login", new ImageIcon(i2));
        login.setBounds(330, 160, 100, 20);
        add(login);
        
        //Cancel Button with image
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        JButton cancel=new JButton("Cancel", new ImageIcon(i4));
        cancel.setBounds(430, 160, 100, 20);
        add(cancel);
        
        //Sign-up Button with image
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        JButton signup=new JButton("Sign-up", new ImageIcon(i6));
        signup.setBounds(380, 200, 100, 20);
        add(signup);
        
        //Image for this frame
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Login();
    }
}

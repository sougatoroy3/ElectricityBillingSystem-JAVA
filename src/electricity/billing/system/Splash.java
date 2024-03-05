package electricity.billing.system;

import javax.swing.*; //java extension for swing package
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        
        //Put an image on a frame using ImageIcon
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg")); 
        //Scaling the image using Image class
        Image i2=i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        //Using ImageIcon again as we can't pass Image class inside JLabel
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image); 
        
        setVisible(true);
        
        int x=1;
        for(int i=2; i<600; i+=4, x+=1){
            setSize(i+x, i);
            setLocation(700-((i+x)/2), 400-(i/2));
            
            try{
                Thread.sleep(5);
            }catch(Exception e){ 
                e.printStackTrace(); 
            }
        } 
        
        t=new Thread(this); //refernce of the current class using this
        t.start(); // internally calls the run() method
        
        setVisible(true);
    }
    
    public void run(){
        try{
            Thread.sleep(7000); //7 seconds
            setVisible(false);
            
            //Login Frame Here
            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Splash();
    }
}


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;




    class Myframe extends JFrame implements ActionListener  {
        Container c;
        JButton btn;



        Myframe(){

            c=this.getContentPane();
            c.setLayout(null);
                   try{
                       BufferedImage bufferedImage = ImageIO.read(new File("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg"));
                       Image image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                       ImageIcon icon = new ImageIcon(image);
                       JButton b2 = new JButton(icon);
                       b2.setSize(icon.getIconWidth(), icon.getIconHeight());
                       c.add(b2);
                       b2.addActionListener(this);
                   }
                   catch(IOException e){
                       System.out.println("exception");
                   }

        }

        public void actionPerformed(ActionEvent e) {
//            JLabel bg;
//            bg=new JLabel("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg");
//            bg.setBounds(0,0,1200,700);

            new newframe();


        }
        }
        class newframe  extends JFrame{
            Container c;
            JButton btn;
        newframe(){

            c=this.getContentPane();
            c.setLayout(null);

            c.setLayout(new FlowLayout());
            setTitle("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg");
            setSize(700,500);
            setLocation(200,200);



            ImageIcon icon = new ImageIcon("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg");
            JButton b2 = new JButton(icon);
            b2.setSize(icon.getIconWidth(), icon.getIconHeight());
            b2.setBorder(null);

            //JButton b2 = new JButton("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg");
            c.add(b2);
            JLabel l1 = new JLabel("details : ");
            c.add(l1);

            JTextField t1 = new JTextField(20);
            c.add(t1);

            JLabel l2 = new JLabel("location : ");
            c.add(l2);

            JTextField t2 = new JTextField(20);
            c.add(t2);
            setVisible(true);
        }



        }







    public class Main {
        public static void main(String[] args) throws IOException {
            Myframe f = new Myframe();
            f.setTitle("Action Demo");
            f.setSize(700, 500);
            f.setLocation(100, 100);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
//        f.setBounds(100,100,1000,500);
//        Container c = f.getContentPane();
//        c.setLayout(null);

//        f.setSize(800, 600);
//        f.setLayout(new FlowLayout());
//
//        JLabel l1 = new JLabel("UserName");
//        f.add(l1);
//
//        JTextField t1 = new JTextField(20);
//        f.add(t1);
//
//        JLabel l2 = new JLabel("Password: ");
//        f.add(l2);
//
//        JTextField t2 = new JTextField(20);
//        f.add(t2);
//
//        JButton b = new JButton("Submit");
//        b.setSize(1,500000000);

        //f.add(b);
//
//        BufferedImage bufferedImage = ImageIO.read(new File("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg"));
//        Image image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon icon = new ImageIcon(image);
//        JButton b2 = new JButton(icon);
//
//      b2.setSize(icon.getIconWidth(), icon.getIconHeight());
//        b2.setMargin(new Insets(10, 10, 10, 10));
//        //b2.setBorder(null);
//        //b2.setLocation(100,100);
//        c.add(b2);
//        f.setVisible(true);
//


    //}}

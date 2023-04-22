
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        JFrame f = new JFrame("User form : ");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100,100,1000,500);
        Container c = f.getContentPane();
        c.setLayout(null);

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

        f.add(b);
        BufferedImage bufferedImage = ImageIO.read(new File("C:/Users/Aaditya/IdeaProjects/MemoryGallery/orca.jpg"));
        Image image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        JButton b2 = new JButton(icon);

      b2.setSize(icon.getIconWidth(), icon.getIconHeight());
        b2.setMargin(new Insets(10, 10, 10, 10));
        //b2.setBorder(null);
        //b2.setLocation(100,100);
        c.add(b2);
        f.setVisible(true);

        

    }
}

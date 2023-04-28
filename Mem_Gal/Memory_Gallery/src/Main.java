import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import ImgInfo.*;


public class Main {
    public static void main(String[] args) {
        new Gallery();

        // To load data to galley from database
        new db().load();
    }
}

class Gallery{
    static Container cont = new Container();
    static JButton adb = new JButton("Add Memory");
    static JFrame frame = new JFrame();

    public Gallery(){
        cont.setLayout(new FlowLayout(0,10,10));
        cont.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout(10,10));

        adb.setFocusable(false);
        adb.setBounds(15,15,20,20);
        adb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                adb.setEnabled(false);

                // control goes to -> AddInfo.java
                new AddInfo();
            }
        } );

        JPanel botmp = new JPanel();
        botmp.setSize(10, 50);
        botmp.setBackground(Color.LIGHT_GRAY);
        botmp.add(adb);

        JScrollPane scrlpanl = new JScrollPane(cont, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrlpanl,BorderLayout.CENTER);
        frame.add(botmp,BorderLayout.SOUTH);
        frame.setTitle("Memory Gallery");
        frame.setLocation(475, 150);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ImgInfo.ImgInfo;


public class AddInfo {
    JFrame infoframe ;
    JTextField path,date,loc;
    JTextArea info;
    JLabel pl,dl,ll,inl;
    JPanel infop,botp2;
    JButton save,cancel,browse;//,imgb;
//    ImageIcon img;

    public AddInfo(){
        infoframe = new JFrame();
        infoframe.setLayout(new BorderLayout());
        path = new JTextField(25);
        pl = new JLabel("Image Path :",SwingConstants.RIGHT);
        pl.setFont(new Font("Arial", 0, 15));
        date = new JTextField( 10);
        dl = new JLabel("Date :",SwingConstants.RIGHT);
        dl.setFont(new Font("Arial", 0, 15));
        loc = new JTextField( 10);
        ll = new JLabel("Location :",SwingConstants.RIGHT);
        ll.setFont(new Font("Arial", 0, 15));
        info = new JTextArea(2, 20);
        info.setPreferredSize(new Dimension(0, 34));
        inl = new JLabel("Information :",SwingConstants.RIGHT);
        inl.setFont(new Font("Arial", 0, 15));

        browse = new JButton("Browse");
        browse.setFocusable(false);
        browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JFileChooser choose = new JFileChooser();
                choose.setFileSelectionMode(0);
                choose.setFileFilter(new FileNameExtensionFilter("Images", "jpg","png","jfif"));

                int returnVal = choose.showOpenDialog(browse);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    path.setText(choose.getSelectedFile().getAbsolutePath());
                }
//                img = new ImageIcon(path.getText());

            }

        });

        infop = new JPanel();
        infop.setLayout(new GridBagLayout());
        GridBagConstraints lay = new GridBagConstraints();
        infop.setBackground(Color.gray);
        lay.gridx=0;lay.gridy=0;lay.insets = new Insets(0, 0, 10, 10);
        infop.add(pl,lay);
        lay.gridx=1;lay.gridy=0;lay.fill = GridBagConstraints.HORIZONTAL;lay.gridwidth = 2;lay.weighty=0;
        lay.insets = new Insets(0, 0, 10, 10);
        infop.add(path,lay);
        lay.gridx=3;lay.gridy=0;lay.insets = new Insets(0, 0, 10, 10);
        infop.add(browse);
        lay.gridx=0;lay.gridy=1;//lay.fill = GridBagConstraints.HORIZONTAL;
        lay.insets = new Insets(0, 0, 10, 10);
        infop.add(dl,lay);
        lay.gridx=1;lay.gridy=1;lay.insets = new Insets(0, 0, 10, 10);
        infop.add(date,lay);
        lay.gridx=0;lay.gridy=2;//lay.fill = GridBagConstraints.HORIZONTAL;
        lay.insets = new Insets(0, 0, 10, 10);
        infop.add(ll,lay);
        lay.gridx=1;lay.gridy=2;lay.insets = new Insets(0, 0, 10, 10);
        infop.add(loc,lay);
        lay.gridx=0;lay.gridy=3;//lay.fill = GridBagConstraints.HORIZONTAL;
        lay.insets = new Insets(0, 0, 10, 10);
        infop.add(inl,lay);
        lay.gridx=1;lay.gridy=3;lay.fill = GridBagConstraints.HORIZONTAL;lay.gridheight = 2;
        lay.insets = new Insets(0, 0, 10, 10);
        infop.add(info,lay);

        save = new JButton("Save");
        save.setBackground(new Color(150,150,200));
        save.setFocusable(false);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(path.getText().isEmpty() || date.getText().isEmpty() || loc.getText().isEmpty() || info.getText().isEmpty()){
                    JOptionPane.showMessageDialog(botp2, "All fields are necessary !!", "Empty Fields !!", JOptionPane.ERROR_MESSAGE);
                }
                else{
//                    imgb = new JButton(img);
//                    Gallery.cont.add(imgb);

                    // CREATION OF IMGinfo object named newimg
                    ImgInfo newimg = new ImgInfo(path.getText(), date.getText(), loc.getText(), info.getText());

                    // All this data also stores to database
                    new db().insert(path.getText(), date.getText(), loc.getText(), info.getText());

                    Gallery.cont.add(newimg.imgb);
                    Gallery.frame.repaint();
                    JOptionPane.showMessageDialog(botp2, "Saved Sucessfully");
                    infoframe.dispose();
                    Gallery.adb.setEnabled(true);

                    // Calling ShowInfo
                    newimg.imgb.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae){
                            new ShowInfo(newimg);
                        }
                    });
                }
            }
        });

        cancel = new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setBackground(new Color(200,150,150));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                infoframe.dispose();
                Gallery.adb.setEnabled(true);
            }
        });

        botp2 = new JPanel(new FlowLayout());
        botp2.setSize(10, 40);
        botp2.setBackground(Color.LIGHT_GRAY);
        botp2.add(save);
        botp2.add(cancel);

        infoframe.add(infop,BorderLayout.CENTER);
        infoframe.add(botp2,BorderLayout.SOUTH);
        infoframe.setTitle("Add Memory");
        infoframe.setSize(600,300);
        infoframe.setResizable(false);
        infoframe.setLocation(200, 100);
        infoframe.setVisible(true);
    }

}

import ImgInfo.ImgInfo;
import javax.swing.*;
import java.awt.*;

public class ShowInfo {
    JFrame showframe = new JFrame();
    JTextField shdt, shlocn;
    JTextArea shinfo;
    JPanel showinfopnl;
    JLabel dtlbl, locnlbl, infolbl, imglbl;

    public ShowInfo(ImgInfo newimg) {
        SpringLayout layout = new SpringLayout();
        showframe.setLayout(layout);
        showframe.setTitle("Image Information :");
        imglbl = new JLabel(newimg.img);
        imglbl.setPreferredSize(new Dimension(400, 200));
        layout.putConstraint(SpringLayout.NORTH, imglbl, 20, SpringLayout.NORTH, showframe);
        layout.putConstraint(SpringLayout.WEST, imglbl, 19, SpringLayout.WEST, showframe);

        shdt = new JTextField(newimg.imgdt, 10);
        shdt.setFont(new Font("Roboto Condensed", Font.ITALIC, 15));
        shdt.setEditable(false);
        dtlbl = new JLabel("Date :", SwingConstants.RIGHT);
        dtlbl.setFont(new Font("Arial", 0, 17));
        shlocn = new JTextField(newimg.imgloc, 10);
        shlocn.setFont(new Font("Roboto Condensed", Font.BOLD, 15));
        shlocn.setEditable(false);
        locnlbl = new JLabel("Location :", SwingConstants.RIGHT);
        locnlbl.setFont(new Font("Arial", 0, 17));
        shinfo = new JTextArea(newimg.imginfo, 2, 20);
        shinfo.setFont(new Font("Roboto Condensed", Font.PLAIN, 17));
        shinfo.setEditable(false);
        shinfo.setPreferredSize(new Dimension(0, 34));
        infolbl = new JLabel("Information :", SwingConstants.RIGHT);
        infolbl.setFont(new Font("Arial", 0, 17));

        showinfopnl = new JPanel(new GridBagLayout());
        showinfopnl.setPreferredSize(new Dimension(400, 150));
        GridBagConstraints lay = new GridBagConstraints();
        showinfopnl.setBackground(Color.gray);
        lay.gridx = 0;
        lay.gridy = 0;
        lay.insets = new Insets(0, 0, 10, 10);
        showinfopnl.add(dtlbl, lay);
        lay.gridx = 1;
        lay.gridy = 0;
        lay.fill = GridBagConstraints.HORIZONTAL;
        lay.gridwidth = 1;
        lay.weighty = 0;
        lay.insets = new Insets(0, 0, 10, 10);
        showinfopnl.add(shdt, lay);
        lay.gridx = 0;
        lay.gridy = 1;// lay.fill = GridBagConstraints.HORIZONTAL;
        lay.insets = new Insets(0, 0, 10, 10);
        showinfopnl.add(locnlbl, lay);
        lay.gridx = 1;
        lay.gridy = 1;
        lay.insets = new Insets(0, 0, 10, 10);
        showinfopnl.add(shlocn, lay);
        lay.gridx = 0;
        lay.gridy = 2;// lay.fill = GridBagConstraints.HORIZONTAL;
        lay.insets = new Insets(0, 0, 10, 10);
        showinfopnl.add(infolbl, lay);
        lay.gridx = 1;
        lay.gridy = 2;
        lay.insets = new Insets(0, 0, 10, 10);
        lay.fill = GridBagConstraints.HORIZONTAL;
        lay.gridheight = 2;
        showinfopnl.add(shinfo, lay);

        showframe.add(imglbl);
        layout.putConstraint(SpringLayout.NORTH, showinfopnl, 15, SpringLayout.SOUTH, imglbl);
        layout.putConstraint(SpringLayout.WEST, showinfopnl, 20, SpringLayout.WEST, showframe);
        showframe.add(showinfopnl);
        showframe.setSize(455, 460);
        showframe.setLocation(505, 180);
        showframe.setResizable(false);
        showframe.setVisible(true);

    }
}

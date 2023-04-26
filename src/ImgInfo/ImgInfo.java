package ImgInfo;

import javax.swing.*;
import java.awt.*;

public class ImgInfo {

    public JButton imgb;
    public ImageIcon img;
    public String imgpath;
    public String imgdt, imgloc, imginfo;
    public ImgInfo(String pth,String dt,String locn,String infom){
        this.imgpath = pth;
        this.imgdt = dt;
        this.imgloc = locn;
        this.imginfo = infom;
        img = new ImageIcon(pth);
        imgb = new JButton(img);
        imgb.setBorder(null);
        imgb.setPreferredSize(new Dimension(100,100));
    }
}

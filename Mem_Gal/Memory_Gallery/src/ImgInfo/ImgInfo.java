// Changes as per database

package ImgInfo;

import javax.swing.*;
import java.awt.*;


public class ImgInfo {

    public String insert_query = "";



    public JButton imgb;
    public ImageIcon img;
    public String imgpath;
    public String imgdt, imgloc, imginfo;
    
    public ImgInfo(String pth,String dt,String locn,String infom){
        this.imgpath = pth;
        this.imgdt = dt;
        this.imgloc = locn;
        this.imginfo = infom;

        // adding image path
        img = new ImageIcon(pth);

        // adding photo
        imgb = new JButton(img);
        
        imgb.setBorder(null);

        // Aditya hopefully edit's here
        imgb.setPreferredSize(new Dimension(100,100));


    }
}

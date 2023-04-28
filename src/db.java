import ImgInfo.ImgInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class db {

    public void load() {
        String url = "jdbc:mysql://localhost:3306/dbms"; // URL with your MySQL database connection details
        String username = "ssa";
        String password = "projmem";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from memgal");

            // While we do not reach till end of database
            while (resultSet.next()) {

                // Retrieval of each tuple's data
                String path = resultSet.getString(1);
                String dday = resultSet.getString(2);
                String location = resultSet.getString(3);
                String information = resultSet.getString(4);

//                System.out.println(path); // let's see if this go right

                // Creation of object(images) the by calling constructor , creation of images
                ImgInfo obj = new ImgInfo(path, dday, location, information);
                Gallery.cont.add(obj.imgb);
                Gallery.frame.repaint();
                obj.imgb.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae){
                        new ShowInfo(obj);
                    }
                });

            }

            System.out.println("All images are loaded!!");
            connection.close();
        } catch (Exception e) {
            System.out.println("There is error : " + e);
        }
    }

    public void insert(String i_path , String i_dday , String i_location , String i_information){
        System.out.println(i_path + " " + i_dday + " " + i_location + " " + " " + i_information);

        String url = "jdbc:mysql://localhost:3306/dbms"; // URL with your MySQL database connection details
        String username = "ssa";
        String password = "projmem";

        String insert_query = "INSERT INTO memgal (path, dday, location, information) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement(insert_query);

            // set the values for the prepared statement
            pstmt.setString(1, i_path);
            pstmt.setString(2, i_dday);
            pstmt.setString(3, i_location);
            pstmt.setString(4, i_information);

            // execute the prepared statement
            pstmt.executeUpdate();

            System.out.println("Image inserted successful!!");

        } catch (SQLException e) {
            System.out.println("Insertion failed. Error message: " + e.getMessage());
        }
    }

}

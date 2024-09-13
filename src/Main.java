import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
      //Specifies the connection address (URL) of the database you want to connect to using JDBC (Java Database Connectivity).
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "";

         try {
            //It is used to load and prepare the MySQL database driver in memory
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create Connection with MySql from Class Connect he can commection with DriverManger
             Connection connection = DriverManager.getConnection(url, user, password);

             //It is used to create a Statement object that can be used to execute SQL queries against the database being connected to. To you
             Statement statement = connection.createStatement();

             //Used to execute a SQL query
             ResultSet resultSet = statement.executeQuery("select * from student");

             while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                 String name = resultSet.getString("name");
                 int age = resultSet.getInt("age");
                 System.out.println("ID: " + id + "\tName: " + name + "\tAge: " + age);

             }
             // to colse connection after execute your query
             connection.close();


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
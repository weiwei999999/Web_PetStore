package src.persistence;

import java.sql.*;

public class DBUtil {
    /*
        把URL、USER、PASSWORD分别更改成自己的数据库配置
     */
    public static final String URL = "jdbc:mysql://localhost:3306/mypetstore";
    public static final String USER = "root";
    public static final String PASSWORD = "13355003937Wu";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void closeStatement(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


//    public static void closePreparedStatement(PreparedStatement preparedStatement) {
//        try {
//            preparedStatement.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }




    //public static void main(String[] args) {
        //Connection connection = getConnection();
       // System.out.println(connection);
        //closeConnection(connection);
    //}
}

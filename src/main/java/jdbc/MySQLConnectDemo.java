package jdbc;

import com.alibaba.fastjson.JSON;

import java.sql.*;

/**
 * mysql连接demo
 * @author yinyg
 * @date 2021/12/9
 */
public class MySQLConnectDemo {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = System.getenv("MYSQL_USER_NAME");
    private static final String PASSWORD = System.getenv("MYSQL_USER_PWD");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            String sql = "select id, username, level from t_user where id = 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("{\"id\":" + resultSet.getLong("id")
                        + ",\"username\":" + resultSet.getString("username")
                        + ",\"level\":" + resultSet.getInt("level") + "}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}

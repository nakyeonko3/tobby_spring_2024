package org.user.dao;

import org.user.entity.User;

import java.sql.*;

public class UserDao {

    public void add(User user)throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook",
                "spring", "book");
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassWord());

        ps.executeUpdate();

        ps.close();
        c.close();
        }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook",
                "spring", "book");
        PreparedStatement ps = c.prepareStatement("select * from users where id =?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = User.builder()
                .id(rs.getNString("id"))
                .passWord(rs.getString("password"))
                .name(rs.getString("name"))
                .build();

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}

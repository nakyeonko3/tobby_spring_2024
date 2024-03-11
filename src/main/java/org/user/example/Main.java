package org.user.example;

import org.user.dao.UserDao;
import org.user.entity.User;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao dao = new UserDao();


        User user = User.builder().id("whiteship").name("백기선").passWord("married")
                .build();
        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());

        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassWord());

        System.out.println(user2.getId() + " 조회성공");
    }

}
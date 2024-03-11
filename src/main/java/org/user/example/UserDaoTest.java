package org.user.example;

import org.user.dao.DaoFactory;
import org.user.dao.UserDao;
import org.user.entity.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao userDao = new DaoFactory().userDao();

        User user = new User("whiteship", "백기선", "spring");
        userDao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = userDao.get(user.getId());

        System.out.println(user2.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassWord());

        System.out.println(user2.getId() + " 조회성공");
    }

}
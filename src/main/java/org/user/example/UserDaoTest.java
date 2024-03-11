package org.user.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.user.dao.DaoFactory;
import org.user.dao.UserDao;
import org.user.entity.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


//        //AnnotationConfigApplicationContext가 @Configuration이 붙은 코드를 설정 정보로 등록한다
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        //getBean은 빈으로 등록된 userDao를 호출한다. UserDao의 객체를 가져오는셈
        UserDao userDao = context.getBean("userDao", UserDao.class);

//        UserDao userDao = new DaoFactory().userDao();

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
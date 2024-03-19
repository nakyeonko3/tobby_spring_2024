package org.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.user.dao.UserDao;
import org.user.entity.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {


        //AnnotationConfigApplicationContext가 @Configuration이 붙은 코드를 설정 정보로 등록한다
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        //getBean은 빈으로 등록된 userDao를 호출한다. UserDao의 객체를 가져오는셈
        UserDao userDao = context.getBean("userDao", UserDao.class);
        User user = new User("whiteship", "백기선", "spring");
        userDao.add(user);

        User user2 = userDao.get(user.getId());

        System.out.println(user2.getId());
        System.out.println(user2.getName());

    }

}
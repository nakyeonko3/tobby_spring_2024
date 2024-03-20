package org.user.dao;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.user.entity.User;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class UserDaoTest {

    @Test
    public void addAndGet() throws SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        //getBean은 빈으로 등록된 userDao를 호출한다. UserDao의 객체를 가져오는셈
        UserDao userDao = context.getBean("userDao", UserDao.class);



        User user1 = new User(".gyumee", "박상철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        User user3 = new User("bumjin", "박범진", "springno3");

        userDao.deletAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        userDao.add(user3);
        assertThat(userDao.getCount(), is(3));

    }

}
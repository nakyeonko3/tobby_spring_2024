package org.user.dao;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.user.entity.User;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserDao userDao;



    private User user1;
    private User user2;
    private User user3;


    @Before
    public void setUp() {
        this.userDao = context.getBean("userDao", UserDao.class);
        this.user1 = new User(".gyumee", "박상철", "springno1");
        this.user2 = new User("leegw700", "이길원", "springno2");
        this.user3 = new User("bumjin", "박범진", "springno3");
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFail() throws SQLException {
        userDao.deletAll();
        assertThat(userDao.getCount(), is(0));
        userDao.get("unknown_id");
    }


    @Test
    public void addAndGet() throws SQLException {

        userDao.deletAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        User userget1 = userDao.get(user1.getId());
        assertThat(userget1.getName(), is(user1.getName()));
        assertThat(userget1.getPassWord(), is(user1.getPassWord()));

        User userget2 = userDao.get(user2.getId());
        assertThat(userget2.getName(), is(user2.getName()));
        assertThat(userget2.getPassWord(), is(user2.getPassWord()));
    }

}
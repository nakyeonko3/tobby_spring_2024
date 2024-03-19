package org.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// @Configuration는 빈 펙토리를 위한 오브젝트 설정을 담당하는 클래스임을 알려줌
@Configuration
public class DaoFactory {

//  오브젝트를 만들어주는 메소드에 @Bean을 붙여준다.
    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        CountingConnectionMaker countingConnectionMaker = new CountingConnectionMaker();
        countingConnectionMaker.setRealConnectionMaker(realConnectionMaker());
        return countingConnectionMaker;
    }
    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }

}

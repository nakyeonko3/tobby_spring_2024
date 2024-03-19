package org.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;


// @Configuration는 빈 펙토리를 위한 오브젝트 설정을 담당하는 클래스임을 알려줌
@Configuration
public class DaoFactory {

//  오브젝트를 만들어주는 메소드에 @Bean을 붙여준다.
    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/springbook");
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUsername("spring");
        dataSource.setPassword("book");
        return dataSource;
    }
}

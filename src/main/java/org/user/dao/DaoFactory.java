package org.user.dao;

import org.user.connection.ConnectionMaker;
import org.user.connection.DConnectionMaker;

public class DaoFactory {
    public UserDao userDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return new UserDao(connectionMaker);
    }
}

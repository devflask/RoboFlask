package com.devflask.roboflask.database.dao.factory;

import com.devflask.roboflask.database.dao.DAO;
import com.devflask.roboflask.database.dao.postgresql.UsersPostgreSQLDAO;
import com.devflask.roboflask.database.pojo.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UsersDAOFactory {

    public static DAO<User> getUsersDAO(Datasource source) throws NotImplementedException{
        if (source == Datasource.POSTGRESQL) {
            return new UsersPostgreSQLDAO();
        } else {
            throw new NotImplementedException();
        }
    }
}

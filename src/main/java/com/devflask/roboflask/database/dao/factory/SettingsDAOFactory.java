package com.devflask.roboflask.database.dao.factory;

import com.devflask.roboflask.database.dao.DAO;
import com.devflask.roboflask.database.dao.postgresql.SettingsPostgreSQLDAO;
import com.devflask.roboflask.database.pojo.Setting;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

public class SettingsDAOFactory {

    public static DAO<Setting> getSettingsDAO(Datasource source) throws NotImplementedException{
        if (source == Datasource.POSTGRESQL) {
            return new SettingsPostgreSQLDAO();
        } else {
            throw new NotImplementedException();
        }
    }
}

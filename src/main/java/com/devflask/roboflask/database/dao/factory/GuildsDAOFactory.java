package com.devflask.roboflask.database.dao.factory;

import com.devflask.roboflask.database.dao.DAO;
import com.devflask.roboflask.database.dao.postgresql.GuildsPostgreSQLDAO;
import com.devflask.roboflask.database.pojo.Guild;
import org.jetbrains.annotations.Nullable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.SQLException;

public class GuildsDAOFactory {

    @Nullable
    public static DAO<Guild> getGuildsDAO(Datasource source) throws NotImplementedException{
        if (source == Datasource.POSTGRESQL) {
            try {
                return new GuildsPostgreSQLDAO();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } else {
            throw new NotImplementedException();
        }
        return null;
    }
}

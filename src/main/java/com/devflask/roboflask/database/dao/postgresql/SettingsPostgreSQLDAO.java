package com.devflask.roboflask.database.dao.postgresql;

import com.devflask.roboflask.database.PostgreSQLDatasource;
import com.devflask.roboflask.database.dao.DAO;
import com.devflask.roboflask.database.pojo.Guild;
import com.devflask.roboflask.database.pojo.Setting;
import jdk.internal.jline.internal.Nullable;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class SettingsPostgreSQLDAO implements DAO<Setting> {

    @Nullable
    private ResultSet execute(String statement){
        ResultSet resultSet = null;
        try (Connection con = PostgreSQLDatasource.getConnection()){
            PreparedStatement prep = con.prepareStatement(statement);
            resultSet = prep.executeQuery();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public Optional<Setting> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Setting> getAll() {
        ResultSet result = execute("SELECT * FROM roboflask.guilds");
        Collection<Setting> settings = new HashSet<>();
        try{
            while (result.next()){
                Setting setting = new Setting();
                setting.setId(result.getInt(1));
                setting.setPrefix(result.getString(2));
                setting.setLogChannel(result.getLong(3));
                settings.add(setting);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return settings;
    }

    @Override
    public void save(Setting setting) {
        update(setting);
        //you saw nothing :)
    }

    @Override
    public void update(Setting setting) {
        String SQL = "INSERT INTO roboflask.settings(id, prefix, log_channel) " +
                "VALUES (?,?,?)" +
                "ON CONFLICT (id) DO UPDATE " +
                "SET prefix = ?," +
                "log_channel = ?;";


        try (Connection conn = PostgreSQLDatasource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setLong(1, setting.getId());
            pstmt.setString(2, setting.getPrefix());
            pstmt.setLong(3, setting.getLogChannel());
            pstmt.setString(4, setting.getPrefix());
            pstmt.setLong(5, setting.getLogChannel());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Setting setting) {
        try(Connection connection = PostgreSQLDatasource.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM roboflask.guilds where id = ?")){
            statement.setLong(1,setting.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO: Postgres propelry pls.
}

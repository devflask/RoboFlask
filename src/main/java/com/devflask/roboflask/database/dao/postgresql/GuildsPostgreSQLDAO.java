package com.devflask.roboflask.database.dao.postgresql;

import com.devflask.roboflask.database.PostgreSQLDatasource;
import com.devflask.roboflask.database.dao.DAO;
import com.devflask.roboflask.database.pojo.Guild;
import jdk.internal.jline.internal.Nullable;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class GuildsPostgreSQLDAO implements DAO<Guild> {

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
    public Optional<Guild> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Guild> getAll() {
        ResultSet result = execute("SELECT * FROM Guilds");
        Collection<Guild> guilds = new HashSet<>();
        try{
            while (result.next()){
                Guild g = new Guild();
                g.setId(result.getInt(1));
                g.setName(result.getString(2));
                g.setJoined(result.getDate(3));
                g.setOwnerId(result.getInt(4));
                guilds.add(g);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return guilds;
    }

    @Override
    public void save(Guild guild) {

    }

    @Override
    public void update(Guild guild) {
        String SQL = "UPDATE Guilds "
                + "SET id = ? "
                + "SET name = ? "
                + "SET joined = ?"
                + "SET owner_id = ?"
                + "WHERE id = ?";

        try (Connection conn = PostgreSQLDatasource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setLong(1, guild.getId());
            pstmt.setString(2, guild.getName());
            pstmt.setDate(3, guild.getJoined());
            pstmt.setLong(4, guild.getOwnerId());
            pstmt.setLong(5, guild.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Guild guild) {
        try(Connection connection = PostgreSQLDatasource.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Guilds WHERE id = ?");
            statement.setLong(1,guild.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO: Postgres propelry pls.
}

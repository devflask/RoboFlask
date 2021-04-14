package com.devflask.roboflask.database.dao.postgresql;

import com.devflask.roboflask.database.dao.DAO;
import com.devflask.roboflask.database.pojo.User;

import java.util.Collection;
import java.util.Optional;

public class UsersPostgreSQLDAO implements DAO<User> {

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

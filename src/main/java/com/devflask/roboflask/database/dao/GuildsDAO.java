package com.devflask.roboflask.database.dao;

import com.devflask.roboflask.database.pojo.Guild;

import java.util.Collection;
import java.util.Optional;

public class GuildsDAO implements DAO<Guild> {

    @Override
    public Optional<Guild> get(long id) {
        return Optional.empty();
    }

    @Override
    public Collection<Guild> getAll() {
        return null;
    }

    @Override
    public void save(Guild guild) {

    }

    @Override
    public void update(Guild guild, String[] params) {

    }

    @Override
    public void delete(Guild guild) {

    }
}

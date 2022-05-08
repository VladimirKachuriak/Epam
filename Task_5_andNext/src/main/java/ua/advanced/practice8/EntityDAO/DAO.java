package ua.advanced.practice8.EntityDAO;

import java.util.List;

public interface DAO<Entity, Key> {
    List<Entity> findAll();
    void create(Entity model);
    Entity read(Key key);
    void update(Entity model);
    void delete(Entity model);
}

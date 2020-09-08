package by.tms.dao;

import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void create(User user);
    User getById(long id);
    Optional<User> getByLogin(String login);
    List<User> getAll();
    void updateById(User user);
    void deleteById(long id);
    boolean containsById(long id);
    boolean containsByLogin(String login);
}

package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> get();

    public User create(User user);

    public void update(User user);

    public void delete(int id);
}

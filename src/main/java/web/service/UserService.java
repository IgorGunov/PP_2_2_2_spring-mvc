package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();
    public User get(int id);

    public void create(User user);

    public void update(User user);

    public void delete(int id);
}

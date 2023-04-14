package web.service;

import web.model.User;

import java.util.List;

public interface Service {

    public List<User> get();

    public void create(User user);

    public void update(User user);

    public void delete(int id);
}

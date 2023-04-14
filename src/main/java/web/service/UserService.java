package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
public class UserService implements web.service.Service {

    private UserDaoImp dao;

    @Autowired
    public void setDao(UserDaoImp dao) {
        this.dao = dao;
    }


    @Override
    public List<User> get() {
        return dao.get();
    }

    @Override
    public void create(User user) {
        dao.create(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}

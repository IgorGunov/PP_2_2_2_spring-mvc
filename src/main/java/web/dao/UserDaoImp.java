package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao{

    private static int ID=0;
    private static List<User> list = new ArrayList<>();
    @Override
    public List<User> get() {
        return list;
    }

    @Override
    public void create(User user) {
        user.setId(ID++);
        list.add(user);
        System.out.println("DAO: "+list.get(user.getId()));
    }

    @Override
    public void update(User user) {
        list.remove(user.getId());
        list.add(user);
    }

    @Override
    public void delete(int id) {
        list.remove(id);
    }
}

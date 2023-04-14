package web.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import web.config.AppConfig;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private static int ID = 0;
    private static List<User> list = new ArrayList<>();

//    private EntityManager entityManager;
//
//    @Autowired
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @PersistenceContext
    private EntityManager entityManager;

//    public UserDaoImp() {
//        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
//        entityManager = context.getBean(EntityManager.class);
//    }

    @Override
    public List<User> get() {
        return list;
    }

    @Override
    @Transactional
    public User create(User user) {
        System.out.println("1111111111111111");
        entityManager.getTransaction().begin();
        System.out.println("22222222222222222222");
        entityManager.persist(user);
        System.out.println("333333333333333333333");
        entityManager.getTransaction().commit();
        System.out.println("444444444444444444");
        return user;
    }

    @Override
    public void update(User user) {
        list.remove(user.getId());
        list.add(user);
    }

    @Override
    public void delete(int id) {
        User user = new User();
        entityManager.remove(user);
        list.remove(id);
    }
}


import org.hibernate.SessionFactory;

public class HibernateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       /* User user = new User("Test");
        sessionFactory.openSession().save(user);*/
        HibernateUtil.showdown();
    }
}


package hibenitet;

import com.zihua.thibernate.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.transaction.jta.platform.internal.TransactionManagerAccess;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zihua on 16-12-23.
 */
public class Testhi {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init(){

        Configuration config=new Configuration().configure();
        sessionFactory=config.buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();

    }

    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void test() {
        Employee a=new Employee("zihua","10");
        session.save(a);
    }
}


import entity.Product;
import entity.ProductCategory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Product> products = null;

        try {
            session.beginTransaction();
            // products = session.createQuery("FROM Product ").list();
            products = session.createQuery("from Product as p inner join fetch p.productCategory as pc").list();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            HibernateUtil.showdown();
        }
        assert products != null;
        for (Product product : products) {
            System.out.println(product);

        }

      /*  HQLQuery

        From Product;
        From Product p;
        From Product as p;
        From product, ProductCategory;
        From product as p, ProductCategory as ps;


        THIS IS SQL
        SELECT*FROM PRODUCT p INNER JOIN PRODUCT_CATEGORY PC on p.PRODUCT_CATEGORY_ID = PC.ID;

        THIS IS HQL
        from Product as p inner join fetch p.productCategory as pc

        */


    }
}

//============================= SQLQuery =================================================================================
/* List<Object []> objectList=null;*/

/*  SQLQuery query = session.createSQLQuery("SELECT *from PRODUCT");
            query.addEntity(Product.class);*/
           /* SQLQuery query = session.createSQLQuery("SELECT (p.*),(pc.*) from PRODUCT p INNER JOIN PRODUCT_CATEGORY PC on p.PRODUCT_CATEGORY_ID = PC.ID");
            query.addEntity("p",Product.class);
            query.addJoin("pc","p.productCategory");
            objectList = query.list();*/

   /* for (Object []obj:objectList) {
            System.out.println(obj[0] + ((ProductCategory) obj[1]).getTitle());
        }*/

      /*  for (Iterator iterator = objectList.iterator(); iterator.hasNext(); ) {
            Product product = (Product) iterator.next();
            System.out.println(product.toString()+product.toString().);

        }*/

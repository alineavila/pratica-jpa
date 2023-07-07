package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private final static EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("loja");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}

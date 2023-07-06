package testes;

import modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("xiaomi");
        celular.setDescricao("Muito Legal");
        celular.setPreco(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        // isso pq o nosso transactiontype está como RESOURCE-LOCAL e dai nos abrimos e fechamos a transação manualmente
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}

package testes;

import modelo.Categoria;
import modelo.CategoriaDao;
import modelo.Produto;
import modelo.ProdutoDao;
import util.JPAUtil;

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
        Categoria celulares = new Categoria("CELULARES");
        celular.setCategoria(celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        // isso pq o nosso transactiontype está como RESOURCE-LOCAL e dai nos abrimos e fechamos a transação manualmente
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}

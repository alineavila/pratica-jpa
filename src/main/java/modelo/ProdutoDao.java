package modelo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {


    private EntityManager em;


    public ProdutoDao() {
    }

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id){
        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos (){
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
    public BigDecimal buscarPrecoPorNome (String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";

        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> buscarPorNomeDaCategoria (String categoria){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :categoria";

        return em.createQuery(jpql, Produto.class)
                .setParameter("categoria", categoria)
                .getResultList();
    }

}

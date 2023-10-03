package org.kaly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.kaly.domain.Marca;

public class MarcaDao implements IMarcaDao {
    @Override
    public Marca cadastrar(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return marca;
    }

    @Override
    public List<Marca> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Marca> query =
                entityManager.createQuery("SELECT m FROM Marca m", Marca.class);

        List<Marca> list = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }

    @Override
    public void excluir(Marca marca) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        marca = entityManager.merge(marca);
        entityManager.remove(marca);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}

package org.kaly.dao;

import org.kaly.domain.Acessorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AcessorioDao implements IAcessorioDao {
    @Override
    public Acessorio cadastrar(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return acessorio;
    }

    @Override
    public void excluir(Acessorio acessorio) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        acessorio = entityManager.merge(acessorio);
        entityManager.remove(acessorio);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<Acessorio> buscarTodos() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Acessorio> query =
                entityManager.createQuery("SELECT a FROM Acessorio a", Acessorio.class);

        List<Acessorio> list = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}

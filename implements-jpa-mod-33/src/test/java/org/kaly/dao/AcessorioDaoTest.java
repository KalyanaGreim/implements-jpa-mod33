package org.kaly.dao;

import org.junit.Test;
import org.kaly.domain.Acessorio;

import static org.junit.Assert.assertNotNull;

public class AcessorioDaoTest {

    private IAcessorioDao acessorioDao;

    public AcessorioDaoTest() {
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("45DWSDW");
        acessorio.setDescricao("MODELO A");
        acessorio.setNome("FAROL");
        acessorio = acessorioDao.cadastrar(acessorio);

        assertNotNull(acessorio);
        assertNotNull(acessorio.getId());
    }

}
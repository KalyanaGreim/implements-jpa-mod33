package org.kaly.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.kaly.domain.Carro;
import org.kaly.domain.Marca;

public class MarcaTest {
    private IMarcaDao marcaDao;
    private ICarroDao carroDao;

    public MarcaTest() {
        marcaDao = new MarcaDao();
        carroDao = new CarroDao();
    }

    @Test
    public void cadastrar() {
        Carro carro = criarCarro("JJ");
        Marca marca = new Marca();
        marca.setNome("VOLKS");
        marca.setCarro(carro);
        marca = marcaDao.cadastrar(marca);

        assertNotNull(marca);
        assertNotNull(marca.getId());
    }

    private Carro criarCarro(String codigo) {
        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setDescricao("ROSA, 1968");
        carro.setNome("FUSCA");
        return carroDao.cadastrar(carro);
    }

}
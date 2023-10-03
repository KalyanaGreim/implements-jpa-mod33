package org.kaly.dao;

import org.junit.Test;
import org.kaly.domain.Acessorio;
import org.kaly.domain.Carro;
import org.kaly.domain.Marca;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class CarroDaoTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;

    private IAcessorioDao acessorioDao;

    public CarroDaoTest() {
        carroDao = new CarroDao();
        marcaDao = new MarcaDao();
        acessorioDao = new AcessorioDao();
    }

    @Test
    public void cadastrar() {
        Marca marca = new Marca();
        marca.setNome("Chevrolet");

        marca = marcaDao.cadastrar(marca);

        Carro carro = new Carro();
        carro.setCodigo("VW");
        carro.setDescricao("PRETO, 1958");
        carro.setNome("FUSCA");

        carro.setMarca(marca);

        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }

    @Test
    public void cadastrarCarroComMarcaEAcessorio() {
        Marca marca = new Marca();
        marca.setNome("Chevrolet");

        marca = marcaDao.cadastrar(marca);

        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("SM");
        acessorio.setNome("Airbag");
        acessorio.setDescricao("Airbag de segurança");

        acessorio = acessorioDao.cadastrar(acessorio);

        Carro carro = new Carro();
        carro.setCodigo("LL");
        carro.setDescricao("PRETO, 1958");
        carro.setNome("FUSCA");

        carro.setMarca(marca);

        List<Acessorio> acessorios = new ArrayList<>();
        acessorios.add(acessorio);
        carro.setAcessorios(acessorios);

        carro = carroDao.cadastrar(carro);

        assertNotNull(carro);
        assertNotNull(carro.getId());
    }


}
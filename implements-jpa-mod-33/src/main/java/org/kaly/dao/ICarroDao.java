package org.kaly.dao;

import org.kaly.domain.Carro;

import java.util.List;

public interface ICarroDao {

    public Carro cadastrar(Carro carro);

    public void excluir(Carro cur);

    public List<Carro> buscarTodos();
}

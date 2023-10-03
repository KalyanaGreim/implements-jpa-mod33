package org.kaly.dao;

import org.kaly.domain.Acessorio;

import java.util.List;

public interface IAcessorioDao {
    public Acessorio cadastrar(Acessorio acessorio);

    public void excluir(Acessorio acessorio);

    public List<Acessorio> buscarTodos();
}

package org.kaly.dao;

import org.kaly.domain.Carro;
import org.kaly.domain.Marca;

import java.util.List;

public interface IMarcaDao {
    Marca cadastrar(Marca mat);

    List<Marca> buscarTodos();

    void excluir(Marca marca);
}


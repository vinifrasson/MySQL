package com.sistema.Controller;

import com.sistema.DAO.IdProdutoDAO;

public class IdProdutoController {

    IdProdutoDAO idProdutoDAO = new IdProdutoDAO();

    public long determinarId(){

        return (long) idProdutoDAO.usuarioID();
    }
}

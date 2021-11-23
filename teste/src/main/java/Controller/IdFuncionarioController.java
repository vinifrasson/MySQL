package com.sistema.Controller;

import com.sistema.DAO.IdFuncionarioDAO;

public class IdFuncionarioController {
    IdFuncionarioDAO idFuncionarioDAO = new IdFuncionarioDAO();

    public long determinarId(){

        return (long) idFuncionarioDAO.usuarioID();
    }
}

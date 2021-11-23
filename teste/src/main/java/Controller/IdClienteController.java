package com.sistema.Controller;

import com.sistema.DAO.IdClienteDAO;

public class IdClienteController {

    IdClienteDAO idClienteDAO = new IdClienteDAO();

    public long determinarId(){
        return  (long) idClienteDAO.usuarioID();
    }

}

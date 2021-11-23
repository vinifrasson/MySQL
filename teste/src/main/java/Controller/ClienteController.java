package com.sistema.Controller;

import com.sistema.DAO.ClienteDAO;
import com.sistema.Model.Cliente;


import java.util.List;

public class ClienteController {
    ClienteDAO clienteDAO = new ClienteDAO();

    public void carregarClientes() {
        clienteDAO.carregarClientes();
    }

    public void adicionarClientes(Cliente cliente) {
        clienteDAO.adicionarClientes(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    public void editarCliente(int i, String conteudo, int opcao){
        clienteDAO.editarCliente(i,conteudo,opcao);
    }

    public void removerCliente(int i) {
        clienteDAO.removerCliente(i);
    }
}

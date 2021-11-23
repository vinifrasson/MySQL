package com.sistema.Controller;

import com.sistema.DAO.FornecedorDAO;
import com.sistema.Model.Fornecedor;

import java.util.List;

public class FornecedorController {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public void carregarFornecedores(){
        fornecedorDAO.carregarFornecedores();
    }
    public void adicionarFornecedores(Fornecedor fornecedor){
        fornecedorDAO.adicionarFornecedores(fornecedor);
    }
    public List<Fornecedor> listarFornecedores(){
        return fornecedorDAO.listarFornecedores();
    }
    public void editarFornecedor(int i, String conteudo, int opcao){
        fornecedorDAO.editarFornecedor(i,conteudo,opcao);
    }
    public void removerFornecedor(int i){
        fornecedorDAO.removerFornecedor(i);
    }

}

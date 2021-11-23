package com.sistema.Controller;

import com.sistema.DAO.FuncionarioDAO;
import com.sistema.Model.Funcionario;

import java.util.List;

public class FuncionarioController {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void adicionarFuncionario(Funcionario funcionario){
        funcionarioDAO.adicionarFuncionarios(funcionario);
    }
    public void carregarFuncionarios(){
        funcionarioDAO.carregarFuncionarios();
    }
    public List<Funcionario> listarFuncionarios(){
        return funcionarioDAO.listarFuncionarios();
    }
    public void editarFuncionario(int i, String conteudo, int opcao){
        funcionarioDAO.editarFuncionario(i,conteudo,opcao);
    }
    public void removerFuncionario(int i){
        funcionarioDAO.removerFuncionario(i);
    }
}

package com.sistema.DAO;

import com.sistema.Model.Cliente;
import com.sistema.Model.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO {

    static List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionarios(Funcionario funcionario){
        funcionarios.add(funcionario);
        this.salvarFuncionarios();
    }

    public void salvarFuncionarios(){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Funcionarios.txt"));
            for (int i = 0; i < funcionarios.size(); i++){
                bufferedWriter.write(funcionarios.get(i).getIdFuncionario() + "|" + funcionarios.get(i).getNomeFuncionario() +
                        "|" + funcionarios.get(i).getNumIdentidadeFuncionario() + "|" + funcionarios.get(i).getTelefoneFuncionario() +
                        "|" + funcionarios.get(i).getSalarioFuncionario());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void carregarFuncionarios(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Funcionarios.txt"));
            while (true){
                String linha = bufferedReader.readLine();
                if (linha == null){
                    break;
                }else{
                    StringTokenizer stringTokenizer = new StringTokenizer(linha,"|");
                    Funcionario funcionario = new Funcionario();
                    funcionario.setIdFuncionario(Long.parseLong(stringTokenizer.nextToken()));
                    funcionario.setNomeFuncionario(stringTokenizer.nextToken());
                    funcionario.setNumIdentidadeFuncionario(Long.parseLong(stringTokenizer.nextToken()));
                    funcionario.setTelefoneFuncionario(Long.parseLong(stringTokenizer.nextToken()));
                    funcionario.setSalarioFuncionario(Double.parseDouble(stringTokenizer.nextToken()));
                    funcionarios.add(funcionario);
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println("Erro em ler arquivo dos Funcionarios.");
        }
    }

    public void editarFuncionario(int i, String conteudo, int opcao){
        switch (opcao){
            case 1:
                funcionarios.get(i).setNomeFuncionario(conteudo);
                this.salvarFuncionarios();
                break;
            case 2:
                funcionarios.get(i).setNumIdentidadeFuncionario(Long.parseLong(conteudo));
                this.salvarFuncionarios();
                break;
            case 3:
                funcionarios.get(i).setTelefoneFuncionario(Long.parseLong(conteudo));
                this.salvarFuncionarios();
                break;
            case 4:
                funcionarios.get(i).setSalarioFuncionario(Double.valueOf(conteudo));
                this.salvarFuncionarios();
                break;
        }
    }

    public void removerFuncionario(int i){
        funcionarios.remove(i);
        this.salvarFuncionarios();
    }

    public List<Funcionario> listarFuncionarios(){
        return funcionarios;
    }

}

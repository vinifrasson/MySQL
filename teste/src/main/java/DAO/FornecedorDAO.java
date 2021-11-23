package com.sistema.DAO;

import com.sistema.Model.Cliente;
import com.sistema.Model.Fornecedor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO {

    static List<Fornecedor> fornecedores = new ArrayList<>();

    public void adicionarFornecedores(Fornecedor fornecedor){
        fornecedores.add(fornecedor);
        this.salvarFornecedores();
    }

    public void salvarFornecedores(){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Fornecedores.txt"));
            for (int i = 0; i < fornecedores.size(); i++){
                bufferedWriter.write(fornecedores.get(i).getIdFornecedor() + "|" + fornecedores.get(i).getNomeFornecedor() + "|" +
                        fornecedores.get(i).getTelefoneFornecedor());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            Logger.getLogger(Fornecedor.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public void carregarFornecedores(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Fornecedores.txt"));
            while (true){
                String linha = bufferedReader.readLine();
                if (linha == null){
                    break;
                }else {
                    StringTokenizer stringTokenizer = new StringTokenizer(linha,"|");
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setIdFornecedor(Long.parseLong(stringTokenizer.nextToken()));
                    fornecedor.setNomeFornecedor(stringTokenizer.nextToken());
                    fornecedor.setTelefoneFornecedor(Long.parseLong(stringTokenizer.nextToken()));
                    fornecedores.add(fornecedor);
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println("Erro em ler arquivo dos Fornecedores.");
        }
    }

    public void editarFornecedor(int i, String conteudo, int opcao){
        switch (opcao){
            case 1:
                fornecedores.get(i).setNomeFornecedor(conteudo);
                this.salvarFornecedores();
                break;
            case 2:
                fornecedores.get(i).setTelefoneFornecedor(Long.parseLong(conteudo));
                this.salvarFornecedores();
                break;
        }
    }

    public void removerFornecedor(int i){
        fornecedores.remove(i);
        this.salvarFornecedores();
    }

    public List<Fornecedor> listarFornecedores(){
        return fornecedores;
    }

}

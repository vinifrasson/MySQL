package com.sistema.DAO;

import com.sistema.Model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    static List<Cliente> clientes = new ArrayList<>();

    public void adicionarClientes(Cliente cliente) {
        clientes.add(cliente);
        this.salvarClientes();
    }

    public void salvarClientes() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Clientes.txt"));
            for (int i = 0; i < clientes.size(); i++) {
                bufferedWriter.write(clientes.get(i).getIdCliente() + "|" + clientes.get(i).getNomeCliente() +
                        "|" + clientes.get(i).getTelefoneCliente());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }



    public void carregarClientes() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Clientes.txt"));
            while (true) {
                String linha = bufferedReader.readLine();
                if (linha == null) {
                    break;
                } else {
                    StringTokenizer stringTokenizer = new StringTokenizer(linha, "|");
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(Long.parseLong(stringTokenizer.nextToken()));
                    cliente.setNomeCliente(stringTokenizer.nextToken());
                    cliente.setTelefoneCliente(Long.parseLong(stringTokenizer.nextToken()));
                    clientes.add(cliente);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro em ler arquivo dos Clientes.");
        }
    }

    public void editarCliente(int i, String conteudo, int opcao){
        switch (opcao){
            case 1:
                clientes.get(i).setNomeCliente(conteudo);
                this.salvarClientes();
                break;
            case 2:
                clientes.get(i).setTelefoneCliente(Long.parseLong(conteudo));
                this.salvarClientes();
                break;
        }
    }

    public void removerCliente(int i) {
        clientes.remove(i);
        this.salvarClientes();
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

}

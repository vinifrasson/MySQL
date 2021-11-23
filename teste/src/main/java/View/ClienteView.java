package com.sistema.View;

import com.sistema.Controller.ClienteController;
import com.sistema.Controller.IdClienteController;
import com.sistema.Model.Cliente;

import java.util.List;
import java.util.Scanner;


public class ClienteView {

    IdClienteController idClienteController = new IdClienteController();
    ClienteController clienteController = new ClienteController();
    Scanner input = new Scanner(System.in);

    public void cadastrarCliente() {

        Cliente cliente = new Cliente();

        System.out.print("Nome do cliente: ");
        cliente.setNomeCliente(input.nextLine());
        System.out.print("Telefone: ");
        cliente.setTelefoneCliente(Long.parseLong(input.nextLine()));
        cliente.setIdCliente(idClienteController.determinarId());

        clienteController.adicionarClientes(cliente);
        System.out.println(cliente);

    }

    public void removerCliente() {
        this.listarClientes();
        System.out.print("Escolha o Cliente a ser removido a partir da posição.\nQual Cliente você deseja excluir?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        clienteController.removerCliente(escolha);
        System.out.println("Cliente da posição " + escolha + " excluido com sucesso!");
    }

    public void editarCliente(){
        this.listarClientes();
        System.out.print("Escolha o Cliente a ser editado pela posição.\nQual Cliente você deseja editar?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        System.out.print("1 - Nome do Cliente\n2 - Telefone do Cliente\n-> ");
        int opcao = Integer.parseInt(input.nextLine());

        if (opcao == 1){
            System.out.println("Insira o novo Nome do Cliente: ");
            String novoNomeCliente = input.nextLine();
            clienteController.editarCliente(escolha,novoNomeCliente,opcao);
            System.out.println("Cliente editado com sucesso!");
        }
        else if (opcao == 2){
            System.out.println("Insira o novo Numero de Telefone do Cliente: ");
            Long novoTelefoneCliente = Long.parseLong(input.nextLine());
            clienteController.editarCliente(escolha, String.valueOf(novoTelefoneCliente),opcao);
            System.out.println("Cliente editado com sucesso!");
        }
        else {
            System.out.println("Opção Invalida.Tente Novamente.");
            this.editarCliente();
        }
    }

    public void listarClientes() {

        List<Cliente> clientes = clienteController.listarClientes();
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Posição: " + i + " | Nome do Cliente: " + clientes.get(i).getNomeCliente()
                    + " | Telefone do Cliente: " + clientes.get(i).getTelefoneCliente());
        }
    }
}


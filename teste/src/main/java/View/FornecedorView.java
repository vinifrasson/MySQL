package com.sistema.View;
import com.sistema.Controller.FornecedorController;
import com.sistema.Controller.IdFornecedorController;
import com.sistema.Model.Fornecedor;

import java.util.List;
import java.util.Scanner;


public class FornecedorView {

    Scanner input = new Scanner(System.in);
    IdFornecedorController idFornecedorController = new IdFornecedorController();
    FornecedorController fornecedorController = new FornecedorController();

    public void cadastrarFornecedor(){
        Fornecedor fornecedor = new Fornecedor();

        System.out.print("Insira o Nome do Fornecedor: ");
        fornecedor.setNomeFornecedor(input.nextLine());
        System.out.print("Insira o Numero de Telefone do Fornecedor: ");
        fornecedor.setTelefoneFornecedor(Long.parseLong(input.nextLine()));
        fornecedor.setIdFornecedor(idFornecedorController.determinarId());

        fornecedorController.adicionarFornecedores(fornecedor);
        System.out.println(fornecedor);
    }

    public void removerFornecedor(){
        this.listarFornecedores();
        System.out.print("Escolha o Fornecedor a ser removido a partir da posição.\nQual Fornecedor você deseja excluir?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        fornecedorController.removerFornecedor(escolha);
        System.out.println("Fornecedor da posição " + escolha + " excluido com sucesso!");
    }

    public void editarFornecedor(){
        this.listarFornecedores();
        System.out.print("Escolha o Fornecedor a ser editado pela posição.\nQual Fornecedor você deseja editar?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        System.out.print("1 - Nome do Fornecedor\n2 - Telefone do Fornecedor\n-> ");
        int opcao = Integer.parseInt(input.nextLine());

        if (opcao == 1){
            System.out.println("Insira o novo Nome do Fornecedor: ");
            String novoNomeFornecedor = input.nextLine();
            fornecedorController.editarFornecedor(escolha,novoNomeFornecedor,opcao);
            System.out.println("Nome do Fornecedor editado com sucesso!");
        }
        else if (opcao == 2){
            System.out.println("Insira o novo Numero de Telefone do Fornecedor: ");
            Long novoTelefoneFornecedor = Long.parseLong(input.nextLine());
            fornecedorController.editarFornecedor(escolha, String.valueOf(novoTelefoneFornecedor),opcao);
            System.out.println("Cliente editado com sucesso!");
        }
        else {
            System.out.println("Opção Invalida.Tente Novamente.");
            this.editarFornecedor();
        }
    }

    public void listarFornecedores(){
        List<Fornecedor> fornecedores = fornecedorController.listarFornecedores();
        for (int i = 0; i < fornecedores.size(); i++){
            System.out.println("Posição: " + i + " | Nome do Fornecedor: " +
                    fornecedores.get(i).getNomeFornecedor() +
                    " | Numero de Telefone do Fornecedor: " + fornecedores.get(i).getTelefoneFornecedor());
        }
    }

}

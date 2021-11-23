package com.sistema.View;

import com.sistema.Controller.FuncionarioController;
import com.sistema.Controller.IdFuncionarioController;
import com.sistema.Model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioView {

    Scanner input = new Scanner(System.in);
    FuncionarioController funcionarioController = new FuncionarioController();
    IdFuncionarioController idFuncionarioController = new IdFuncionarioController();

    public void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();

        System.out.print("Nome do Funcionário: ");
        funcionario.setNomeFuncionario(input.nextLine());
        System.out.print("Número de Identidade do Funcionário: ");
        funcionario.setNumIdentidadeFuncionario(Long.parseLong(input.nextLine()));
        System.out.print("Numero de Telefone do Funcionário: ");
        funcionario.setTelefoneFuncionario(Long.parseLong(input.nextLine()));
        System.out.print("Sálario do Funcionário: R$");
        funcionario.setSalarioFuncionario(Double.parseDouble(input.nextLine()));
        funcionario.setIdFuncionario(idFuncionarioController.determinarId());

        funcionarioController.adicionarFuncionario(funcionario);
        System.out.print(funcionario);
    }

    public void removerFuncionario(){
        this.listarFuncionarios();
        System.out.print("Escolha o Funcionario a ser removido a partir da posição.\nQual Funcionario você deseja excluir?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        funcionarioController.removerFuncionario(escolha);
        System.out.println("Funcionario da posição" + escolha + " excluido com sucesso!");
    }

    public void editarFuncionario(){
        this.listarFuncionarios();
        System.out.print("Escolha o Funcionario a ser editado pela posição.\nQual Funcionario você deseja editar?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        System.out.print("1 - Nome do Funcionario\n2 - Numero de Indentidade do Funcionario\n3 - Telefone do Funcionario\n4 - Sálario do Funcionario\n-> ");
        int opcao = Integer.parseInt(input.nextLine());

        if (opcao == 1){
            System.out.print("Insira o novo Nome do Funcionario: ");
            String novoNomeFuncionario = input.nextLine();
            funcionarioController.editarFuncionario(escolha,novoNomeFuncionario,opcao);
            System.out.println("Nome do Funcionario editado com sucesso!");
        }
        else if (opcao == 2){
            System.out.print("Insira o novo Numero de Indentidade do Funcionario: ");
            Long novoNumeroIndentidadeFuncionario = Long.parseLong(input.nextLine());
            funcionarioController.editarFuncionario(escolha, String.valueOf(novoNumeroIndentidadeFuncionario), opcao);
            System.out.println("Numero de Indentidade do Funcionario editado com sucesso!");
        }
        else if (opcao == 3){
            System.out.print("Insira o novo Numero de Telefone do Funcionario: ");
            Long novoTelefoneFuncionario = Long.parseLong(input.nextLine());
            funcionarioController.editarFuncionario(escolha, String.valueOf(novoTelefoneFuncionario),opcao);
            System.out.println("Numero de Telefone do Funcionario editado com sucesso!");
        }
        else if (opcao == 4){
            System.out.print("Insira o novo Salario do Funcionario: R$");
            Double novoSalarioFuncionario = Double.parseDouble(input.nextLine());
            funcionarioController.editarFuncionario(escolha, String.valueOf(novoSalarioFuncionario), opcao);
            System.out.println("Salario do Funcionario editado com sucesso!");
        }
        else {
            System.out.println("Opção Invalida.Tente Novamente.");
            this.editarFuncionario();
        }

    }

    public void listarFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();

        for (int i = 0; i < funcionarios.size(); i++){
            System.out.println("Posicão: " + i + " | Nome Do Funcionario: " + funcionarios.get(i).getNomeFuncionario()
                    + " | Número de Indentidade do Funcionario: " + funcionarios.get(i).getNumIdentidadeFuncionario() +
                    " | Numero de Telefone do Funcionario: " + funcionarios.get(i).getTelefoneFuncionario() +
                    "| Sálario do Funcionario: R$" + funcionarios.get(i).getSalarioFuncionario());
        }
    }


}

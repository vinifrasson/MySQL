package View;
import Controller.ProdutoController;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    ProdutoController produtoController = new ProdutoController();

    public void menuPrincipal() {

        while (true) {

            System.out.println("-------------Menu Principal-------------");
            System.out.println("-           1 > Produtos               -");
            System.out.println("-           2 > Funcionários           -");
            System.out.println("-           3 > Fornecedores           -");
            System.out.println("-           4 > Clientes               -");
            System.out.println("----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    menuProdutos();
                    break;
            }
        }
    }

    public int menuProdutos() {

        ProdutoView produtoView = new ProdutoView();
        while (true) {
            System.out.println("-------------Menu Produtos-------------");
            System.out.println("-       1 > Cadastrar Produtos        -");
            System.out.println("-       2 > Editar Produtos           -");
            System.out.println("-       3 > Remover Produtos          -");
            System.out.println("-       4 > Listar Produtos           -");
            System.out.println("-       5 > Voltar                    -");
            System.out.println("---------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    produtoView.cadastrarProduto();
                    break;
                case 2:
                    produtoView.editarProduto();
                    break;
                case 3:
                    produtoView.removerProduto();
                    break;
                case 4:
                    produtoView.listarProdutos();
                    break;
                case 5:
                    return -1;

            }
        }
    }
    /*public int menuFuncionarios(){
        FuncionarioView funcionarioView = new FuncionarioView();
        while (true){
            System.out.println("------------Menu Funcionários-------------");
            System.out.println("-       1 > Cadastrar Funcionário        -");
            System.out.println("-       2 > Editar Funcionário           -");
            System.out.println("-       3 > Remover Funcionário          -");
            System.out.println("-       4 > Listar Funcionário           -");
            System.out.println("-       5 > Voltar                       -");
            System.out.println("------------------------------------------");

            int escolha = input.nextInt();
            switch (escolha){
                case 1:
                    funcionarioView.cadastrarFuncionario();
                    break;
                case 2:
                    funcionarioView.editarFuncionario();
                    break;
                case 3:
                    funcionarioView.removerFuncionario();
                    break;
                case 4:
                    funcionarioView.listarFuncionarios();
                    break;
                case 5:
                    return -1;
            }
        }
    }


    public int menuFornecedor(){

        FornecedorView fornecedorView = new FornecedorView();

        while(true){
            System.out.println("-------------Menu Fornecedor-------------");
            System.out.println("-       1 > Cadastrar Fornecedor        -");
            System.out.println("-       2 > Editar Fornecedor           -");
            System.out.println("-       3 > Remover Fornecedor          -");
            System.out.println("-       4 > Listar Fornecedor           -");
            System.out.println("-       5 > Voltar                      -");
            System.out.println("-----------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    fornecedorView.cadastrarFornecedor();
                    break;
                case 2:
                    fornecedorView.editarFornecedor();
                    break;
                case 3:
                    fornecedorView.removerFornecedor();
                    break;
                case 4:
                    fornecedorView.listarFornecedores();
                    break;
                case 5:
                    return -1;
            }
        }
    }

    public int menuClientes() {

        ClienteView clienteView = new ClienteView();

        while (true) {
            System.out.println("-------------Menu Clientes-------------");
            System.out.println("-       1 > Cadastrar Cliente         -");
            System.out.println("-       2 > Editar Cliente            -");
            System.out.println("-       3 > Remover Cliente           -");
            System.out.println("-       4 > Listar Clientes           -");
            System.out.println("-       5 > Voltar                    -");
            System.out.println("---------------------------------------");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    clienteView.cadastrarCliente();
                    break;
                case 2:
                    clienteView.editarCliente();
                    break;
                case 3:
                    clienteView.removerCliente();
                    break;
                case 4:
                    clienteView.listarClientes();
                    break;
                case 5:
                    return  -1;
            }
        }
    }*/
}


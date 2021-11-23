package View;

import com.sistema.Controller.IdProdutoController;
import Controller.ProdutoController;
import Model.Produto;
import java.util.List;
import java.util.Scanner;

public class ProdutoView {

    IdProdutoController idProdutoController = new IdProdutoController();
    ProdutoController produtoController = new ProdutoController();
    Scanner input = new Scanner(System.in);

    public void cadastrarProduto() {
        Produto produto = new Produto();

        System.out.print("Nome do produto: ");
        produto.setNomeProduto(input.nextLine());
        System.out.print("Quantiade: ");
        produto.setQuantProduto(Long.parseLong(input.nextLine()));
        System.out.print("Codigo de Barras: ");
        produto.setCodigoDeBarras(Long.parseLong(input.nextLine()));
        System.out.print("Valor de custo: R$");
        produto.setValorCusto(Double.parseDouble(input.nextLine()));
        System.out.print("Valor de venda: R$");
        produto.setValorVenda(Double.parseDouble(input.nextLine()));
        //produto.setIdProduto(idProdutoController.determinarId());

        produtoController.adicionarProdutos(produto);
        System.out.println(produto);
    }
    public void removerProduto() {
        produtoController.listarProdutos();
        System.out.print("Escolha o produto a ser removido a partir da posição.\nQual Produto você deseja excluir?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        produtoController.removerProduto();
        System.out.println("Produto da posição " + escolha + " excluido com sucesso!");
    }
    public void editarProduto() {
        produtoController.listarProdutos();
        System.out.print("Escolha o Produto a ser editado pela posição.\nQual Produto você deseja editar?\n-> ");
        int escolha = Integer.parseInt(input.nextLine());
        System.out.print("1 - Nome do Produto\n2 - Quantidade do Produto\n3 - Codigo de Barras\n4 - Valor de Custo do Produto\n5 - Valor de Venda do Produto\n-> ");
        int opcao = Integer.parseInt(input.nextLine());

        if (opcao == 1){
            System.out.print("Insira o novo Nome do Produto: ");
            String novoNomeProduto = input.nextLine();
            produtoController.editarProduto(escolha,novoNomeProduto,opcao);
            System.out.println("Produto editado com sucesso!");
        }
        else if (opcao == 2){
            System.out.print("Insira a nova Quantidade do Produto: ");
            Long novoQuantidade = Long.parseLong(input.nextLine());
            produtoController.editarProduto(escolha, String.valueOf(novoQuantidade),opcao);
            System.out.println("Produto editado com sucesso!");
        }
        else if (opcao == 3){
            System.out.print("Insira o novo Codigo de Barras do Produto: ");
            Long novoCodigoDeBarras = Long.parseLong(input.nextLine());
            produtoController.editarProduto(escolha, String.valueOf(novoCodigoDeBarras),opcao);
            System.out.println("Produto editado com sucesso!");
        }
        else if (opcao == 4){
            System.out.print("Insira um novo Valor de Custo do Produto: R$");
            Double novoValorDeCusto = Double.parseDouble(input.nextLine());
            produtoController.editarProduto(escolha, String.valueOf(novoValorDeCusto),opcao);
            System.out.println("Produto editado com sucesso!");
        }
        else if (opcao == 5){
            System.out.print("Insira um novo Valor de Venda do Produto: R$");
            Double novoValorDeVenda = Double.parseDouble(input.nextLine());
            produtoController.editarProduto(escolha,String.valueOf(novoValorDeVenda),opcao);
            System.out.println("Produto editado com sucesso!");
        }

        else {
            System.out.println("Opção Invalida.Tente novamente.");
            this.editarProduto();
        }
    }
    public void listarProdutos() {
        List<Produto> produtos = produtoController.listarProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("Posição " + i + " | Nome do produto: " + produtos.get(i).getNomeProduto() + " | Quantidade: "
                    + produtos.get(i).getQuantProduto() + " | Codigo de Barras: " + produtos.get(i).getCodigoDeBarras() +
                    " | Valor de Custo: R$" + produtos.get(i).getValorCusto() + " | Valor de Venda: R$"
                    + produtos.get(i).getValorVenda());
        }
    }

}

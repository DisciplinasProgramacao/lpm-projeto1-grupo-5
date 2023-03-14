package gestaoEstoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


//		System.out.print("\nDigite a descrição do produto: ");
//		String descricao = scanner.next();
//
//		System.out.print("\nDigite o preço de custo do produto: ");
//		double precoCusto = scanner.nextDouble();
//
//		System.out.print("\nDigite a quantidade atual em estoque do produto: ");
//		int quantidadeAtual = scanner.nextInt();
//
//		System.out.print("\nDigite a quantidade mínima necessária em estoque do produto: ");
//		int quantidadeMinima = scanner.nextInt();

// 		Produto produto = new Produto(descricao, precoCusto, quantidadeAtual, quantidadeMinima);


        //Criar 5 produtos
        Produto produto1 = new Produto("Televisao", 100, 10, 2);
        Produto produto2 = new Produto("Microondas", 50, 9, 4);
        Produto produto3 = new Produto("Geladeira", 65, 4, 1);
        Produto produto4 = new Produto("Cadeira", 30, 15, 10);
        Produto produto5 = new Produto("Mesa", 50, 3, 2);

        //Add os 5 produtos no estoque
        Estoque estoque = new Estoque(5);
        estoque.addProdutoNoEstoque(produto1);
        estoque.addProdutoNoEstoque(produto2);
        estoque.addProdutoNoEstoque(produto3);
        estoque.addProdutoNoEstoque(produto4);
        estoque.addProdutoNoEstoque(produto5);


        //==========MENU==========
        int opcao = 0;

        while (opcao != -1) {
            System.out.println();

            System.out.println("1 - Vender produto");
            System.out.println("2 - Repor produto");
            System.out.println("3 - Retirar produto");


            System.out.println("4 - Verificar Informações gerais do estoque");
            System.out.println("5 - Consultar Produto");
            System.out.println("6 - Balanço Simplificado");
            System.out.println("7 - Lista Produtos");


            System.out.println("0 - Encerrar programa");
            System.out.println("Digite a opção desejada: ");


            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Produto produtoAux = (escolherProduto(estoque));
                    System.out.println("Digite a quantidade a ser vendida: ");
                    int quantidade = scanner.nextInt();
                    System.out.println("Foram vendidos R$" + estoque.vender(produtoAux, quantidade));
                    break;

                case 2:
                    produtoAux = (escolherProduto(estoque));

                    System.out.print("Digite a quantidade a ser reposta (comprada): ");
                    quantidade = scanner.nextInt();

                    if (estoque.reporEstoqueProduto(produtoAux, quantidade)) {
                        System.out.println("Compra efetuada com sucesso!");
                    } else
                        System.out.println("Não foi possivel comprar!");

                    break;

                case 3:
                    produtoAux = (escolherProduto(estoque));

                    if (estoque.retiraProdutoEstoque(produtoAux)) {
                        System.out.println("Produto removido!");
                    } else
                        System.out.println("Não foi possivel remover o produto!");
                    break;

                case 4:
                    List<Produto> listaProdutosQtdMin = new ArrayList<>(estoque.produtosEstoqueAbaixoMin());

                    if (listaProdutosQtdMin.size() > 0) {
                        System.out.println(listaProdutosQtdMin);
                    } else {
                        System.out.println("Todos os produtos estão acima da quantidade mínima.");
                    }
                    System.out.println("Quantidade total de produtos no estoque:" + estoque.qtdProdutosEstoque());
                    System.out.println("Valor total do estoque: " + estoque.valorTotalEstoque());
                    break;

                case 5:
                    produtoAux = (escolherProduto(estoque));
                    System.out.println(produtoAux);

                    break;


                case 6:
                    System.out.println("Valor total do estoque: " + estoque.valorTotalEstoque());
                    System.out.println("Valor total vendido: " + estoque.getValorTotalVendido());
                    System.out.println("Valor total de reposições: " + estoque.getValorTotalReposicao());

                    break;

                case 7:
                    System.out.println("Listando todo o estoque:");
                    System.out.println(estoque.produtosEstoque());
                    break;

                default:
                    if (opcao == 0) {
                        System.out.println("\n\nEncerrando Programa!");
                        opcao = -1;
                    }
                    break;
            }
        }

    }

    public static Produto escolherProduto(Estoque estoque) {

        System.out.println("Digite o ID do produto que deseja modificar:");
        int IDproduto = scanner.nextInt();

        Produto produtoAux = estoque.acessaProduto(IDproduto);

        if (produtoAux == null) {
            System.out.println("Produto não encontrado no estoque!");

            return null;
        }

        return produtoAux;
    }
}



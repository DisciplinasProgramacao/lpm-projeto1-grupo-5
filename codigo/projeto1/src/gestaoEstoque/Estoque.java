package gestaoEstoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private double valorTotalReposicao;
    private double valorTotalVendido;
    private List<Produto> listaProdutos;

    /**
     * Construtor do Estoque
     */
    public Estoque(int qtdProdutos) {
        if (qtdProdutos >= 0)
            listaProdutos = new ArrayList<>(qtdProdutos);
    }

    /**
     * Adiciona um produto na lista de produtos do estoque
     * <p>
     *
     * @param produto novo produto
     */
    public void addProdutoNoEstoque(Produto produto) {
        listaProdutos.add(produto);
    }

    /**
     * Verifica quantos produtos constam no estoque
     *
     * @return Retorna um inteiro
     */
    public int qtdProdutosEstoque() {
        return listaProdutos.size();
    }

    /**
     * Verifica o valor total do estoque atual
     *
     * @return Retorna um double
     */
    public double valorTotalEstoque() {
        double valorEstoque = 0;
        if (!estoqueVazio()) {
            for (Produto produto : listaProdutos) {
                valorEstoque += (produto.getPrecoCusto() * produto.getQuantidadeAtual());
            }
        }
        return valorEstoque;
    }

    /**
     * Verifica se o estoque esta vazio
     *
     * @return Retorna booleano
     */
    private boolean estoqueVazio() {
        if (qtdProdutosEstoque() > 0)
            return false;
        else
            return true;
    }

    /**
     * Verifica quais são os produtos atuais com estoque abaixo do mínimo
     *
     * @return Retorna uma lista de produtos com estoque abaixo do mínimo
     */
    public List<Produto> produtosEstoqueAbaixoMin() {
        List<Produto> listaProdutosQtdMin = new ArrayList<>();
        if (!estoqueVazio()) {
            for (Produto produto : listaProdutos) {
                if (produto.isQuantidadeMinima())
                    listaProdutosQtdMin.add(produto);
            }
        }
        return listaProdutosQtdMin;
    }

    /**
     * Retira um produto do estoque
     * <p>
     *
     * @param prod Produto a ser removido
     *                        <p>
     * @return Retorna true se produto foi excluído ou false se não foi
     */
    public boolean retiraProdutoEstoque(Produto prod) {
        int index;
        if (!estoqueVazio()) {
            index = listaProdutos.indexOf(prod);
            if (index != -1) {
                listaProdutos.remove(index);
                return true;
            }
        }
        return false;
    }


    public boolean vender(Produto produto, int quantidade){
        int index;
        if (!estoqueVazio()) {
            index = listaProdutos.indexOf(produto);
            if (index != -1) {
                valorTotalVendido += produto.vender(quantidade);
                return true;

            }
        }
        return false;
    }

    /**
     * Compra mais unidades de um produto
     * <p>
     *
     * @param produto Produto a ser comprado
     * @param un      Quantidade de unidades do produto a ser comprado
     *                <p>
     * @return Retorna true se produto foi comprado ou false se não foi
     */

    public boolean reporEstoqueProduto(Produto produto, int un) {
        int index;
        if (!estoqueVazio()) {
            index = listaProdutos.indexOf(produto);
            if (index != -1) {
                valorTotalReposicao += produto.comprar(un);
                return true;
            }
        }
        return false;
    }

    /**
     * Lista de produtos existentes no estoque
     * <p>
     *
     * @return Retorna uma lista de produtos
     */
    public List<Produto> produtosEstoque() {
        return listaProdutos;
    }


    /**
     * Acessa o produto que o usuario escolheu*
     * @return Retorna um produto
     */
    public Produto acessaProduto(int ID){
        for (Produto p : produtosEstoque()) {
            if(ID == p.getID()){
                return p;
            }
        }
        return null;
    }


    public double getValorTotalVendido() {
        return valorTotalVendido;
    }

    public double getValorTotalReposicao() {
        return valorTotalReposicao;
    }
}
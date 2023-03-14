/**
 * Classe Estoque desenvolvida em TDD
 */
package gestaoEstoque;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

/**
 * @author Ana Carolina Correa
 *
 */
class EstoqueTest {

    private Estoque meuEstoque;
    private Produto produtoTeste;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        meuEstoque = new Estoque(3);
    }

    @Test
    void adicionaProdutoNoEstoque() {
        produtoTeste = new Produto("Produto 1 - teste Estoque", 100, 5, 2);
        meuEstoque.addProdutoNoEstoque(produtoTeste);
        assertEquals(1, meuEstoque.qtdProdutosEstoque());
    }

    void preencheEstoque() {
        // Descricao; Preco de custo; Quantidade atual; Quantidade minima
        produtoTeste = new Produto("Produto 1 - teste Estoque", 100, 5, 2);
        meuEstoque.addProdutoNoEstoque(produtoTeste);
        produtoTeste = new Produto("Produto 2 - teste Estoque", 500, 3, 4);
        meuEstoque.addProdutoNoEstoque(produtoTeste);
    }

    @Test
    void qtdProdutosEstoqueVazio() {
        assertEquals(0, meuEstoque.qtdProdutosEstoque());
    }

    @Test
    void qtdProdutosEstoquePreenchido() {
        preencheEstoque();
        assertEquals(2, meuEstoque.qtdProdutosEstoque());
    }

    @Test
    void calculaValorEstoque() {
        preencheEstoque();
        assertEquals(2000, meuEstoque.valorTotalEstoque());
    }

    @Test
    void calculaValorEstoqueVazio() {
        assertEquals(0, meuEstoque.valorTotalEstoque());
    }

    @Test
    void produtoComEstoqueAbaixoDoMin() {
        List<Produto> listaProdutosQtdMin;
        preencheEstoque();

        listaProdutosQtdMin = meuEstoque.produtosEstoqueAbaixoMin();
        assertEquals(1, listaProdutosQtdMin.size());
    }

    @Test
    void retiraProdutosExistentesDoEstoque() {
        preencheEstoque();
        produtoTeste = new Produto("Produto 3 - teste Estoque", 10, 0, 2);
        meuEstoque.addProdutoNoEstoque(produtoTeste);

        assertTrue(meuEstoque.retiraProdutoEstoque(produtoTeste));
        assertEquals(2, meuEstoque.qtdProdutosEstoque());
    }

    @Test
    void retiraProdutosInexistentesDoEstoque() {
        preencheEstoque();
        produtoTeste = new Produto("Produto 3 - teste Estoque", 10, 0, 2);

        assertFalse(meuEstoque.retiraProdutoEstoque(produtoTeste));
        assertEquals(2, meuEstoque.qtdProdutosEstoque());
    }

    @Test
    void reporEstoque() {
        produtoTeste = new Produto("Produto 3 - teste Estoque", 10, 0, 2);
        meuEstoque.addProdutoNoEstoque(produtoTeste);

        assertTrue(meuEstoque.reporEstoqueProduto(produtoTeste, 5));
        assertEquals(5, produtoTeste.getQuantidadeAtual());
    }

    @Test
    void reporEstoqueProdutoInexistente() {
        produtoTeste = new Produto("Produto 3 - teste Estoque", 10, 0, 2);

        assertFalse(meuEstoque.reporEstoqueProduto(produtoTeste, 5));
    }

    @Test
    void confereListaEstoque() {
        List<Produto> listaProdTeste = new ArrayList<Produto>(2);

        preencheEstoque();
        produtoTeste = new Produto("Produto 1 - teste Estoque", 100, 5, 2);
        listaProdTeste.add(produtoTeste);
        produtoTeste = new Produto("Produto 2 - teste Estoque", 500, 3, 4);
        listaProdTeste.add(produtoTeste);

        assertEquals(listaProdTeste.size(), meuEstoque.produtosEstoque().size());
    }

    @Test
    void deveAcessarProduto(){
        assertEquals(produtoTeste, meuEstoque.acessaProduto(2));
    }

}
package gestaoEstoque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    Produto produto;
    @BeforeEach
    public void prepare(){
        produto = new Produto(
                "pão de forma",
                10,
                25,
                5
        );
    }

    @Test
    public void deveVerificarAMargemDeLucro(){
        produto.calculaMargemLucro();
        assertEquals(5.5, produto.getMargemLucro());
    }

    @Test
    public void deveVerificarOValorDoImposto(){
        produto.calculaValorImpostos();
        assertEquals(2.79, produto.getValorImposto());
    }

    @Test
    public void deveVerificarOPrecoDeVenda(){
        produto.calculaMargemLucro();
        produto.calculaValorImpostos();
        produto.calculaPrecoDeVenda();

        assertEquals(18.29, produto.getPrecoVenda());
    }

    @Test
    public void deveVerificarVendaComEstoqueInsuficiente(){
        String venda = produto.vender(30);
        assertTrue(venda.contains("Quantidade insuficiente em estoque"));
    }

    @Test
    public void deveVerificarVenda(){
        String venda = produto.vender(3);
        produto.calculaPrecoDeVenda();

        assertEquals(22, produto.getQuantidadeAtual());
        assertEquals(54.87, produto.getValorArrecadado());
        assertTrue(venda.contains("Venda realizada com sucesso! Valor arrecadado: R$54,87"));
    }

    @Test
    public void deveVerificarCompra(){
        produto.comprar(10, 4);

        assertEquals(35, produto.getQuantidadeAtual());
        assertEquals(40, produto.getCustoAquisicao());
    }

    @Test
    public void deveVerificarOEstoque(){
        produto.setQuantidadeAtual(4);
        assertTrue(produto.verificarEstoque());
    }
}

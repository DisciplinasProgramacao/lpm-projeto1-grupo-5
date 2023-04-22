package gestaoEstoque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    Produto produto;

    @BeforeEach
    public void prepare() {
        produto = new Produto("pão de forma", 10, 4, 5);
    }

    @Test
    public void deveVerificarAMargemDeLucro() {
        assertEquals(5.5, produto.calculaMargemLucro());
    }

    @Test
    public void deveVerificarOValorDoImposto() {
        assertEquals(2.79, produto.calculaValorImpostos());
    }

    @Test
    public void deveVerificarOPrecoDeVenda() {
        produto.calculaMargemLucro();
        produto.calculaValorImpostos();

        assertEquals(18.29, produto.calculaPrecoDeVenda());
    }

    @Test
    public void deveVerificarVendaComEstoqueInsuficiente() {
        assertEquals(0, produto.vender(30));
    }

    @Test
    public void naoPodeVenderNegativo() { //adicionado por Joao (falha)
        produto.vender(-1);
        assertEquals(4,produto.getQuantidadeAtual());
    }

    @Test
    public void deveVerificarVenda() {
        assertEquals(54.87, produto.vender(3));
        assertEquals(1, produto.getQuantidadeAtual());
    }

    @Test
    public void deveVerificarCompra() {
        assertEquals(50, produto.comprar(5));
        
    }

    @Test public void naoPodeComprarNegativo(){     //adicionado por Joao (falha)
        assertEquals(0, produto.comprar(-5));
    }

    @Test
    public void deveVerificarOEstoque() {
        assertTrue(produto.isQuantidadeMinima());
    }

    @Test
    public void deveAtualizarPrecoDeCusto( ) {
        produto.atualizarPrecoCusto(25);
        assertEquals(25, produto.getPrecoCusto());
    }
}

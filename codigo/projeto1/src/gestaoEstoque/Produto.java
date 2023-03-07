package gestaoEstoque;

import java.text.DecimalFormat;

public class Produto {

	private String descricao;
	private double precoCusto;
	private double precoDeVenda;
	private int quantidadeAtual;
    private int quantidadeMinima;

	private double margemLucro;
	private double valorImpostos;

	private double valorArrecadado;
    private double custoAquisicao;
	
	/**
	 * Construtor do Produto
	 * @param descricao
	 * @param precoCusto
	 * @param quantidadeAtual
	 * @param quantidadeMinima
	 */
	public Produto(String descricao, double precoCusto, int quantidadeAtual, int quantidadeMinima) {
		if(validaDescricao(descricao)) {
			this.descricao=descricao;
		}
		this.precoCusto=precoCusto;
		this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
        calculaPrecoDeVenda();
	}

	/**
	 * Gets e Sets
	 */
	public String getDescricao() {
        return descricao;
    }

	public double getPrecoCusto() {
        return precoCusto;
    }

	public double getPrecoVenda() {
        return precoDeVenda;
    }

	public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

	public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

	public double getMargemLucro() {
        return margemLucro;
    }

	public double getValorImposto() {
        return valorImpostos;
    }

	public double getValorArrecadado() {
        return valorArrecadado;
    }

	public double getCustoAquisicao() {
        return custoAquisicao;
    }

	public void setQuantidadeAtual(int quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}

	/**
	 * Validar se a descricao possui no minimo 3 caracteres
	*/
	public boolean validaDescricao(String descricao) {
		if(descricao.length()<3) {
			return false;
		} else return true;
	}
	
	/**
	 * A margem de lucro de um produto sempre é entre 30 e 80% do valor do preço de custo. (valor adotado foi a media: 55% 
	*/
	public void calculaMargemLucro() {
		margemLucro= (precoCusto * 0.55);
	}
	
	/**
	 * O valor dos impostos é de 18% sobre a soma do custo e da margem de lucro. 
	*/
	public void calculaValorImpostos() {
		calculaMargemLucro();
	    valorImpostos =(0.18 * (margemLucro+precoCusto) );
	}

	/**
	 * Preco de venda = preço de custo + margem de lucro + valor dos impostos 
	*/
	public void calculaPrecoDeVenda() {
		calculaValorImpostos();
		precoDeVenda = precoCusto+valorImpostos+margemLucro;
	}

	/**
	 * Verifica se a quantidade do produto é maior que a quantidade atual em estoque, se for,
	 * imprime uma mensagem dizendo que não há quantidade suficiente em estoque, se não houver, subtrai
	 * a quantidade do produto a partir da quantidade atual em estoque, calcula o valor da venda,
	 * soma o valor da venda ao valor das vendas realizadas e imprime uma mensagem dizendo que a venda
	 * foi feito com sucesso.
	 * 
	 * @param quantidade a quantidade do produto que está sendo vendido
	*/
	public String vender(int quantidade) {

		DecimalFormat formatter = new DecimalFormat("#.00");

		if (quantidade > this.quantidadeAtual) {
			String semEstoque = "Quantidade insuficiente em estoque";
			System.out.println(semEstoque);
			return semEstoque;
		}
		this.quantidadeAtual -= quantidade;
		double valorVenda = quantidade * this.precoDeVenda;
		this.valorArrecadado += valorVenda;
		String sucesso = "\n\nVenda realizada com sucesso! Valor arrecadado: R$" + formatter.format(valorVenda);
		System.out.println(sucesso);
		return sucesso;
	}
    /**
	 * This function adds the quantity of the item purchased to the current quantity of the item and
	 * adds the cost of the item purchased to the current cost of the item
	 * 
	 * @param quantidade the amount of the product that was bought
	 * @param custo the cost of the item
	 */
	public void comprar(int quantidade, double custo) {
        this.quantidadeAtual += quantidade;
        this.custoAquisicao += quantidade * custo;
    }

	/**
	 * Verifica se a quantidade atual é menor que a quantidade mínima.
	 * 
	 * @return O tipo de retorno é booleano.
	 */
	public boolean verificarEstoque() {
        return this.quantidadeAtual < this.quantidadeMinima;
    }
	
	@Override
	public String toString() {
		return "\nProduto: " + descricao 
		   +  "   Quantidade: " + quantidadeAtual + "   Qunatidade Mínima: " + quantidadeMinima
		   + "   Preço: R$" + precoCusto + "   Preço Venda: R$" + precoDeVenda;
	}
}

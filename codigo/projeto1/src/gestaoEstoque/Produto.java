package gestaoEstoque;

public class Produto {

	private String descricao;
	private double precoCusto;
	private double precoVenda;
	private int quantidadeAtual;
	private int quantidadeMinima;
	// bigDecimal pra preço -> to-do
	private double margemLucro;
	private double valorImpostos;
	private double valorArrecadado;

	/**
	 * Construtor do Produto
	 *
	 * @param descricao
	 * @param precoCusto
	 * @param quantidadeAtual
	 * @param quantidadeMinima
	 * @return
	 */
	public Produto(String descricao, double precoCusto, int quantidadeAtual, int quantidadeMinima) {
		if (validaDescricao(descricao)) {
			this.descricao = descricao;
		}
		this.precoCusto = precoCusto;
		this.quantidadeAtual = quantidadeAtual;
		this.quantidadeMinima = quantidadeMinima;
		calculaPrecoDeVenda();
	}

	/**
	 * Validar se a descricao possui no minimo 3 caracteres
	 */
	private boolean validaDescricao(String descricao) {
		if (descricao.length() < 3) {
			return false;
		} else
			return true;
	}

	/**
	 * A margem de lucro de um produto sempre é entre 30 e 80% do valor do preço de
	 * custo. (valor adotado foi a media: 55%
	 */
	public double calculaMargemLucro() {
		margemLucro = (precoCusto * 0.55);
		return margemLucro;
	}

	/**
	 * O valor dos impostos é de 18% sobre a soma do custo e da margem de lucro.
	 */
	public double calculaValorImpostos() {
		calculaMargemLucro();
		valorImpostos = (0.18 * (margemLucro + precoCusto));
		return valorImpostos;
	}

	/**
	 * Preco de venda = preço de custo + margem de lucro + valor dos impostos
	 */
	public double calculaPrecoDeVenda() {
		calculaValorImpostos();
		precoVenda = precoCusto + valorImpostos + margemLucro;
		return precoVenda;
	}

	/**
	 * Verifica se a quantidade do produto é maior que a quantidade atual em
	 * estoque, se for, imprime uma mensagem dizendo que não há quantidade
	 * suficiente em estoque, se não houver, subtrai a quantidade do produto a
	 * partir da quantidade atual em estoque, calcula o valor da venda, soma o valor
	 * da venda ao valor das vendas realizadas e imprime uma mensagem dizendo que a
	 * venda foi feito com sucesso.
	 *
	 * @param quantidade a quantidade do produto que está sendo vendido
	 */
	public double vender(int quantidade) {

		if (quantidade > this.quantidadeAtual) {
			return valorArrecadado;
		}
		this.quantidadeAtual -= quantidade;
		double valorVenda = quantidade * this.precoVenda;
		this.valorArrecadado += valorVenda;
		return valorArrecadado;
	}

	/**
	 * Esta função adiciona a quantidade do item comprado à quantidade atual do item
	 * e adiciona o custo do item comprado ao custo atual do item
	 *
	 * @param quantidade Quantidade do produto sendo comprado
	 * @param custo      Custo do item
	 */
	public int comprar(int quantidade) {
		this.quantidadeAtual += quantidade;
		return quantidadeAtual;
	}

	/**
	 * Verifica se a quantidade atual é menor que a quantidade mínima.
	 *
	 * @return O tipo de retorno é booleano.
	 */
	public boolean isQuantidadeMinima() {
		return this.quantidadeAtual < this.quantidadeMinima;
	}

	/**
	 * Atualiza o preço de custo de um produto
	 *
	 * @param custo Custo do item
	 */
	public void atualizarPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	@Override
	public String toString() {
		return "\nProduto: " + descricao + "   Quantidade: " + quantidadeAtual + "   Qunatidade Mínima: "
				+ quantidadeMinima + "   Preço: R$" + precoCusto + "   Preço Venda: R$" + precoVenda;
	}

	/**
	 * Gets e Sets
	 */

	public double getQuantidadeAtual() {
		return quantidadeAtual;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

}

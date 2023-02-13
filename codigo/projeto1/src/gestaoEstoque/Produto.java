package gestaoEstoque;

public class Produto {

	String descricao;
	double precoCusto;
	double margemLucro;
	double valorImpostos;
	double precoDeVenda;
	
	public Produto(String descricao, double precoCusto) {
		
		if(validaDescricao(descricao)) {
			this.descricao=descricao;
		}
		this.precoCusto=precoCusto;
	}
	
	/** validar se a descricao possui no minimo 3 caracteres*/
	public boolean validaDescricao(String descricao) {
		
		if(descricao.length()<3) {
			return false;
		} else return true;
	}
	
	//A margem de lucro de um produto sempre é entre 30 e 80% do valor do preço de custo. (valor adotado foi a media: 55% 
	public void calculaMargemLucro() {
		margemLucro= (precoCusto* (55/100));
	}
	
	//O valor dos impostos é de 18% sobre a soma do custo e da margem de lucro. 
	public void calculaValorImpostos() {
		calculaMargemLucro();
	    valorImpostos =((18/100)* (margemLucro+precoCusto) );
	}
	
	//preco de venda = preço de custo + margem de lucro + valor dos impostos 
	public void calculaPrecoDeVenda() {
		calculaValorImpostos();
		precoDeVenda = precoCusto+valorImpostos+margemLucro;
	}
	

}

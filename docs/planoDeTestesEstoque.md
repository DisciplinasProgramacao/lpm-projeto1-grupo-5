# Plano de testes classe Estoque:

1. Testa o comportamento da lista de produtos existente no Estoque ao adicionar um novo produto
  - adicionaProdutoNoEstoque
2. Testa a quantidade de produtos existentes na lista de produtos sem ter nenhum adicionado 
  - qtdProdutosEstoqueVazio
3. Testa o retorno da quantidade de produtos existentes na lista ao adicionar produtos
  - qtdProdutosEstoquePreenchido
4. Calcula o valor de custo de todos os produtos do estoque
  - calculaValorEstoque
5. Calcula o valor de custo de todos os produtos com o estoque vazio
  - calculaValorEstoqueVazio
6. Verifica a quantidade de produtos com estoque abaixo do mínimo
  - produtoComEstoqueAbaixoDoMin
7. Retira um produto enviado por parâmetro da lista de produtos do estoque
  - retiraProdutosExistentesDoEstoque
8. Retira um produto inexistente enviado por parâmetro da lista de produtos do estoque
  - retiraProdutosInexistentesDoEstoque
9. Compra unidades de um produto (ambos dados passados por parametro) e verifica se teve sucesso na operação e a quantidade de produtos após a compra
  - reporEstoque
10. Compra unidades de um produto inexistente (ambos dados passados por parametro) e verifica se teve falha na operação
  - reporEstoqueProdutoInexistente
11. Verifica se o tamanho da lista retornada é o mesmo da lista criada
  - confereListaEstoque
12. Retorna um produto escolhido por ID pelo usuário
  - acessaProduto

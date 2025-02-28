#Projeto Ecommerce - EspacoMulher
Projeto Espaço Mulher Bijoux

## Atenção Leia atentamente as ISSUES que foram definidas para cada etapa do desenvolvimento desse projeto


Ideia dessa API é baseada nas necessidades que da cliente precisa para o pleno funcionamento do seu Comercio eletrônico.

Contexto Atual

Proprietária: Debora Grijó(Minha Irmã)
Modo  de operação: vendas a partir de grupos fechado de whatsapp e algumas clientes que são cativas e instagram.
Como é exibido o catálogo: Clientes  chegam através do contato do whatsapp e a Debora envia os catálogo para eles(fotos e valores)
Artes: o fornecedor envia as fotos com tratamento e tudo mais.
Detalhe: um produto pode ter variações de cor/banho e tais variações precisam estar vinculadas ao produto (mesmo que seja uma única variação). Exemplo: Anel com alguma pedra em diversas cores (vermelho, verde transparente, etc). Neste caso, cada variação teria uma foto diferente. É considerado o mesmo produto, entretanto ela precisa conhecer estas prováveis variações do produto. Outro exemplo é colar com pingente de letra (cada letra é uma variação do pingente).

Clientes da loja: Geralmente pessoas que tem pouca ou muita pouca habilidade com tecnologia. Perguntas que foram feitas e que demandariam esforços para a construção do software:
-As clientes precisam manter seus respectivos cadastros e acessos restritos para compras?
R: quanto mais simples para a cliente, melhor.
-Como elas poderiam se identificar? Email ou whatsapp

Sobre os Pedidos: Elas navegam pelo site e adicionam seus produtos no "Carrinho de compras". A partir daí, o carrinho de compras é enviado para a efetivação do pedido, juntamente com os dados cadastrais da cliente (ou apenas suas identificação)

Principais módulos(necessidades)do sistema
-Sistema deve ser capaz de cadastrar categorias de produtos(anéis, colares, pulseiras, pingentes)
-Sistema deve ser capaz de cadastrar produtos e suas respectivas variações(ex:pingente de várias cores)
-Sistema deve ser capaz de associar o produto ás suas respectivas categorias(ou mesmo excluir categorias)
-Sistema deve ser capaz de gerenciar pedidos(cadastrar, alterar status, etc)
-sistema deve ser capaz de mostrar pedidos feitos

Meios de pagamento
Neste caso por questão de escolha da Debora ela escolheu que na hora da finalização do pedido ela tivesse contato com suas clientes para finalizar e trazer mais humanização dessa forma, mas caso futuramente ela queira incluir meios de pagamentos também será possível adicionar.

Requisitos técnicos não presentes no sistema
 - Modelo de paginação de resultados
-API com acesso seguro para determinados recursos (ex:cadastro de produtos exclusivo para o administrador do sistema)
° 2 perfis identificados
    -Cliente da loja
    -Administrador do sistema
-configuração e testes deste serviço para disponibilizar os endpoints
-documentação da API completa com Swagger

Análise do problema(API pensada em microserviços tudo dentro da mesma API porem muito bem escalável)

Módulos principais  
°Categorias
°Produto e Variantes
°Pedidos
°Clientes
°Usuários
°Controle de acesso e validação

Abordagem do problema
-Para cada pequeno item, criei CRUD(operações Create, Read, Update e Delete), usando as boas práticas no modelo de desenvolvimento

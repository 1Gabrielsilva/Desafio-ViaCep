
	Feature: Consulta de frete por CEP através de uma API externa.

  Scenario: Verificar resultado de um pesquisa de um frete dado um cep válido
  	Given Que a minha aplicação esta inicializada
    When Eu pesquiso o cep "01001000"
    Then Eu encontro o frete
    
  Scenario: Verificar frete com cep invalido
  	Given Que a minha aplicação esta inicializada
    Then Eu recebo um CEP inválido
    
  Scenario: Verificar frete com cep inexistente
  	Given Que a minha aplicação esta inicializada
    Then Busca de um frete dado um cep inexistente
    


